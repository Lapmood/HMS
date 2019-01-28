package com.bdqn.service.impl;

import com.bdqn.bean.Member;
import com.bdqn.bean.MemberType;
import com.bdqn.dao.MemberDao;
import com.bdqn.dao.impl.MemberDaoImpl;
import com.bdqn.service.MemberService;
import com.bdqn.service.MemberService;
import com.bdqn.utils.JDBCUtils;
import com.bdqn.utils.Page;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class MemberServiceImpl implements MemberService{

    private MemberDao memberDao;

    public MemberServiceImpl(){
        memberDao = new MemberDaoImpl();
    }

    @Override
    public int addMember(Object... params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行添加操作
            int i = memberDao.addMember(connection,params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //获取指定的预订信息
    @Override
    public Member getMemberById(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            Member Member = memberDao.getMemberById(connection, id);
            return Member;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //修改预订信息
    @Override
    public int editMemberSave(Object...params) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {

            //执行查询操作
            int i = memberDao.editMemberSave(connection, params);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteMember(String id) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            int i = memberDao.deleteMember(connection, id);
            return i;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //预定列表
    @Override
    public Page<Member> memberList(int pageNum) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = memberDao.getTotal(connection);
            Page<Member> page = new Page<>(pageNum,total);

            //执行查询操作
            List<Member> engages = memberDao.memberList(connection,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Page<Member> searchMember(int pageNum, Map<String,String[]> map) {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //清除总条数
            long total = memberDao.getSearchTotal(connection,map);
            Page<Member> page = new Page<>(pageNum,total);
            //执行查询操作
            List<Member> engages = memberDao.searchMember(connection,map,page.getStart(),page.getPageSize());
            page.startPage(engages);
            return page;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MemberType> getMemberType() {
        try (
                //获取连接对象
                Connection connection = JDBCUtils.getConnection();)
        {
            //执行查询操作
            List<MemberType> memberTypes = memberDao.getMemberType(connection);
            return memberTypes;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
