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
        conection = DriverManager.getConnection(url,user,password);
        statement = conection.createStatement();
    }

    /*** Get DataBase Data ***/
    public ResultSet executeQuery(String sql){
       return statement.executeQuery(sql);
    }
}
