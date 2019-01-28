package com.bdqn.dao;

import com.bdqn.bean.Member;
import com.bdqn.bean.MemberType;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public interface MemberDao {

    /**
     *
     * 添加会员信息
     * @param connection 数据库连接对象
     * @param params 会员信息参数列表
     * @return 执行结果
     * @throws Exception 异常
     */
    int addMember(Connection connection, Object... params) throws Exception;

    /**
     * 计算总条数
     * @param connection 数据库连接对象
     * @return 总条数
     */
    long getTotal(Connection connection) throws Exception;

    /**
     * 根据会员编号查询会员信息
     * @param connection 数据库连接对象
     * @param id 会员编号
     * @return 会员信息
     */
    Member getMemberById(Connection connection, String id) throws Exception;

    /**
     * 根据会员编号修改会员信息
     * @param connection 数据库连接对象
     * @param params 修改的会员信息列表
     * @param params 会员信息列表
     * @return 执行结果
     */
    int editMemberSave(Connection connection, Object... params) throws Exception;

    /**
     * 根据会员编号删除会员信息
     * @param connection 数据库连接对象
     * @param id 会员编号
     * @return 执行结果
     */
    int deleteMember(Connection connection, String id) throws Exception;

    /**
     * 查询指定搜索内容的总条数
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @return 执行结果
     */
    long getSearchTotal(Connection connection, Map<String, String[]> map) throws Exception;

    /**
     * 查询搜索内容的所有会员信息
     * @param connection 数据库连接对象
     * @param map 搜索内容列表
     * @param start 分页开始值
     * @param pageSize 分页每页条数
     * @return 查询结果
     */
    List<Member> searchMember(Connection connection, Map<String, String[]> map, int start, int pageSize) throws Exception;

    List<Member> memberList(Connection connection, int start, int pageSize) throws Exception;

    /**
     * 获取所有会员类型
     * @param connection 数据库连接对象
     * @return 会员类型列表
     */
    List<MemberType> getMemberType(Connection connection) throws Exception;
}
