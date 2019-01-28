package com.bdqn.service;

import com.bdqn.bean.Member;
import com.bdqn.bean.MemberType;
import com.bdqn.utils.Page;

import java.util.List;
import java.util.Map;

public interface MemberService {

    /**
     * 添加会员
     * @param params 会员信息列表
     * @return 执行后结果
     */
    int addMember(Object... params);

    /**
     * 根据会员编号查询信息
     * @param id 会员编号
     * @return 查询结果
     */
    Member getMemberById(String id);

    /**
     * 根据会员编号修改会员信息
     * @param params 修改的会员信息列表
     * @return
     */
    int editMemberSave(Object... params);

    /**
     * 会员列表查询
     * @param pageNum 当前页码
     * @return 返回会员信息
     */
    Page<Member> memberList(int pageNum);

    /**
     * 根据会员编号删除会员信息
     * @param id 会员编号
     * @return
     */
    int deleteMember(String id);

    /**
     * 根据搜索内容搜索会员信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Member> searchMember(int pageNum, Map<String, String[]> map);

    /**
     * 获取所有会员类型
     * @return 会员列表
     */
    List<MemberType> getMemberType();
}
