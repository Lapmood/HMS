package com.bdqn.servlet;

import com.bdqn.bean.Employee;
import com.bdqn.service.EmployeeService;
import com.bdqn.service.impl.EmployeeServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet(urlPatterns = "/EmployeeServlet")
public class EmployeeServlet extends BaseServlet {

    private EmployeeService employeeService;

    @Override
    public void init() throws ServletException {
        employeeService = new EmployeeServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        return "WEB-INF/page/employeeAdd.jsp";
    }

    //添加入住
    public String addEmployee(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String salary = request.getParameter("salary");

        String empId = new SimpleDateFormat("yyMMddHHmm").format(new Date());
        //执行添加操作
        int i = employeeService.addEmployee(empId,userId,password,phone,salary);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("msg","添加成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","添加失败!");
        }
        return "EmployeeServlet?opt=employeeList";
    }

    //获取需要编辑的入住信息
    public String editEmployee(HttpServletRequest request, HttpServletResponse response){
        Employee employee = employeeService.getEmployeeById(request.getParameter("id"));
        request.setAttribute("employee",employee);
        return "WEB-INF/page/employeeAdd.jsp";
    }

    //入住检索
    public String employeeList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Employee> page = employeeService.employeeList(pageNum);
        request.setAttribute("page",page);
        return "WEB-INF/page/employeeList.jsp";
    }

    //保存编辑后的入住信息
    public String editEmployeeSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String salary = request.getParameter("salary");
        String id = request.getParameter("id");
        int i = employeeService.editEmployeeSave(userId,password,phone,salary,id);
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","修改成功!");
        }else{
            request.setAttribute("msg","修改失败!");
            request.setAttribute("flag","false");
        }
        return "EmployeeServlet?opt=employeeList";
    }

    public String deleteEmployee(HttpServletRequest request, HttpServletResponse response){
        int i = employeeService.deleteEmployee(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("msg","删除成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("msg","删除失败!");
            request.setAttribute("flag","false");
        }
        return "EmployeeServlet?opt=employeeList";
    }

    //检索入住
    public String searchEmployee(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<Employee> page = employeeService.searchEmployee(pageNum,map);
        request.setAttribute("page",page);
        return "WEB-INF/page/employeeList.jsp";
    }

}
