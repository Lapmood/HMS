package com.bdqn.service.impl;

import com.bdqn.bean.Employee;
import com.bdqn.dao.EmployeeDao;
import com.bdqn.dao.impl.EmployeeDaoImpl;
import com.bdqn.service.LoginService;
import com.bdqn.utils.JDBCUtils;

import java.sql.Connection;

public class LoginServiceImpl implements LoginService {

    private EmployeeDao employeeDao;

    public LoginServiceImpl(){
        employeeDao = new EmployeeDaoImpl();
    }

    public Employee login(String username, String password) {

        try (
                Connection connection = JDBCUtils.getConnection();)
            {
                Employee login = employeeDao.login(connection, username, password);
                return login;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
