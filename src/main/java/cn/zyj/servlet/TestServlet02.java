package cn.zyj.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test02")
public class TestServlet02 extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //tomcat 8.5之下，get请求会使用默认编码（ISO-8859-1）
        //System.out.println("sevlet开始工作了！！！");

        //从页面获取数据
        String name = request.getParameter("name");

        String newName = null;

        if(name !=null){

            byte[] bytes = name.getBytes("ISO-8859-1");

            newName = new String(bytes, "utf-8");

        }


        response.setCharacterEncoding("utf-8");
        //向页面返回数据
        response.getWriter().print("<h1>欢迎你："+newName+"进入本网站</h1>");

    }
}
