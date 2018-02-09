package controllers;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class DataBaseAccesser {

    private Connection conection = null;
    private Statement statement = null;

    /*** DataBase Connect ***/
    public DataBaseAccesser(String url, String user, String password){
        try {
            conection = DriverManager.getConnection(url,user,password);
            statement = conection.createStatement();
        } catch (Exception e){
            conection = null;
            statement = null;
        }
    }

    /*** Get DataBase Data ***/
    public ResultSet executeQuery(String sql){
       try {
           return statement.executeQuery(sql);
       } catch (Exception e) {
           return null;
       }
    }
    /*** Set DataBase Data ***/
    public int executeUpdate(String sql){
        try {
            return statement.executeUpdate(sql);
        } catch (Exception e) {
            return 0;
        }
    }
}
