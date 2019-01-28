package com.bdqn.service.impl;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.bean.Live;
import com.bdqn.dao.GoodsDao;
import com.bdqn.dao.LiveDao;
import com.bdqn.dao.impl.GoodsDaoImpl;
import com.bdqn.dao.impl.LiveDaoImpl;
import com.bdqn.dao.impl.RoomDaoImpl;
import com.bdqn.service.GoodsService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodsServiceImpl implements GoodsService{

    private GoodsDao goodsDao;
    private LiveDao liveDao;

    public GoodsServiceImpl(){
        goodsDao = new GoodsDaoImpl();
        liveDao = new LiveDaoImpl();
    }

    @Override
    public int addGoods(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = goodsDao.addGoods(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取指定的预订信息
    @Override
    public Goods getGoodsById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Goods Goods = goodsDao.getGoodsById(connection, id);
            return Goods;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editGoodsSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = goodsDao.editGoodsSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteGoods(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = goodsDao.deleteGoods(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //预定列表
    @Override
    public Page<Goods> goodsList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = goodsDao.getTotal(connection);
            Page<Goods> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Goods> engages = goodsDao.goodsList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Goods> searchGoods(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = goodsDao.getSearchTotal(connection,map);
            Page<Goods> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Goods> engages = goodsDao.searchGoods(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Map<String,Object> buyGoods() {

        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();
        )
        {
            List<Goods> goods = goodsDao.getGoods(connection);
            List<Live> lives = liveDao.getLiveRoom(connection);

            Map<String,Object> map = new HashMap<>();
            map.put("goods",goods);
            map.put("lives",lives);
            return map;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
