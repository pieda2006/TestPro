package com.nec.corestudy.udm.NudmSDM.common.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import java.sql.*;
import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class UdrAccess {

    // DB information
    String keyName = null;	// setKeyName
    String tblName = null;	// setTblName

    // DB result data
    private static ResultSet rs = null;
    List<String> results = null;
    String result = null;

    int updateLineNum = -1;
    int retryCount = 2;
    boolean transactionCompleted = false;

    public static final Object executeQuerySyncLock = new Object();
    public static final Object executeConnectionSyncLock = new Object();
    public static final Object executeStatementSyncLock = new Object();

    private static final Logger log = LoggerFactory.getLogger(UdrAccess.class);

    void executeQuerySync(String query) throws SQLException,InterruptedException {
        log.debug("### executeQuerySync Start ###");
        log.debug("### Parameter : query : " + query);

        synchronized(executeQuerySyncLock) {
            while(rs != null) {
                wait();
            }
            rs = UdrInfo.stm.executeQuery(query);
            log.debug("executeQuery Success");

            while(rs.next()){
                results.add(rs.getString(tblName));
                log.debug("key : " + rs.getString(keyName));
                log.debug("json : " + rs.getString(tblName));
            }
            rs = null;
        }

        log.debug("### executeQuerySync End ###");
    }

    void executeConnectionSync() throws SQLException,Exception,InterruptedException {
        log.debug("### executeConnectionSync Start ###");

        synchronized(executeConnectionSyncLock) {
            if(UdrInfo.con == null) {
                UdrInfo.ds = BasicDataSourceFactory.createDataSource(UdrInfo.props);
                UdrInfo.con = UdrInfo.ds.getConnection();
                log.debug("getConnection Success");
            }
        }

        log.debug("### executeConnectionSync Start ###");
    }

    void executeStatementSync() throws SQLException,InterruptedException {
        log.debug("### executeStatementSync Start ###");

        synchronized(executeStatementSyncLock) {
            if (UdrInfo.stm == null) {
                UdrInfo.stm = UdrInfo.con.createStatement();
                log.debug("createStatement Success");
            }
        }

        log.debug("### executeStatementSync Start ###");
    }

    public void executeDb(String methodName, String query) {
        log.debug("### executeDb Start ###");
        log.debug("### Parameter : methodName : " + methodName);
        log.debug("### Parameter : query : " + query);

        retryCount = 2;
        transactionCompleted = false;

        do {
            log.debug("retryCount : " + retryCount);

            try {
                if (UdrInfo.con == null) {
                    executeConnectionSync();
                }
                if (UdrInfo.stm == null) {
                    executeStatementSync();
                }
                log.debug("ds : " + UdrInfo.ds);
                log.debug("con : " + UdrInfo.con);
                log.debug("stm : " + UdrInfo.stm);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                log.error("### executeDb Error End ###");
                log.error("### Parameter : methodName : " + methodName);
                log.error("### Parameter : query : " + query);
                log.error("### " + methodName + " Error End ###");
                log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
                log.error("con : " + UdrInfo.con);
                log.error("stm : " + UdrInfo.stm);
                log.error("Error InstantiationException or IllegalAccessException or ClassNotFoundException");
                e.printStackTrace();
                retryCount = 0;
            } catch (SQLException e) {
                log.error("### executeDb Error End ###");
                log.error("### Parameter : methodName : " + methodName);
                log.error("### Parameter : query : " + query);
                log.error("### " + methodName + " Error End ###");
                log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
                log.error("con : " + UdrInfo.con);
                log.error("stm : " + UdrInfo.stm);
                log.error("Error SQLException");
                String sqlState = e.getSQLState();
                log.error("sqlState : " + sqlState);
                e.printStackTrace();
                retryCount = 0;
            } catch (Exception e) {
                log.debug("### executeDb Error End ###");
                log.error("### Parameter : methodName : " + methodName);
                log.error("### Parameter : query : " + query);
                log.error("### " + methodName + " Error End ###");
                log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
                log.error("con : " + UdrInfo.con);
                log.error("stm : " + UdrInfo.stm);
                log.error("Error Exception");
                e.printStackTrace();
                retryCount = 0;
            }

            try {
                if (methodName.equals("execUdrQuery")) {
                    executeQuerySync(query);
                    log.debug("executeQuerySync Success");
                    log.debug("change from ResultSet to List Success");
                } else if (methodName.equals("execUdrUpdate")) {
                    updateLineNum = UdrInfo.stm.executeUpdate(query);
                    log.debug("executeUpdate Success : " + updateLineNum + " Line");
                } else {
                    log.error("### executeDb Error End ###");
                    log.error("### Parameter : methodName : " + methodName);
                    log.error("### Parameter : query : " + query);
                    log.error("Illegal Parameter");
                }
                transactionCompleted = true;
            } catch (SQLException e) {
                log.error("### " + methodName + " Error End ###");
                log.error("### Parameter : query : " + query);
                log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
                log.error("con : " + UdrInfo.con);
                log.error("stm : " + UdrInfo.stm);
                if (methodName.equals("execUdrQuery")) {
                    log.error("rs : " + rs);
                } else if (methodName.equals("execUdrUpdate")) {
                    log.error("executeUpdate : " + updateLineNum + " Line");
                } else {
                    log.error("### executeDb Error End ###");
                    log.error("### Parameter : methodName : " + methodName);
                    log.error("### Parameter : query : " + query);
                    log.error("Illegal Parameter");
                }
                log.error("Error SQLException");
                String sqlState = e.getSQLState();
                log.error("sqlState : " + sqlState);
                e.printStackTrace();
 
                // Retry if Connection failed
                if (sqlState.equals("08S01")) {
                    log.error("Retry");
                } else {
                    retryCount = 0;
                }
            } catch (InterruptedException e) {
                log.error("### " + methodName + " Error End ###");
                log.error("### Parameter : query : " + query);
                log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
                log.error("con : " + UdrInfo.con);
                log.error("stm : " + UdrInfo.stm);
                if (methodName.equals("execUdrQuery")) {
                    log.error("rs : " + rs);
                } else if (methodName.equals("execUdrUpdate")) {
                    log.error("executeUpdate : " + updateLineNum + " Line");
                } else {
                    log.error("### executeDb Error End ###");
                    log.error("### Parameter : methodName : " + methodName);
                    log.error("### Parameter : query : " + query);
                    log.error("Illegal Parameter");
                }
                log.error("Error InterruptedException");
                e.printStackTrace();
            }
            retryCount--;
        } while(!transactionCompleted && retryCount > 0);

        log.debug("### executeDb End ###");
    }

    public String execUdrQuery(String query) {
        log.debug("### execUdrQuery Start ###");
        log.debug("### Parameter : query : " + query);

        results = new ArrayList<String>();

        executeDb("execUdrQuery", query);

        // List => String
        log.debug("results.size : " + results.size());
        if (results.size() == 1) {
            result = results.get(0);
            log.debug("List => String Success");
        } else {
            log.error("### execUdrQuery Error End ###");
            log.error("### Parameter : query : " + query);
            log.error("dbName,url,username,password : " + UdrInfo.dbName + "," + UdrInfo.url + "," + UdrInfo.username + "," + UdrInfo.password);
            log.error("con : " + UdrInfo.con);
            log.error("stm : " + UdrInfo.stm);
            log.error("rs : " + rs);
            log.error("results.size : " + results.size());
            log.error("Error results.size is 0");
        }

        if (result == null) {
            log.debug("result is Null");
        }
        log.debug("### execUdrQuery End ###");
        return result;
    }

    public int execUdrUpdate(String query) {
        log.debug("### execUdrUpdate Start ###");
        log.debug("### Parameter : query : " + query);

        executeDb("execUdrUpdate", query);

        log.debug("### execUdrUpdate End ###");
        return updateLineNum;
    }

    public void setKeyName(String keyName) {
        log.debug("### setKeyName Start ###");
        log.debug("### Parameter : keyName : " + keyName);
        this.keyName = keyName;
        log.debug("### setKeyName End ###");
    }

    public void setTblName(String tblName) {
        log.debug("### setTblName Start ###");
        log.debug("### Parameter : tblName : " + tblName);
        this.tblName = tblName;
        log.debug("### setTblName End ###");
    }
}
