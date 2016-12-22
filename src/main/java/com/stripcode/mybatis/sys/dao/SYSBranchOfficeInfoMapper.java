package com.stripcode.mybatis.sys.dao;

import com.github.pagehelper.Page;
import com.stripcode.mybatis.sys.model.SYSBranchOfficeInfo;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/27.
 */
public interface SYSBranchOfficeInfoMapper {
    /**
     * 分页查询所有
     * @param map
     * @return
     */
    Page<SYSBranchOfficeInfo> selectForPage(Map<String, Object> map);

    /**
     * 添加
     * @param model
     * @return
     */
    int insert(SYSBranchOfficeInfo model);

    /**
     * 更新
     * @param model
     * @return
     */
    int updateByPrimaryKey(SYSBranchOfficeInfo model);

    /**
     * 根据rowId查询分公司信息
     * @param rowId
     * @return
     */
    SYSBranchOfficeInfo selectByRowId(String rowId);

    /**
     * 删除
     * @param rowId
     * @return
     */
    int deleteByPrimaryKey(String rowId);

    /**
     * 检查分公司编码是否存在
     * @param branchesCode
     * @param rowId
     * @return
     */
    Integer isExistsByBranchesCode(@Param("branchesCode") String branchesCode,@Param("rowId") String rowId);

    /**
     * 检查啊分公司名称是否存在
     * @param branchesNameCn
     * @param rowId
     * @return
     */
    Integer isExistsByBranchesNameCn(@Param("branchesNameCn") String branchesNameCn,@Param("rowId") String rowId);

    List<SYSBranchOfficeInfo> selectForExport(Map<String,Object> param);

    List<TCodeMacroDefine> selectBrand();
}
