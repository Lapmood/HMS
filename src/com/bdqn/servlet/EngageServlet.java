package com.bdqn.servlet;

import com.bdqn.bean.Engage;
import com.bdqn.service.EngageService;
import com.bdqn.service.impl.EngageServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/EngageServlet")
public class EngageServlet extends BaseServlet {

    private EngageService engageService;

    @Override
    public void init() throws ServletException {
        engageService = new EngageServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        return "WEB-INF/page/engageAdd.jsp";
    }

    //添加预订
    public String addEngage(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String arriveTime = request.getParameter("arriveTime");
        String room = request.getParameter("room");
        String mark = request.getParameter("mark");
        String remark = request.getParameter("remark");

        //执行添加操作
        int i = engageService.addEngage(room, username, phone, new Date(), arriveTime, mark, remark);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("msg","添加成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("msg","添加失败!");
            request.setAttribute("flag","false");
        }
        return "EngageServlet?opt=engageList";
    }

    //预订检索
    public String engageList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Engage> page = engageService.engageList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/engageList.jsp";
    }

    //获取需要编辑的预订信息
    public String editEngage(HttpServletRequest request, HttpServletResponse response){
        Engage engage = engageService.getEngageById(request.getParameter("id"));
        request.setAttribute("engage",engage);
        return "WEB-INF/page/engageAdd.jsp";
    }

    //保存编辑后的预订信息
    public String editEngageSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String arriveTime = request.getParameter("arriveTime");
        String room = request.getParameter("room");
        String mark = request.getParameter("mark");
        String remark = request.getParameter("remark");
        int i = engageService.editEngageSave(room,username,phone,arriveTime,mark,remark,id);
        if(i != 0){
            request.setAttribute("msg","修改成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("msg","修改失败!");
            request.setAttribute("flag","false");
        }
        return "EngageServlet?opt=engageList";
    }

    public String deleteEngage(HttpServletRequest request, HttpServletResponse response){
        int i = engageService.deleteEngage(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("msg","删除成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("msg","删除失败!");
            request.setAttribute("flag","false");
        }
        return "EngageServlet?opt=engageList";
    }

    public String searchEngage(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        String username = request.getParameter("username");
        String phone = request.getParameter("phone");
        String engageTime = request.getParameter("engageTime");
        //将搜索内容封装为map集合
        Map<String,String> map = new HashMap<>();
        map.put("name",username);
        map.put("phone",phone);
        map.put("engageTime",engageTime);

        Page<Engage> page = engageService.searchEngage(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/engageList.jsp";
    }




}
