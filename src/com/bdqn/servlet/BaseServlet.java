package com.bdqn.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String opt = request.getParameter("opt");
        String url = "";
        try {
            if(opt != null){
                Method addPage = this.getClass().getDeclaredMethod(opt,HttpServletRequest.class,HttpServletResponse.class);
                url = (String) addPage.invoke(this,request,response);
            }else{
                Method addPage = this.getClass().getDeclaredMethod("addPage",HttpServletRequest.class,HttpServletResponse.class);
                url = (String) addPage.invoke(this,request,response);
            }
            if(!"".equals(url) && url != null){
                if(url.contains("redirect:")){
                    response.sendRedirect(url.replace("redirect:",""));
                }else{
                    request.getRequestDispatcher(url).forward(request,response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("WEB-INF/page/error.jsp");
        }
    }
}
