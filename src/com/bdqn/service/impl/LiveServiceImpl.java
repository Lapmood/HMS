package com.bdqn.service.impl;

import com.bdqn.bean.Live;
import com.bdqn.dao.LiveDao;
import com.bdqn.dao.impl.LiveDaoImpl;
import com.bdqn.service.LiveService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class LiveServiceImpl implements LiveService{

    private LiveDao liveDao;

    public LiveServiceImpl(){
        liveDao = new LiveDaoImpl();
    }

    @Override
    public int addLive(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = liveDao.addLive(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取指定的预订信息
    @Override
    public Live getLiveById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Live Live = liveDao.getLiveById(connection, id);
            return Live;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editLiveSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = liveDao.editLiveSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteLive(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = liveDao.deleteLive(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //预定列表
    @Override
    public Page<Live> liveList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = liveDao.getTotal(connection);
            Page<Live> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Live> engages = liveDao.liveList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Live> searchLive(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = liveDao.getSearchTotal(connection,map);
            Page<Live> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Live> engages = liveDao.searchLive(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
