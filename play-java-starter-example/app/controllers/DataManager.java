package controllers;

import java.sql.ResultSet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class DataManager {

    private static DataManager myinstance = null;

    private String url = "jdbc:mysql://some-mysql/Database";
    private String user = "root";
    private String pass = "my-secret";
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
        result.next();
        ObjectMapper objmapper = new ObjectMapper();
        configValue = objmapper.readTree(result.getBytes(1));
    }

    public getData(String table, String pramName, String keyValue){
        String sql = "select * from " + table + " where " + pramName + " = '" + keyValue + "';" ;
        return database.executeQuery(sql);
    }
    public getData(String table, String pramName, int keyValue){
        String sql = "select * from " + table + " where " + pramName + " = " + keyValue + ";" ;
        return database.executeQuery(sql);
    }
    public getData(String table){
        String sql = "select * from " + table + " where " + pramName + " = " + keyValue + ";" ;
        return database.executeQuery(sql);
    }
}
