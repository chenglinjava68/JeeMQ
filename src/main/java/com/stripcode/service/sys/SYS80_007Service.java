package com.stripcode.service.sys;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.sys.dao.SYSBranchOfficeInfoMapper;
import com.stripcode.mybatis.sys.model.SYSBranchOfficeInfo;
import com.stripcode.mybatis.user.dao.RscSysUserMapper;
import com.stripcode.mybatis.user.model.TCodeMacroDefine;
import com.stripcode.service.user.RscSysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/27.
 */
@Service()
@CacheConfig(cacheNames = "SYS80_007")
public class SYS80_007Service {
    @Autowired
    private SYSBranchOfficeInfoMapper sysBranchOfficeInfoMapper;
    @Autowired
    private RscSysUserMapper rscSysUserMapper;
    @Autowired
    private RscSysUserService rscSysUserService;

    /**
     * 分页查询所有
     * @param params
     * @return
     */
    public PageInfo<SYSBranchOfficeInfo> selectForPage(Map<String, Object> params) {
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<SYSBranchOfficeInfo>(sysBranchOfficeInfoMapper.selectForPage(params));
    }

    /**
     * 根据Rid查询
     * @param rowId
     * @return
     */
    public SYSBranchOfficeInfo selectByRowId(String rowId){
        return sysBranchOfficeInfoMapper.selectByRowId(rowId);
    }

    /**
     * 新增 TODO更新
     * @param model
     * @return
     * @throws Exception
     */
    @Transactional
    public Map update(SYSBranchOfficeInfo model)throws Exception{
        Map map = new HashMap();
        //获取rowId
        String rowId = model.getRowId();
        //标识符
        int count = -1;
        if (StringUtils.isBlank(rowId)){
            //  新增
            rowId = UUIDUtils.generateKey();
            model.setRowId(rowId);
            count = sysBranchOfficeInfoMapper.insert(model);
            if (count == 1){
                map.put("result",true);
                map.put("message","保存成功");
                map.put("rowId",model.getRowId());
                return map;
            }
                map.put("result",false);
                map.put("message","保存失败");
                return  map;
        }else {
            count = sysBranchOfficeInfoMapper.updateByPrimaryKey(model);
            if (count == 1){
                map.put("result",true);
                map.put("message","保存成功");
                return  map;
            }
            map.put("result",false);
            map.put("message","保存失败");
            return  map;
        }
    }

    /**
     * 删除
     * @param rowId
     * @return
     */
    @Transactional
    public Map delete(String rowId) {
        Map modelMap = new HashMap();
        int count = sysBranchOfficeInfoMapper.deleteByPrimaryKey(rowId);
        if (count == 1) {
            modelMap.put("result", true);
            modelMap.put("message", "删除成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "删除失败！");
        return modelMap;
    }

    /**
     * 检查分公司编码是否存在
     * @param
     * @return
     */
    public boolean isExistsByBranchesCode(String branchesCode,String rowId){
      int isExists1 = sysBranchOfficeInfoMapper.isExistsByBranchesCode(branchesCode,null);

        int isExists = sysBranchOfficeInfoMapper.isExistsByBranchesCode(branchesCode,rowId);
        //用于屏蔽自身
        if(StringUtils.isNotBlank(rowId)){
            if(isExists1==1&&isExists==1){
                return true;
            }
        }

        if (isExists1 > 0) {
            return false;
        }
        return true;
    }

    /**
     * 检查分公司名称是否存在
     * @param
     * @return
     */
    public boolean isExistsByBranchesNameCn(String branchesNameCn,String rowId){
        int isExists1 = sysBranchOfficeInfoMapper.isExistsByBranchesNameCn(branchesNameCn,null);

        int isExists = sysBranchOfficeInfoMapper.isExistsByBranchesNameCn(branchesNameCn,rowId);
        //用于屏蔽自身
        if(StringUtils.isNotBlank(rowId)){
            if(isExists1==1&&isExists==1){
                return true;
            }
        }

        if (isExists1 > 0) {
            return false;
        }
        return true;
    }


    public void exportBranches(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
       /* List<ExcelHeader<SYSBranchOfficeInfo>> header = new ArrayList<ExcelHeader<SYSBranchOfficeInfo>>();
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("分公司编码","branchesCode"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("分公司名称(中文)","branchesNameCn"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("分公司名称(英文）","branchesNameEn"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("品牌","brand"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("门店","def1"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("意向店","def2"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("运营负责人","operationDirector"));
        header.add(new ExcelHeader<SYSBranchOfficeInfo>("办公地址","address"));
        RscSysUser creator = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<SYSBranchOfficeInfo> data = sysBranchOfficeInfoMapper.selectForExport(params);
        new ExcelExporter(request,response).export(new ExcelDocument<SYSBranchOfficeInfo>(5000,"全部分公司信息",creator == null ? "" : creator.getUserName(),header,data));*/

       try{
           String fileName = "分公司信息"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            List<SYSBranchOfficeInfo> data = sysBranchOfficeInfoMapper.selectForExport(params);
           new ExportExcel("分公司信息",SYSBranchOfficeInfo.class).setDataList(data).write(response,fileName).dispose();
       }catch (Exception e){}
    }

    public List<TCodeMacroDefine> selectBrand(){
        return sysBranchOfficeInfoMapper.selectBrand();
    }
}
