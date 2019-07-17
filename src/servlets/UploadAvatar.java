package servlets;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "UploadAvatar")
public class UploadAvatar extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name=request.getParameter("username");
        String email=request.getParameter("email");
        String headimg=request.getParameter("headimg");
        List<Double> paras = new ArrayList<>();
        System.out.println(name + email + headimg);

        Boolean isMultipart=ServletFileUpload.isMultipartContent(request);
        if (!isMultipart) {
            return; //如果不是就不用上传了
        }
        try {
            DiskFileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload upload=new ServletFileUpload(factory);
            List<FileItem> items=upload.parseRequest(request);
            for (FileItem item : items) {
                String fileName = item.getFieldName();
                if (item.isFormField()) {
                    String value = item.getString("utf-8");
                    System.out.println(fileName + "->" + value);
                    paras.add(Double.valueOf(value));
                } else {
                    //上传文件的控件
                    System.out.println(fileName + "->" + item.getName()); //一个的标签的name，一个是文件的name
                    item.write(new File("/", item.getName())); //把上传的文件保存到某个文件中
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
    public static BufferedImage img_cropper(String src,int x,int y,int width,int height) {
        String suffix = src.substring(src.lastIndexOf(".") + 1);
        BufferedImage bi=file2img(src);
        BufferedImage back=bi.getSubimage(x,y,width,height);
        img2file(back,suffix,src);
        return back;
    }
    public static BufferedImage file2img(String imgpath) {
        try {
            BufferedImage bufferedImage=ImageIO.read(new File(imgpath));
            return bufferedImage;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void img2file(BufferedImage img,String extent,String newfile) {
        try {
            ImageIO.write(img, extent, new File(newfile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }