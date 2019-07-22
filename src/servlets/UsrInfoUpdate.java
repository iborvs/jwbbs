package servlets;

import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

@WebServlet(name = "UsrInfoUpdate")
public class UsrInfoUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        String username=request.getParameter("username");
        String nickname=request.getParameter("nickname");
        String qq=request.getParameter("qq");
        String email=request.getParameter("email");
        String ifavatar=request.getParameter("if-avatar");
        int state;
        state = UserDAO.editInfo(username,email,qq,nickname);

        String filePath=this.getServletConfig().getServletContext().getRealPath("/");
        if(ifavatar!=""){
            String sourcePath = filePath+"public/temp/"+ ifavatar;
            String destPath = filePath+"public/avatar/"+ username+".png";
            File tempfile=new File(sourcePath);
            if(tempfile.exists()&&tempfile.isFile()){
                File destfile=new File(destPath);
                if(destfile.exists()&&destfile.isFile()) {
                    destfile.delete();
                    destfile.renameTo(new File(filePath+"public/avatar/"+ username));
                }
                Files.copy(tempfile.toPath(), destfile.toPath());
            }
        }

        if(state==1){
            writer.println("success");
        }
        else {
            writer.println("failed");
        }
    }
}