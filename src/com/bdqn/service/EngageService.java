package com.bdqn.service;

import com.bdqn.bean.Engage;
import com.bdqn.utils.Page;

import java.util.Map;

public interface EngageService {

    /**
     * 添加预订
     * @param params 预订信息列表
     * @return 执行后结果
     */
    int addEngage(Object...params);

    /**
     * 预订列表查询
     * @param pageNum 当前页码
     * @return 返回预订信息
     */
    Page<Engage> engageList(int pageNum);

    /**
     * 根据预订编号查询信息
     * @param id 预订编号
     * @return 查询结果
     */
    Engage getEngageById(String id);

    /**
     * 根据预订编号修改预订信息
     * @param params 修改的预订信息列表
     * @return
     */
    int editEngageSave(Object...params);

    /**
     * 根据预订编号删除预订信息
     * @param id 预订编号
     * @return
     */
    int deleteEngage(String id);

    /**
     * 根据搜索内容搜索预订信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Engage> searchEngage(int pageNum, Map<String,String> map);
}
