package com.bdqn.utils;

import com.bdqn.bean.Goods;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtils {

    static DataSource dataSource;//数据源对象
    static QueryRunner queryRunner;//查询对象

    static {
        dataSource = new ComboPooledDataSource("c3p0");
        queryRunner = new QueryRunner();
    }

    //获取连接对象的
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static int update(Connection conn, String sql, Object...args) throws Exception {
        int update = queryRunner.update(conn, sql, args);
        return update;
    }

    public static <E> E query(Connection connection, String sql, ResultSetHandler<E> rsh, Object...params) throws Exception {
        E query = queryRunner.query(connection, sql, rsh, params);
        return query;
    }
}
