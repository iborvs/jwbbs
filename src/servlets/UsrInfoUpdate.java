package servlets;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UsrInfoUpdate")
public class UsrInfoUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String nickname=request.getParameter("nickname");
        String qq=request.getParameter("qq");
        String email=request.getParameter("email");
        int state;
        state = UserDAO.editInfo(username,email,qq,nickname);
        if(state==1){
            writer.println("success");
        }
        else {
            writer.println("failed");
        }
    }
}