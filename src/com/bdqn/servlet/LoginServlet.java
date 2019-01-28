package com.bdqn.servlet;

import com.bdqn.bean.Employee;
import com.bdqn.service.LoginService;
import com.bdqn.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {

    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginServiceImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取登录账号密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //验证登录
        Employee login = loginService.login(username, password);

        if(login != null){
            request.getSession().setAttribute("user",login);
            request.getRequestDispatcher("WEB-INF/page/admin.jsp").forward(request,response);
        }else{
            //登录失败的标记
            request.setAttribute("j","1");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }

}
