package com.bdqn.bean;

public class Employee {

    private Integer id;//编号
    private String empId;//员工工号
    private String userId;//登录名
    private String password;//密码
    private String phone;//电话
    private Double salary;//工资

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }
}
