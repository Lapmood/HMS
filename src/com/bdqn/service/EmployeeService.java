package com.bdqn.service;

import com.bdqn.bean.Employee;
import com.bdqn.bean.Employee;
import com.bdqn.utils.Page;

import java.util.Map;

public interface EmployeeService {

    /**
     * 添加员工
     * @param params 员工信息列表
     * @return 执行后结果
     */
    int addEmployee(Object... params);

    /**
     * 根据员工编号查询信息
     * @param id 员工编号
     * @return 查询结果
     */
    Employee getEmployeeById(String id);

    /**
     * 根据员工编号修改员工信息
     * @param params 修改的员工信息列表
     * @return
     */
    int editEmployeeSave(Object... params);

    /**
     * 员工列表查询
     * @param pageNum 当前页码
     * @return 返回员工信息
     */
    Page<Employee> employeeList(int pageNum);

    /**
     * 根据员工编号删除员工信息
     * @param id 员工编号
     * @return
     */
    int deleteEmployee(String id);

    /**
     * 根据搜索内容搜索员工信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Employee> searchEmployee(int pageNum, Map<String, String[]> map);
}
