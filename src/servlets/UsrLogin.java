package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.Cookie;

import dao.UserDAO;
import util.DBConn;

import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;

@WebServlet(name = "UsrLogin")
public class UsrLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String userpwd=request.getParameter("password");
        int state;
                state = UserDAO.login(username,userpwd);
                if(state==1){
                    Cookie cookie=new Cookie("username", username);
                    cookie.setMaxAge(7*24*60*60);
                    response.addCookie(cookie);
                    java.util.Date date = new java.util.Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ; //使用了默认的格式创建了一个日期格式化对象。
                    String ndate = dateFormat.format(date); //可以把日期转换转指定格式的字符串
                    if(UserDAO.updateLastTime(username,ndate)==1)
                        writer.println("success");
                }else{
                    writer.println("failed");
                }
        }
}