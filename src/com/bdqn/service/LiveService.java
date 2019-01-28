package com.bdqn.service;

import com.bdqn.bean.Live;
import com.bdqn.utils.Page;

import java.util.Map;

public interface LiveService {

    /**
     * 添加入住
     * @param params 入住信息列表
     * @return 执行后结果
     */
    int addLive(Object... params);

    /**
     * 根据入住编号查询信息
     * @param id 入住编号
     * @return 查询结果
     */
    Live getLiveById(String id);

    /**
     * 根据入住编号修改入住信息
     * @param params 修改的入住信息列表
     * @return
     */
    int editLiveSave(Object... params);

    /**
     * 入住列表查询
     * @param pageNum 当前页码
     * @return 返回入住信息
     */
    Page<Live> liveList(int pageNum);

    /**
     * 根据入住编号删除入住信息
     * @param id 入住编号
     * @return
     */
    int deleteLive(String id);

    /**
     * 根据搜索内容搜索入住信息
     * @param pageNum 页码
     * @param map 搜索内容列表
     * @return 搜索结果
     */
    Page<Live> searchLive(int pageNum, Map<String, String[]> map);

}
