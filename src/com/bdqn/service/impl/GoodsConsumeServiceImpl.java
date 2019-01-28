package com.bdqn.service.impl;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.bean.Live;
import com.bdqn.dao.GoodsConsumeDao;
import com.bdqn.dao.LiveDao;
import com.bdqn.dao.impl.GoodsConsumeDaoImpl;
import com.bdqn.dao.impl.LiveDaoImpl;
import com.bdqn.service.GoodsConsumeService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsConsumeServiceImpl implements GoodsConsumeService {

    private GoodsConsumeDao goodsConsumeDao;

    public GoodsConsumeServiceImpl(){
        goodsConsumeDao = new GoodsConsumeDaoImpl();
    }

    @Override
    public int saveBuyGoods(String goodId, String roomId, String number, String money) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();
        )
        {
            int i = goodsConsumeDao.saveBuyGoods(connection,goodId,roomId,number,money);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Page<GoodsConsume> consumeList(Integer pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = goodsConsumeDao.getConsumeTotal(connection);
            Page<GoodsConsume> page = new Page<>(pageNum,total);

            //执行查询操作
            List<GoodsConsume> engages = goodsConsumeDao.consumeList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<GoodsConsume> searchGoodsConsume(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = goodsConsumeDao.getSearchTotal(connection,map);
            Page<GoodsConsume> page = new Page<>(pageNum,total);
            //执行查询操作
            List<GoodsConsume> engages = goodsConsumeDao.searchGoodsConsume(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
