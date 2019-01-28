package com.bdqn.dao.impl;

import com.bdqn.bean.Goods;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.bean.Live;
import com.bdqn.dao.GoodsConsumeDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GoodsConsumeDaoImpl implements GoodsConsumeDao {
    @Override
    public int saveBuyGoods(Connection connection, Object... params) throws Exception {
        String sql = "INSERT INTO t_goods_consume (id,goods_id,livein_id,goods_num,money) VALUES(null,?,?,?,?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getConsumeTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_goods_consume";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public List<GoodsConsume> consumeList(Connection connection, int start, int pageSize) throws Exception {
        String sql="select tgc.id,g.article_name name,g.price,l.room_id roomId,tgc.goods_num number,tgc.money from t_goods_consume tgc " +
                "left join t_goods g on tgc.goods_id = g.id " +
                "left join t_livein l on tgc.livein_id = l.id order by id desc limit ?,?";
        //封装 GoodsConsume 购物记录对象的集合
        List<Map<String, Object>> query = JDBCUtils.query(connection, sql, new MapListHandler(), start, pageSize);
        //遍历查询结果
        //将查询结果封装到 GoodsConsume 对象中
        List<GoodsConsume> goodsConsumes = encapsulationData(query);

        return goodsConsumes;
    }

    //封装 GoodsConsume 对象数据
    public List<GoodsConsume> encapsulationData(List<Map<String, Object>> query) throws Exception {
        List<GoodsConsume> goodsConsumes = new ArrayList<>();
        for (Map<String, Object>  goodsConsume: query) {
            //购买记录对象
            GoodsConsume gc = new GoodsConsume();
            //商品对象
            Goods goods = new Goods();
            //入住对象
            Live live = new Live();

            for (String s : goodsConsume.keySet()) {
                //当查询的字段为 name 时,为商品对象中的 name 属性赋值
                if("name".equals(s)){
                    PropertyUtils.setProperty(gc,"goods",goods);
                    PropertyUtils.setProperty(gc,"goods.name",goodsConsume.get(s));
                    //当查询的字段为 price 时,为商品对象中的 price 属性赋值
                }else if("price".equals(s)){
                    PropertyUtils.setProperty(gc,"goods",goods);
                    PropertyUtils.setProperty(gc,"goods.price",goodsConsume.get(s));
                    //当查询的字段为 roomId 时,为入住对象中的 roomId 属性赋值
                }else if("roomId".equals(s)){
                    PropertyUtils.setProperty(gc,"live",live);
                    PropertyUtils.setProperty(gc,"live.roomId",goodsConsume.get(s));
                }else {
                    //其他查询结果封装到购买记录对象中
                    PropertyUtils.setProperty(gc,s,goodsConsume.get(s));
                }
            }
            goodsConsumes.add(gc);
        }
        return goodsConsumes;
    }

    @Override
    public List<GoodsConsume> searchGoodsConsume(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="select tgc.id,g.article_name name,g.price,l.room_id roomId,tgc.goods_num number,tgc.money from t_goods_consume tgc " +
                "left join t_goods g on tgc.goods_id = g.id " +
                "left join t_livein l on tgc.livein_id = l.id WHERE 1=1 ";
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
        //封装分页数据
        params[params.length-2] = start;
        params[params.length-1] = pageSize;
        List<Map<String, Object>> query = JDBCUtils.query(connection, sql, new MapListHandler(), params);
        //遍历查询结果
        //将查询结果封装到 GoodsConsume 对象中
        List<GoodsConsume> goodsConsumes = encapsulationData(query);

        return goodsConsumes;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql="select count(0) FROM t_goods_consume tgc " +
                "left join t_goods g on tgc.goods_id = g.id " +
                "left join t_livein l on tgc.livein_id = l.id WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    //获取需要的参数
    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("roomId")[0])){
            key += "roomId-";
        }
        String[] split = null;
        Object[] params = null;
        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                //System.out.println(split[i]+"----"+Arrays.toString(map.get(split[i])));
                params[i] = map.get(split[i])[0];
            }
        }
        return params;
    }

    //拼接SQL语句
    public String structSql(String sql,Map<String,String[]> map){
        if(!"".equals(map.get("roomId")[0])){
            sql += "AND room_id=? ";
        }
        return sql;
    }

}
