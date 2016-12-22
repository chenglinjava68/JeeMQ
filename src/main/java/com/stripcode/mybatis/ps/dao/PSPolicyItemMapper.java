package com.stripcode.mybatis.ps.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.ps.model.PSPolicyItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/23.
 */
public interface PSPolicyItemMapper {
    /**
     * 带分页的查询数据
     * @param object
     * @return
     */
    Page<PSPolicyItem> queryForPage(Map<String,Object> object);

    /**
     * 增加
     * @param model
     * @return
     */
    int insert(PSPolicyItem model);

    /**
     * 编辑
     * @param model
     * @return
     */
    int update(PSPolicyItem model);

    /**
     * 修改状态
     * @param model
     * @return
     */
    int updateStatus(PSPolicyItem model);
    /**
     * 查询列表的rowId带劲内容信息中
     * @param rowId
     * @return
     */
    PSPolicyItem editLoad(String rowId);

    /**
     * 导出列表数据
     * @return
     */
    List<PSPolicyItem> selectForExport(String params);
    List<PSPolicyItem> selectAllByItemType(String itemType);
    List<PSPolicyItem> selectALL(String rowId);
    Integer isExistsNumber(@Param("itemCode") String itemCode,@Param("rowId") String rowId,@Param("itemType") String itemType);
}
