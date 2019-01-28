package com.bdqn.test;

import com.alibaba.fastjson.JSON;
import com.bdqn.bean.GoodsConsume;
import com.bdqn.dao.impl.EngageDaoImpl;
import com.bdqn.dao.impl.GoodsConsumeDaoImpl;
import com.bdqn.dao.impl.GoodsDaoImpl;
import com.bdqn.service.impl.EngageServiceImpl;
import com.bdqn.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {

    @Test
    public void testGetTotal() throws Exception{

//        try {
//            long total = new EngageDaoImpl().getTotal(JDBCUtils.getConnection());
//            System.out.println(total);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        List<GoodsConsume> goodsConsumes = new GoodsConsumeDaoImpl().consumeList(JDBCUtils.getConnection(),0,2);

        System.out.println(goodsConsumes);


    }

}
