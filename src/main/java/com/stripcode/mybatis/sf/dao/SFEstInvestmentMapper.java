package com.stripcode.mybatis.sf.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.sf.model.SFEstInvestment;
import com.stripcode.mybatis.sf.model.SFEstInvestmentDetail;
import com.stripcode.mybatis.sf.model.SFEstInvestmentResultData;
import com.stripcode.mybatis.sf.model.SFReport;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
public interface SFEstInvestmentMapper {
    Page<SFEstInvestment> selectForPage(Map<String,Object> map);

    List<SFEstInvestmentDetail> queryInvestDetail(@Param("parentCode") String parentCode,@Param("investmentId") String investmentId);

    Integer insertEstInvestment(SFEstInvestment model);

    Integer updateEstInvestment(SFEstInvestment model);

    Integer insertEstInvestmentDetail(SFEstInvestmentDetail model);

    Integer updateEstInvestmentDetail(SFEstInvestmentDetail model);

    Integer insertEstInvestmentResultData(SFEstInvestmentResultData model);

    Integer updateEstInvestmentResultData(SFEstInvestmentResultData model);

    Integer isExistsEstInvestmentDetail(@Param("rowId")String rowId,@Param("investmentId") String investmentId,@Param("item") String item);

    Integer deleteInvestment(@Param("rowId")String rowId,@Param("ppId") String ppId);

    Integer deleteInvestmentDetail(String investmentId);

    Integer deleteInvestmentResultDate(String investmentId);

    SFEstInvestmentResultData queryResultData(String investmentId);

    Integer isExistsEstInvestmentResultData(@Param("investmentId") String investmentId,@Param("rowId") String rowId);

    Map<String,String>  getFilePath(@Param("modelType") String modelType,@Param("brand") String brand);

    List<SFEstInvestmentDetail> selectInvestmentDetail(@Param("optimauthId") String optimauthId);

    SFEstInvestmentResultData selectResultData(@Param("optimauthId") String optimauthId);

    List<SFReport> queryReport(String ppId);

    Integer updateSubmitStatus(@Param("rowIds") ArrayList rowIds,@Param("ppId")String ppId);

    Integer updateSubmitStatusByRowId(@Param("rowIds") ArrayList rowIds);

    int deleteById(String rowId);
}
