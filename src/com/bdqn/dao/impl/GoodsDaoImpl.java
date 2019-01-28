package com.bdqn.dao.impl;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.bean.Live;
import com.bdqn.dao.GoodsDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GoodsDaoImpl implements GoodsDao {

    @Override
    public int addGoods(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_goods (id,article_name,price,number,purpose) VALUES(null,?,?,?,?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_goods";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Goods getGoodsById(Connection connection, String id) throws Exception {
        String sql="SELECT id,article_name name,price,number,purpose FROM " +
                "t_goods WHERE id = ?";
        Goods query = JDBCUtils.query(connection, sql, new BeanHandler<>(Goods.class), id);
        return query;
    }

    @Override
    public int editGoodsSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_goods set article_name=?,price=?,number=?,purpose=?" +
                " WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteGoods(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_goods WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql = "SELECT count(0) FROM t_goods WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Goods> goodsList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,article_name name,price,number,purpose FROM " +
                "t_goods order by id desc limit ?,?";
        List<Goods> query = JDBCUtils.query(connection, sql, new BeanListHandler<Goods>(Goods.class),start,pageSize);
        return query;
    }

    @Override
    public List<Goods> getGoods(Connection connection) throws Exception {
        String sql="SELECT id,article_name name,price,number,purpose FROM " +
                "t_goods";
        List<Goods> query = JDBCUtils.query(connection, sql, new BeanListHandler<Goods>(Goods.class));
        return query;
    }

    @Override
    public List<Goods> searchGoods(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,article_name name,price,number,purpose FROM " +
                "t_goods WHERE 1=1 ";
        //拼接SQL语句
        sql = structSql(sql, map);
        sql += " order by id desc limit ?,?";
        //获取需要的参数
        Object[] p = structParams(map);
        Object[] params = null;
        if(p != null){
            params = Arrays.copyOf(p,p.length+2);
        }else {
            params = new Object[2];
        }
        params[params.length-2] = start;
        params[params.length-1] = pageSize;
        List<Goods> query = JDBCUtils.query(connection, sql, new BeanListHandler<Goods>(Goods.class), params);
        return query;
    }

    //获取需要的参数
    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("name")[0])){
            key += "name-";
        }
        if(!"".equals(map.get("purpose")[0])){
            key += "purpose-";
        }

        String[] split = null;
        Object[] params = null;
        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"----"+Arrays.toString(map.get(split[i])));
                params[i] = map.get(split[i])[0];
            }
        }
        return params;
    }

    //拼接SQL语句
    public String structSql(String sql,Map<String,String[]> map){
        if(!"".equals(map.get("name")[0])){
            sql += "AND article_name=? ";
        }
        if(!"".equals(map.get("purpose")[0])){
            sql += "AND purpose=? ";
        }
        return sql;
    }

}
