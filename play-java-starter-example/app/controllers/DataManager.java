package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class DataManager {

    private static DataManager myinstance = null;

    //private String url = "jdbc:mysql://some-mysql.playnetwork/EPC";
    private String url = "jdbc:mysql://10.43.111.9/EPC";
    private String user = "root";
    private String pass = "my-secret-pw";
    private String table = "CONFIG";
    private DataBaseAccesser database = null;
    private JsonNode configValue = null;

    public static DataManager getInstance(){
        if(myinstance == null){
            myinstance = new DataManager();
        }
        return myinstance;
    }

    public DataManager() {
        database = new DataBaseAccesser(url, user, pass);
        String sql = "select * from " + table + ";";
        ResultSet result = database.executeQuery(sql);
        try {
            boolean boolvalue = result.next();
            ObjectMapper objmapper = new ObjectMapper();
            configValue = objmapper.readTree(result.getString(2));
        } catch(Exception e) {
            configValue = null;
        }
    }

    public ResultSet getData(String table, String pramName, String keyValue){
        String sql = "select * from " + table + " where " + pramName + " = '" + keyValue + "';" ;
        return database.executeQuery(sql);
    }
    public ResultSet getData(String table, String pramName, int keyValue){
        String sql = "select * from " + table + " where " + pramName + " = " + keyValue + ";" ;
        return database.executeQuery(sql);
    }
    public ResultSet getData(String table){
        String sql = "select * from " + table + ";" ;
        return database.executeQuery(sql);
    }
    public int setData(String table, String keyValue, String setData){
        String sql = "insert into " + table + " values('" + keyValue + "', '" + setData + "');";
        return database.executeUpdate(sql);
    }
    public int setData(String table, int keyValue, String setData){
        String sql = "insert into " + table + " values(" + keyValue + ", '" + setData + "');";
        return database.executeUpdate(sql);
    }
    public int upData(String table, String paramName, String keyValue, String setData){
        String sql = "update " + table + " set VALUE='" + setData + "' where " + paramName + "='" + keyValue + "';";
        return database.executeUpdate(sql);
    }
    public int upData(String table, String paramName, int keyValue, String setData){
        String sql = "update " + table + " set VALUE='" + setData + "' where " + paramName + "=" + keyValue + ";";
        return database.executeUpdate(sql);
    }
    public int delData(String table, String paramName, String keyValue){
        String sql = "delete " + table + " where " + paramName + "='" + keyValue + "';";
        return database.executeUpdate(sql);
    }
    public int delData(String table, String paramName, int keyValue){
        String sql = "delete " + table + " where " + paramName + "=" + keyValue + ";";
        return database.executeUpdate(sql);
    }
}
