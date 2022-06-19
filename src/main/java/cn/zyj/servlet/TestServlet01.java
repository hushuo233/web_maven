package cn.zyj.servlet;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.servlet.*;
import java.io.IOException;


public class TestServlet01 implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

        System.out.println("servlet出生了！！！！！");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //tomcat 8.5之下，get请求会使用默认编码（ISO-8859-1）
        System.out.println("sevlet开始工作了！！！");

        //从页面获取数据
        String name = servletRequest.getParameter("name");

        byte[] bytes = name.getBytes("ISO-8859-1");

        String newName = new String(bytes, "utf-8");


        servletResponse.setCharacterEncoding("utf-8");
        //向页面返回数据
        servletResponse.getWriter().print("<h1>欢迎你"+newName+"</h1>");


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

        System.out.println("servlet死亡了");

    }
}
