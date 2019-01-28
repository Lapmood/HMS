package com.bdqn.servlet;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.service.GoodsService;
import com.bdqn.service.impl.GoodsServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/GoodsServlet")
public class GoodsServlet extends BaseServlet {

    private GoodsService goodsService;

    @Override
    public void init() throws ServletException {
        goodsService = new GoodsServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        return "WEB-INF/page/goodsAdd.jsp";
    }

    //添加商品
    public String addGoods(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String purpose = request.getParameter("purpose");

        //执行添加操作
        int i = goodsService.addGoods(name,price,number,purpose);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","添加成功!");
        }else{
            request.setAttribute("msg","添加失败!");
            request.setAttribute("flag","false");
        }
        return "GoodsServlet?opt=goodsList";
    }

    //获取需要编辑的商品信息
    public String editGoods(HttpServletRequest request, HttpServletResponse response){
        Goods goods = goodsService.getGoodsById(request.getParameter("id"));
        request.setAttribute("goods",goods);
        return "WEB-INF/page/goodsAdd.jsp";
    }

    //商品检索
    public String goodsList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Goods> page = goodsService.goodsList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/goodsList.jsp";
    }

    //保存编辑后的商品信息
    public String editGoodsSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String number = request.getParameter("number");
        String purpose = request.getParameter("purpose");
        String id = request.getParameter("id");
        int i = goodsService.editGoodsSave(name,price,number,purpose,id);
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","修改成功!");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","修改失败!");
        }
        return "GoodsServlet?opt=goodsList";
    }

    //删除指定商品
    public String deleteGoods(HttpServletRequest request, HttpServletResponse response){
        int i = goodsService.deleteGoods(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("msg","删除成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("msg","删除失败!");
            request.setAttribute("flag","false");
        }
        return "GoodsServlet?opt=goodsList";
    }

    //检索商品
    public String searchGoods(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<Goods> page = goodsService.searchGoods(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/goodsList.jsp";
    }

    //查询购买商品时需要的信息(商品列表,已住客房)
    public String buyGoods(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> map = goodsService.buyGoods();
        request.setAttribute("goods",map.get("goods"));
        request.setAttribute("lives",map.get("lives"));
        return "WEB-INF/page/buyGoods.jsp";
    }
}
