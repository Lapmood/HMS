package com.bdqn.service;

import com.bdqn.bean.Employee;

public interface LoginService {

    /**
     * 登录
     * @param username 登录账号
     * @param password 登录密码
     * @return 登录对象
     */
    Employee login(String username, String password);
}
