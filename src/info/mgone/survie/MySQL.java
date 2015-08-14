package info.mgone.survie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL
{
  public static Connection con;
  public static String host = "127.0.0.1";
  public static String port = "3306";
  public static String database = Survie.getPluginInstance().getConfig().getString("mysqldb");
  public static String username = "root";
  public static String password = "aqwxsz12";
  
  public static Connection openConnection()
  {
    try
    {
      Class.forName("com.mysql.jdbc.Driver");
      con = java.sql.DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true&user=" + username + "&password=" + password);
      System.out.println("MySQL: Connected!");
    } catch (ClassNotFoundException|SQLException e) {
      System.out.println("MySQL-Error: " + e.getMessage());
    }
    return con;
  }
  
  public static void closeConnection() {
    if (con != null) {
      try {
        con.close();
      } catch (SQLException e) {
        System.out.println("MySQL-Error: " + e.getMessage());
      }
    }
  }
  
  public static ResultSet querySQL(String st) {
	  
	  if (con == null) openConnection();
	 
    ResultSet rs = null;
    try {
      rs = con.createStatement().executeQuery(st); con.createStatement().close();
    } catch (SQLException e) {
      System.out.println("MySQL-Error: " + e.getMessage());
    }
    return rs;
  }
  
  public static void createStatement(String st) {
	  
	  if (con == null) openConnection();
	  
    try {
      con.createStatement().executeUpdate(st); con.createStatement().close();
    } catch (SQLException e) {
      System.out.println("MySQL-Error: " + e.getMessage());
    }
  }
}

