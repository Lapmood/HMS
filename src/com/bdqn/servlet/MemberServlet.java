package com.bdqn.servlet;

import com.bdqn.bean.Member;
import com.bdqn.bean.MemberType;
import com.bdqn.service.MemberService;
import com.bdqn.service.impl.MemberServiceImpl;
import com.bdqn.utils.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/MemberServlet")
public class MemberServlet extends BaseServlet {

    private MemberService memberService;

    @Override
    public void init() throws ServletException {
        memberService = new MemberServiceImpl();
    }

    public String addPage(HttpServletRequest request, HttpServletResponse response){
        getMemberType(request,response);
        return "WEB-INF/page/memberAdd.jsp";
    }

    /**
     * 获取所有会员类型
     * @param request
     * @param response
     */
    public void getMemberType(HttpServletRequest request, HttpServletResponse response){
        List<MemberType> memberTypes = memberService.getMemberType();
        request.setAttribute("memberTypes",memberTypes);
    }

    //添加会员
    public String addMember(HttpServletRequest request, HttpServletResponse response){

        //获取请求参数
        String memberId = request.getParameter("memberId");
        String memberName = request.getParameter("memberName");
        String memberType = request.getParameter("memberType");
        String sex = request.getParameter("sex");
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");
        String totalMoney = request.getParameter("totalMoney");
        String remark = request.getParameter("remark");

        //执行添加操作
        int i = memberService.addMember(memberType,memberId,memberName,sex,idCard,status,address,phone,balance,totalMoney,remark);

        //判断是否添加成功
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","添加成功!");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","添加失败!");
        }
        return "MemberServlet?opt=memberList";
    }

    //获取需要编辑的会员信息
    public String editMember(HttpServletRequest request, HttpServletResponse response){
        Member member = memberService.getMemberById(request.getParameter("id"));
        request.setAttribute("member",member);
        getMemberType(request,response);
        return "WEB-INF/page/memberAdd.jsp";
    }

    //会员检索
    public String memberList(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        Page<Member> page = memberService.memberList(pageNum);
        request.setAttribute("page",page);
        getMemberType(request,response);
        return "WEB-INF/page/memberList.jsp";
    }

    //保存编辑后的会员信息
    public String editMemberSave(HttpServletRequest request, HttpServletResponse response){
        //获取请求参数
        String memberId = request.getParameter("memberId");
        String memberName = request.getParameter("memberName");
        String memberType = request.getParameter("memberType");
        String sex = request.getParameter("sex");
        String idCard = request.getParameter("idCard");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        String phone = request.getParameter("phone");
        String balance = request.getParameter("balance");
        String totalMoney = request.getParameter("totalMoney");
        String remark = request.getParameter("remark");
        String id = request.getParameter("id");
        int i = memberService.editMemberSave(memberType,memberId,memberName,sex,idCard,status,address,phone,balance,totalMoney,remark,id);
        if(i != 0){
            request.setAttribute("flag","true");
            request.setAttribute("msg","修改成功!");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","修改失败!");
        }
        getMemberType(request,response);
        return "MemberServlet?opt=memberList";
    }

    public String deleteMember(HttpServletRequest request, HttpServletResponse response){
        int i = memberService.deleteMember(request.getParameter("id"));
        if(i != 0){
            request.setAttribute("msg","删除成功!");
            request.setAttribute("flag","true");
        }else{
            request.setAttribute("flag","false");
            request.setAttribute("msg","删除失败!");
        }
        return "MemberServlet?opt=memberList";
    }

    //检索会员
    public String searchMember(HttpServletRequest request, HttpServletResponse response){
        String num = request.getParameter("pageNum");
        Integer pageNum = 1;
        if(num != null){
            pageNum = new Integer(num);
        }
        //获取搜索内容
        //将搜索内容封装为map集
        Map<String, String[]> map = request.getParameterMap();

        Page<Member> page = memberService.searchMember(pageNum,map);
        request.setAttribute("page",page);
        getMemberType(request,response);
        return "WEB-INF/page/memberList.jsp";
    }
}
