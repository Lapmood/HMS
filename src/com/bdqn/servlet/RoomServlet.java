package com.bdqn.servlet;

import com.bdqn.bean.Room;
import com.bdqn.bean.Room;
import com.bdqn.service.RoomService;
import com.bdqn.service.impl.RoomServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/RoomServlet")
public class RoomServlet extends BaseServlet {

    private RoomService roomService;

    @Override
    public void init() throws ServletException {
        roomService = new RoomServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        return "WEB-INF/page/roomAdd.jsp";
    }

    //添加预订
    public String addRoom(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String roomId = request.getParameter("roomId");
        String roomType = request.getParameter("roomType");
        String state = request.getParameter("state");
        String location = request.getParameter("location");
        String tele = request.getParameter("tele");
        String bed = request.getParameter("bed");
        String price = request.getParameter("price");
        String hourRoom = request.getParameter("hourRoom");
        String hourPrice = request.getParameter("hourPrice");
        String remark = request.getParameter("remark");

        //执行添加操作
        int i = roomService.addRoom(roomId,roomType,state,location,tele,remark,bed,price,hourRoom,hourPrice);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("msg","添加成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","添加失败!");
        }
        return "RoomServlet?opt=roomList";
    }

    //获取需要编辑的预订信息
    public String editRoom(HttpServletRequest request, HttpServletResponse response){
        Room room = roomService.getRoomById(request.getParameter("id"));
        request.setAttribute("room",room);
        return "WEB-INF/page/roomAdd.jsp";
    }

    //预订检索
    public String roomList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Room> page = roomService.roomList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/roomList.jsp";
    }

    //保存编辑后的预订信息
    public String editRoomSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String roomId = request.getParameter("roomId");
        String roomType = request.getParameter("roomType");
        String state = request.getParameter("state");
        String location = request.getParameter("location");
        String tele = request.getParameter("tele");
        String bed = request.getParameter("bed");
        String price = request.getParameter("price");
        String hourRoom = request.getParameter("hourRoom");
        String hourPrice = request.getParameter("hourPrice");
        String remark = request.getParameter("remark");
        String id = request.getParameter("id");
        int i = roomService.editRoomSave(roomId,roomType,state,location,tele,remark,bed,price,hourRoom,new Double(hourPrice),id);
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","修改成功!");
        }else{
            request.setAttribute("msg","修改失败!");
            request.setAttribute("flag","false");
        }
        return "RoomServlet?opt=roomList";
    }

    public String deleteRoom(HttpServletRequest request, HttpServletResponse response){
        int i = roomService.deleteRoom(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","删除成功!");
        }else{
            request.setAttribute("msg","删除失败!");
            request.setAttribute("flag","false");
        }
        return "RoomServlet?opt=roomList";
    }

    //检索客房
    public String searchRoom(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
//        String username = request.getParameter("username");
//        String phone = request.getParameter("phone");
//        String roomTime = request.getParameter("roomTime");
//        map.put("name",username);
//        map.put("phone",phone);
//        map.put("roomTime",roomTime);
//        System.out.println("=====>"+username+phone+roomTime);

        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<Room> page = roomService.searchRoom(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/roomList.jsp";
    }
}
