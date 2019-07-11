package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;
import util.DBConn;

import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "UsrLogin")
public class UsrLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String userpwd=request.getParameter("password");
            String sql="select * FROM USER where username='"+username+"' and userpwd='"+userpwd+"';";
            try {
                Connection conn=DBConn.getConn();
                Statement stmt= conn.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                if(rs.next()){
                    Cookie cookie=new Cookie("username", username);
                    cookie.setMaxAge(7*24*60*60);
                    response.addCookie(cookie);
                    writer.println("success");
                }else{
                    writer.println("failed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                writer.println("failed");
            }
        }
    }