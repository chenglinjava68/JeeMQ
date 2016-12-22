package com.stripcode.mybatis.sys.dao;

import com.stripcode.mybatis.sys.model.SYSEstInvestmentModel;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/25.
 */
public interface SYSEstInvestmentModelMapper {

    /**
     * 带分页的查询数据
     * @param object
     * @return
     */
    Page<SYSEstInvestmentModel> queryForPage(Map<String,Object> object);

    SYSEstInvestmentModel selectLoad(String rowId);
    int update(SYSEstInvestmentModel model);
    int insert(SYSEstInvestmentModel model);
    int updatesave(SYSEstInvestmentModel model);

/**
 * 导出
 */
List<SYSEstInvestmentModel> selectForExport(Map<String,Object> Object);
}
