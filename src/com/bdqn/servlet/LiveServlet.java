package com.bdqn.servlet;

import com.bdqn.bean.Live;
import com.bdqn.service.LiveService;
import com.bdqn.service.impl.LiveServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/LiveServlet")
public class LiveServlet extends BaseServlet {

    private LiveService liveService;

    @Override
    public void init() throws ServletException {
        liveService = new LiveServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        return "WEB-INF/page/liveAdd.jsp";
    }

    //添加入住
    public String addLive(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String inNo = request.getParameter("inNo");
        String roomId = request.getParameter("roomId");
        String customerName = request.getParameter("customerName");
        String sex = request.getParameter("sex");
        String zjType = request.getParameter("zjType");
        String zjNo = request.getParameter("zjNo");
        String number = request.getParameter("number");
        String days = request.getParameter("days");
        String foreGift = request.getParameter("foreGift");
        String remark = request.getParameter("remark");

        //执行添加操作
        int i = liveService.addLive(inNo,roomId,customerName,sex,zjType,zjNo,number,new Date(),days,foreGift,remark);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","添加成功!");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","添加失败!");
        }
        return "LiveServlet?opt=liveList";
    }

    //获取需要编辑的入住信息
    public String editLive(HttpServletRequest request, HttpServletResponse response){
        Live live = liveService.getLiveById(request.getParameter("id"));
        request.setAttribute("live",live);
        return "WEB-INF/page/liveAdd.jsp";
    }

    //入住检索
    public String liveList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Live> page = liveService.liveList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/liveList.jsp";
    }

    //保存编辑后的入住信息
    public String editLiveSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String inNo = request.getParameter("inNo");
        String roomId = request.getParameter("roomId");
        String customerName = request.getParameter("customerName");
        String sex = request.getParameter("sex");
        String zjType = request.getParameter("zjType");
        String zjNo = request.getParameter("zjNo");
        String number = request.getParameter("number");
        String days = request.getParameter("days");
        String foreGift = request.getParameter("foreGift");
        String remark = request.getParameter("remark");
        String id = request.getParameter("id");
        int i = liveService.editLiveSave(inNo,roomId,customerName,sex,zjType,zjNo,number,days,foreGift,remark,id);
        if(i != 0){
            request.setAttribute("msg","修改成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","修改失败!");
        }
        return "LiveServlet?opt=liveList";
    }

    public String deleteLive(HttpServletRequest request, HttpServletResponse response){
        int i = liveService.deleteLive(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","删除成功!");
        }else{
            request.setAttribute("msg","删除失败!");
            request.setAttribute("flag","false");
        }
        return "LiveServlet?opt=liveList";
    }

    //检索入住
    public String searchLive(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<Live> page = liveService.searchLive(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/liveList.jsp";
    }
}
