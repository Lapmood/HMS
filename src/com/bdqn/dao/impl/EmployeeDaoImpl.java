package com.bdqn.dao.impl;

import com.bdqn.bean.Employee;
import com.bdqn.bean.Employee;
import com.bdqn.dao.EmployeeDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Employee login(Connection connection,String username, String password) throws Exception {

        String sql = "SELECT emp_id empId,user_id userId,password,phone,salary FROM t_employee WHERE user_id = ? AND password = ?";

        Employee query = JDBCUtils.query(connection, sql, new BeanHandler<Employee>(Employee.class), username, password);

        return query;
    }

    @Override
    public int addEmployee(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_employee (id,emp_id,user_id,password,phone,salary) VALUES(null,?,?,?,?,?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_employee";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Employee getEmployeeById(Connection connection, String id) throws Exception {
        String sql="SELECT id,emp_id empId,user_id userId,password,phone,salary FROM " +
                "t_employee WHERE id = ?";
        Employee Employee = JDBCUtils.query(connection, sql, new BeanHandler<>(Employee.class), id);
        return Employee;
    }

    @Override
    public int editEmployeeSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_employee set user_id=?,password=?,phone=?,salary=?" +
                " WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteEmployee(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_employee WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql = "SELECT count(0) FROM t_employee WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Employee> employeeList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,emp_id empId,user_id userId,password,phone,salary FROM " +
                "t_employee order by id desc limit ?,?";
        List<Employee> query = JDBCUtils.query(connection, sql, new BeanListHandler<Employee>(Employee.class),start,pageSize);
        return query;
    }

    @Override
    public List<Employee> searchEmployee(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,emp_id empId,user_id userId,password,phone,salary FROM " +
                "t_employee WHERE 1=1 ";
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
        List<Employee> Employees = JDBCUtils.query(connection, sql, new BeanListHandler<Employee>(Employee.class), params);
        return Employees;
    }

    //获取需要的参数
    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("empId")[0])){
            key += "empId-";
        }
        if(!"".equals(map.get("userId")[0])){
            key += "userId-";
        }
        if(!"".equals(map.get("phone")[0])){
            key += "phone-";
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
        if(!"".equals(map.get("empId")[0])){
            sql += "AND emp_id=? ";
        }
        if(!"".equals(map.get("userId")[0])){
            sql += "AND user_id=? ";
        }
        if(!"".equals(map.get("phone")[0])){
            sql += "AND phone=? ";
        }

        return sql;
    }

}
