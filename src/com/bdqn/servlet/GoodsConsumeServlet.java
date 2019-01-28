package com.bdqn.servlet;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.service.GoodsConsumeService;
import com.bdqn.service.GoodsService;
import com.bdqn.service.impl.GoodsConsumeServiceImpl;
import com.bdqn.service.impl.GoodsServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet(urlPatterns = "/GoodsConsumeServlet")
public class GoodsConsumeServlet extends BaseServlet {

    private GoodsConsumeService goodsConsumeService;

    @Override
    public void init() throws ServletException {
        goodsConsumeService = new GoodsConsumeServiceImpl();
    }

    public String saveBuyGoods(HttpServletRequest request, HttpServletResponse response){

        String goodId = request.getParameter("goodId");
        String roomId = request.getParameter("roomId");
        String number = request.getParameter("number");
        String money = request.getParameter("money");

        int i = goodsConsumeService.saveBuyGoods(goodId,roomId,number,money);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("msg","添加成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","添加失败!");
        }
        return "GoodsConsumeServlet?opt=consumeList";
    }

    public String consumeList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<GoodsConsume> page = goodsConsumeService.consumeList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/consumeList.jsp";
    }

    //检索商品
    public String searchGoodsConsume(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<GoodsConsume> page = goodsConsumeService.searchGoodsConsume(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/consumeList.jsp";
    }
}
