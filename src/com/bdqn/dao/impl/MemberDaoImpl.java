package com.bdqn.dao.impl;

import com.bdqn.bean.Member;
import com.bdqn.bean.MemberType;
import com.bdqn.dao.MemberDao;
import com.bdqn.utils.JDBCUtils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class MemberDaoImpl implements MemberDao {

    @Override
    public int addMember(Connection connection,Object... params) throws Exception {
        String sql = "INSERT INTO t_member (id,t_m_id,m_id,m_name,sex,id_card_no,status,address,phone,account_balance,total_money,remark) VALUES(null,?,?,?,?,?,?,?,?,round(?,2),round(?,2),?)";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public long getTotal(Connection connection) throws Exception {
        String sql = "SELECT count(0) FROM t_member";
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>());
        return total;
    }

    @Override
    public Member getMemberById(Connection connection, String id) throws Exception {
        String sql="SELECT id,t_m_id memberType,m_id memberId,m_name memberName,sex,id_card_no idCard,status,address,phone,account_balance balance,total_money totalMoney,remark FROM " +
                "t_member WHERE id = ?";
        Member Member = JDBCUtils.query(connection, sql, new BeanHandler<>(Member.class), id);
        return Member;
    }

    @Override
    public int editMemberSave(Connection connection, Object... params) throws Exception {
        String sql = "UPDATE t_member set t_m_id=?,m_id=?,m_name=?,sex=?,id_card_no=?,status=?,address=?,phone=?,account_balance=?,total_money=?,remark=? " +
                " WHERE id=?";
        int update = JDBCUtils.update(connection, sql, params);
        return update;
    }

    @Override
    public int deleteMember(Connection connection, String id) throws Exception {
        String sql = "DELETE FROM t_member WHERE id = ?";
        int update = JDBCUtils.update(connection, sql, id);
        return update;
    }

    @Override
    public long getSearchTotal(Connection connection, Map<String,String[]> map) throws Exception {
        String sql = "SELECT count(0) FROM t_member WHERE 1=1 ";
        sql = structSql(sql, map);
        Object[] params = structParams(map);
        Long total = (Long) JDBCUtils.query(connection, sql, new ScalarHandler<>(),params);
        return total;
    }

    @Override
    public List<Member> memberList(Connection connection, int start, int pageSize) throws Exception {
        String sql="SELECT id,t_m_id memberType,m_id memberId,m_name memberName,sex,id_card_no idCard,status,address,phone,account_balance balance,total_money totalMoney,remark FROM " +
                "t_member order by id desc limit ?,?";
        List<Member> query = JDBCUtils.query(connection, sql, new BeanListHandler<Member>(Member.class),start,pageSize);
        return query;
    }

    @Override
    public List<MemberType> getMemberType(Connection connection) throws Exception {
        String sql = "SELECT id,type,discount,remark FROM t_member_type";
        List<MemberType> query = JDBCUtils.query(connection, sql, new BeanListHandler<MemberType>(MemberType.class));
        return query;
    }

    @Override
    public List<Member> searchMember(Connection connection, Map<String,String[]> map, int start, int pageSize) throws Exception {
        String sql="SELECT id,t_m_id memberType,m_id memberId,m_name memberName,sex,id_card_no idCard,status,address,phone,account_balance balance,total_money totalMoney,remark FROM " +
                "t_member WHERE 1=1 ";
        sql = structSql(sql, map);
        sql += " order by id desc limit ?,?";
        Object[] p = structParams(map);
        Object[] params = null;
        if(p != null){
            params = Arrays.copyOf(p,p.length+2);
        }else {
            params = new Object[2];
        }
        params[params.length-2] = start;
        params[params.length-1] = pageSize;
        List<Member> Members = JDBCUtils.query(connection, sql, new BeanListHandler<Member>(Member.class), params);
        return Members;
    }

    public Object[] structParams(Map<String,String[]> map){
        String key = "";
        if(!"".equals(map.get("memberId")[0])){
            key += "memberId-";
        }
        if(!"".equals(map.get("memberName")[0])){
            key += "memberName-";
        }
        if(!"".equals(map.get("memberType")[0])){
            key += "memberType-";
        }
        String[] split = null;
        Object[] params = null;
        System.out.println(key+"======>");
        if(!key.equals("")){
            split = key.substring(0, key.lastIndexOf("-")).split("-");
            params = new Object[split.length];
            for (int i = 0; i < split.length; i++) {
                System.out.println(split[i]+"----"+Arrays.toString(map.get(split[i])));
                params[i] = map.get(split[i])[0];
            }
        }

        System.out.println("=====>"+params);
        return params;
    }

    public String structSql(String sql,Map<String,String[]> map){
        if(!"".equals(map.get("memberId")[0])){
            sql += "AND m_id=? ";
        }
        if(!"".equals(map.get("memberName")[0])){
            sql += "AND m_name=? ";
        }
        if(!"".equals(map.get("memberType")[0])){
            sql += "AND t_m_id=? ";
        }

        return sql;
    }
}
