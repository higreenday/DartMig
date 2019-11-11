package com.firstinfo.dart;

import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test2 {

    public Connection getConnection() throws Exception {
        Class.forName("Altibase.jdbc.driver.AltibaseDriver");
        String url = "jdbc:Altibase://220.76.91.27:20301/gongsidb";
 
        Connection conn = DriverManager.getConnection(url, "gongsi", "gongsi");
        return conn;
    }
    
    public void getClob() throws Exception {
        System.out.println("  SELECT CLOB ");
        try {
            Connection sCon = getConnection();
              sCon.setAutoCommit(false);
           
              Statement sStmt = sCon.createStatement();
              ResultSet sRS = sStmt.executeQuery(
                      " SELECT CONTENT " +
                      " FROM TB_PA_DART_DOC_CONTENT ");
           
              int i = 0;
           
              while (sRS.next()) {
                  System.out.println("    FETCH # " + (++i));
           
                  try {
                      int sReadSize = 0;
                      char[] sBuf = new char[2048];
                      StringBuffer sBuffer = new StringBuffer();
           
                      Clob sClob = sRS.getClob(1);
                      Reader sReader = sClob.getCharacterStream();
           
                      while ((sReadSize = sReader.read(sBuf)) > 0) {
                          sBuffer.append(sBuf, 0, sReadSize);
                      }
                      System.out.println(sBuffer);
                      System.out.println("************");
                  } catch (Exception e) {
                      System.out.println("ERROR MESSAGE : " + e.getMessage());
                      e.printStackTrace();
                  }
              }
           
              sCon.commit();
              sStmt.close();
           
              /* Finalize process */
              sCon.close();
          } catch (SQLException e) {
              System.out.println("ERROR CODE    : " + e.getErrorCode());
              System.out.println("ERROR MESSAGE : " + e.getMessage());
              e.printStackTrace();
          }
   
    }
    
    public static void main(String[] args) {
        try {
            Test2 test2 = new Test2();
            test2.getClob();
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }
}
