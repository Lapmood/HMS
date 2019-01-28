package com.bdqn.dao;

import com.bdqn.bean.Employee;
import com.bdqn.bean.Employee;
import com.bdqn.bean.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeDao {

    /**
     * 登录
     * @param connection 数据库连接对象
     * @param username 登录账号
     * @param password 登录密码
     * @return 登录用户对象
     */
    Employee login(Connection connection, String username, String password) throws Exception;

    /**
     *
     * 添加员工信息
     * @param connection 数据库连接对象
     * @param params 员工信息参数列表
     * @return 执行结果
     * @throws Exception 异常
     */
    int addEmployee(Connection connection, Object... params) throws Exception;

    /**
     * 计算总条数
     * @param connection 数据库连接对象
     * @return 总条数
     */
    long getTotal(Connection connection) throws Exception;

    /**
     * 根据员工编号查询员工信息
     * @param connection 数据库连接对象
     * @param id 员工编号
     * @return 员工信息
     */
    Employee getEmployeeById(Connection connection, String id) throws Exception;

    /**
     * 根据员工编号修改员工信息
     * @param connection 数据库连接对象
     * @param params 修改的员工信息列表
     * @param params 员工信息列表
     * @return 执行结果
     */
    int editEmployeeSave(Connection connection, Object... params) throws Exception;

    /**
     * 根据员工编号删除员工信息
     * @param connection 数据库连接对象
     * @param id 员工编号
     * @return 执行结果
     */
    int deleteEmployee(Connection connection, String id) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 查询搜索内容的所有员工信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<Employee> searchEmployee(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;

    List<Employee> employeeList(Connection connection, int start, int pageSize) throws Exception;

    /**
     * 封装条件查询的参数列表
     * @param map 所有条件参数列表列表
     * @return 返回需要的条件参数
     */
    Object[] structParams(Map<String,String[]> map);

    /**
     * 封装条件查询的SQL语句
     * @param sql SQL语句
     * @param map 所有条件参数列表列表
     * @return 封装后的SQL语句
     */
    String structSql(String sql,Map<String,String[]> map);
}
