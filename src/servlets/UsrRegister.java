package servlets;

import util.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import  java.text.*;

@WebServlet(name = "UsrRegister")
public class UsrRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String userpwd=request.getParameter("password");
        String email=request.getParameter("email");
        String qq=request.getParameter("qq");
            String sql="select * FROM USER where username='"+username+"';";
            try {
                Connection conn=DBConn.getConn();
                Statement stmt= conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next()){
                    writer.println("failed");
                }else{
                    java.util.Date date = new java.util.Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ; //使用了默认的格式创建了一个日期格式化对象。
                    String ndate = dateFormat.format(date); //可以把日期转换转指定格式的字符串
                    String date2=" ";
                    sql="INSERT INTO USER VALUES ('"+username+"','"+userpwd+"', '"+ndate+"', '"+date2+"',0,'"+email+"','"+qq+"');";
                    stmt = conn.createStatement();
                    stmt.executeUpdate(sql);
                        writer.println("success");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                writer.println("failed");
            }
        }
    }