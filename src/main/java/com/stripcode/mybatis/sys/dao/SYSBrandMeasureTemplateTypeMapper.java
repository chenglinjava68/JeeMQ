package com.stripcode.mybatis.sys.dao;

import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Metro
 */
public interface SYSBrandMeasureTemplateTypeMapper {
    List<TCodeMacroDefine> queryByInvestment(@Param("optimizedType") String optimizedType,@Param("brand") String brand);
}
