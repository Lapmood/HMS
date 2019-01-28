package com.bdqn.service.impl;

import com.bdqn.bean.Employee;
import com.bdqn.bean.Employee;
import com.bdqn.dao.EmployeeDao;
import com.bdqn.dao.impl.EmployeeDaoImpl;
import com.bdqn.service.EmployeeService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(){
        employeeDao = new EmployeeDaoImpl();
    }

    @Override
    public int addEmployee(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = employeeDao.addEmployee(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取指定的预订信息
    @Override
    public Employee getEmployeeById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Employee Employee = employeeDao.getEmployeeById(connection, id);
            return Employee;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editEmployeeSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = employeeDao.editEmployeeSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteEmployee(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = employeeDao.deleteEmployee(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //预定列表
    @Override
    public Page<Employee> employeeList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = employeeDao.getTotal(connection);
            Page<Employee> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Employee> engages = employeeDao.employeeList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Employee> searchEmployee(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = employeeDao.getSearchTotal(connection,map);
            Page<Employee> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Employee> engages = employeeDao.searchEmployee(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
