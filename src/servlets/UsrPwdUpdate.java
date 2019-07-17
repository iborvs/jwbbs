package servlets;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UsrPwdUpdate")
public class UsrPwdUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String userpwd=request.getParameter("password");
        String newpwd=request.getParameter("newpassword");
        int state;
        state = UserDAO.login(username,userpwd);
        if(state==1){
            if(UserDAO.editPwd(username,newpwd)==1){
                writer.println("success");
                return;
            }
        }
        writer.println("failed");
    }
}