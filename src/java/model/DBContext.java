package model;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
   
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection()throws Exception {
        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +";databaseName="+dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "DESKTOP-4B0PUCC\\THAIDEEPTRY";
    private final String dbName = "project";
    private final String portNumber = "1433";
    private final String instance="";//LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
    private final String userID = "sa";
    private final String password = "sa";
}
