/**
 *
 */
package com.stripcode.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.user.dao.RscSysRoleMapper;
import com.stripcode.mybatis.user.model.RscSysRole;
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
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "rscSysRole")
public class RscSysRoleService {
    @Autowired
    private RscSysRoleMapper rscSysRoleMapper;
    @Autowired
    private RscSysUserService rscSysUserService;
    public Map update(RscSysRole record) throws  Exception{
        Map modelMap = new HashMap();
        if (isExists(record)) {
            modelMap.put("result", false);
            modelMap.put("message", "角色编码已存在重新填写！");
            return modelMap;
        }
        int count = -1;
        if (StringUtils.isBlank(record.getRoleId())) {
            record.setRoleId(UUIDUtils.generateKey());
            count = rscSysRoleMapper.insert(record);
            if (count == 1) {
                modelMap.put("result", true);
                modelMap.put("message", "保存成功！");
                modelMap.put("id",record.getRoleId());
                return modelMap;
            }
            modelMap.put("result", false);
            modelMap.put("message", "保存失败！");
            return modelMap;
        }
        count = rscSysRoleMapper.updateByPrimaryKey(record);
        if (count == 1) {
            modelMap.put("result", true);
            modelMap.put("message", "修改成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "修改失败！");
        return modelMap;
    }

    public boolean isExists(RscSysRole record){
        int isExists = rscSysRoleMapper.selectForExists(record);
        if(isExists > 0 ){
            return true;
        }
        return false;
    }

    public void exportRole(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {

        /*List<ExcelHeader<RscSysRole>> headers = new ArrayList<ExcelHeader<RscSysRole>>();
        headers.add(new ExcelHeader<RscSysRole>("角色编码", "roleCode"));
        headers.add(new ExcelHeader<RscSysRole>("角色名称", "roleName"));
        headers.add(new ExcelHeader<RscSysRole>("状态", "statusName"));
        headers.add(new ExcelHeader<RscSysRole>("备注", "comments"));
        RscSysUser creator  = rscSysUserService.queryById(WebUtil.getCurrentUser());
        List<RscSysRole> data = rscSysRoleMapper.selectForExport();
        new ExcelExporter(request,response).export(new ExcelDocument<RscSysRole>(5000,"全部角色信息",creator == null ? "" : creator.getUserName(),headers,data));*/

        try {
            Page<RscSysRole> page = rscSysRoleMapper.queryForPage(params);
            List<RscSysRole> data = page.getResult();
            String fileName = "角色管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("角色管理", RscSysRole.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }

    }

    public RscSysRole getRolebyid(String roleid){
      return  rscSysRoleMapper.getRolebyid(roleid);
    }
    @Transactional
    public Map delete(String id) {
        Map modelMap = new HashMap();
        int count =  rscSysRoleMapper.deleteByPrimaryKey(id);
        if(count ==1 ){
            modelMap.put("result", true);
            modelMap.put("message", "删除成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "删除失败！");
        return  modelMap;
    }
    public RscSysRole queryById(String id) {
        return rscSysRoleMapper.selectByPrimaryKey(id);
    }
    List<RscSysRole> queryByPostionId(String postionid){
        return rscSysRoleMapper.queryByPostionId(postionid);
    }
    public PageInfo<RscSysRole> queryForPage(Map<String, Object> params) {
        return new PageInfo<RscSysRole>(rscSysRoleMapper.queryForPage(params));
    }
    public List<RscSysRole> query(Map<String, Object> params){
        return  rscSysRoleMapper.query(params);
    }
    public List<RscSysRole> query(){
        return  rscSysRoleMapper.selectAll();
    }
}
