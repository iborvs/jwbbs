package dao;
import util.DBConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DA {
    public static ResultSet execSql(String sql){
        try {
            Connection conn= DBConn.getConn();
            Statement stmt= conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static int execUpdate(String sql){
        int rs=0;
        try {
            Connection conn=DBConn.getConn();
            Statement stmt= conn.createStatement();
            rs=stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
