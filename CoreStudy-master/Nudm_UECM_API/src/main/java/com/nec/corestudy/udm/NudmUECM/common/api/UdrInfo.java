package com.nec.corestudy.udm.NudmUECM.common.api;

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

public class UdrInfo {

    // DB information
    static String dbName = null;	// MYSQL_DATABASE
    static String url = null;	// MYSQL_URI
    static String username = null;	// MYSQL_USER 
    static String password = null;	// MYSQL_PASSWORD
    static Properties props = null;
    static ClassLoader classLoader = null;
    static InputStream is = null;
    static DataSource ds = null;
    static Connection con = null;
    static Statement stm = null;

    static int retryCount = 2;
    static boolean transactionCompleted = false;

    private static final Logger log = LoggerFactory.getLogger(UdrInfo.class);

    public static void setUdrInfo() {
        log.info("### setUdrInfo Start ###");

        dbName = System.getenv("MYSQL_DATABASE");
        url = System.getenv("MYSQL_URI") + dbName + "?autoReconnect=true&failOverReadOnly=false&roundRobinLoadBalance=true&loadBalanceStrategy=random";
        username = System.getenv("MYSQL_USER");
        password = System.getenv("MYSQL_PASSWORD");

        log.debug("dbName,url,username,password : " + dbName + "," + url + "," + username + "," + password);

        props = new Properties();
        classLoader = Thread.currentThread().getContextClassLoader();
        is = classLoader.getResourceAsStream("application.properties");

        try {
            props.load(is);
        } catch (IOException e) {
            log.error("### setUdrInfo Error End ###");
            log.error("Error IOException");
            log.error("props : " + props);
            log.error("classLoader : " + classLoader);
            log.error("is : " + is);
            e.printStackTrace();
        }
        log.debug("driverClassName : " + props.getProperty("driverClassName"));
        log.debug("url : " + props.getProperty("url"));
        log.debug("username : " + props.getProperty("username"));
        log.debug("password : " + props.getProperty("password"));
        log.debug("validationQuery : " + props.getProperty("validationQuery"));
        log.debug("testOnBorrow : " + props.getProperty("testOnBorrow"));
        log.debug("testWhileIdle : " + props.getProperty("testWhileIdle"));
        log.debug("timeBetweenEvictionRunsMillis : " + props.getProperty("timeBetweenEvictionRunsMillis"));
        log.debug("initialSize : " + props.getProperty("initialSize"));
        log.debug("maxTotal : " + props.getProperty("maxTotal"));
        log.debug("maxIdle : " + props.getProperty("maxIdle"));
        log.debug("minIdle : " + props.getProperty("minIdle"));
        props.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        props.setProperty("url", url);
        props.setProperty("username", username);
        props.setProperty("password", password);
        props.setProperty("validationQuery", "select 1");
        props.setProperty("testOnBorrow", "true");
        props.setProperty("testWhileIdle", "true");
        props.setProperty("timeBetweenEvictionRunsMillis", "" + (1000 * 60 * 30));
        props.setProperty("initialSize", "0");
        props.setProperty("maxTotal", "20");
        props.setProperty("maxIdle", "20");
        props.setProperty("minIdle", "10");
        log.info("setProperty Success");
        log.info("driverClassName : " + props.getProperty("driverClassName"));
        log.info("url : " + props.getProperty("url"));
        log.info("username : " + props.getProperty("username"));
        log.info("password : " + props.getProperty("password"));
        log.info("validationQuery : " + props.getProperty("validationQuery"));
        log.info("testOnBorrow : " + props.getProperty("testOnBorrow"));
        log.info("testWhileIdle : " + props.getProperty("testWhileIdle"));
        log.info("timeBetweenEvictionRunsMillis : " + props.getProperty("timeBetweenEvictionRunsMillis"));
        log.info("initialSize : " + props.getProperty("initialSize"));
        log.info("maxTotal : " + props.getProperty("maxTotal"));
        log.info("maxIdle : " + props.getProperty("maxIdle"));
        log.info("minIdle : " + props.getProperty("minIdle"));

        retryCount = 2;
        transactionCompleted = false;

        do {
            log.debug("retryCount : " + retryCount);

            try {
                if (con == null) {
                    ds = BasicDataSourceFactory.createDataSource(props);
                    con = ds.getConnection();
                    log.info("getConnection Success");
                }
 
                if (stm == null) {
                    stm = con.createStatement();
                    log.info("createStatement Success");
                }
                log.info("ds : " + ds);
                log.info("con : " + con);
                log.info("stm : " + stm);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                log.error("### setUdrInfo Error End ###");
                log.error("dbName,url,username,password : " + dbName + "," + url + "," + username + "," + password);
                log.error("ds : " + ds);
                log.error("con : " + con);
                log.error("stm : " + stm);
                log.error("Error InstantiationException or IllegalAccessException or ClassNotFoundException");
                e.printStackTrace();
                retryCount = 0;
            } catch (SQLException e) {
                log.error("### setUdrInfo Error End ###");
                log.error("dbName,url,username,password : " + dbName + "," + url + "," + username + "," + password);
                log.error("ds : " + ds);
                log.error("con : " + con);
                log.error("stm : " + stm);
                log.error("Error SQLException");
                String sqlState = e.getSQLState();
                log.error("sqlState : " + sqlState);
                e.printStackTrace();
                retryCount = 0;
            } catch (Exception e) {
                log.error("### setUdrInfo Error End ###");
                log.error("dbName,url,username,password : " + dbName + "," + url + "," + username + "," + password);
                log.error("ds : " + ds);
                log.error("con : " + con);
                log.error("stm : " + stm);
                log.error("Error Exception");
                e.printStackTrace();
                retryCount = 0;
            }

            try {
                stm.executeQuery("select 1");
                log.info("executeQuery Success");
                transactionCompleted = true;
            } catch (SQLException e) {
                log.error("### setUdrInfo Error End ###");
                log.error("dbName,url,username,password : " + dbName + "," + url + "," + username + "," + password);
                log.error("ds : " + ds);
                log.error("con : " + con);
                log.error("stm : " + stm);
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
            }
            retryCount--;
        } while(!transactionCompleted && retryCount > 0);

        log.info("### setUdrInfo End ###");
    }
}
