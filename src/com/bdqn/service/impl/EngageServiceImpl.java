package com.bdqn.service.impl;

import com.bdqn.bean.Engage;
import com.bdqn.dao.EngageDao;
import com.bdqn.dao.impl.EngageDaoImpl;
import com.bdqn.service.EngageService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EngageServiceImpl implements EngageService{

    private EngageDao engageDao;

    public EngageServiceImpl(){
        engageDao = new EngageDaoImpl();
    }

    @Override
    public int addEngage(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = engageDao.addEngage(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    //预定列表
    @Override
    public Page<Engage> engageList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = engageDao.getTotal(connection);
            Page<Engage> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Engage> engages = engageDao.engageList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            //System.out.println(Arrays.toString(page.getNavigatepageNums()));
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取指定的预订信息
    @Override
    public Engage getEngageById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Engage engage = engageDao.getEngageById(connection, id);
            return engage;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editEngageSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = engageDao.editEngageSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEngage(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = engageDao.deleteEngage(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Page<Engage> searchEngage(int pageNum, Map<String,String> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = engageDao.getSearchTotal(connection,map);
            Page<Engage> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Engage> engages = engageDao.searchEngage(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
