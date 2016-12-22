package com.stripcode.web.sys;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.sys.model.SYSBranchOfficeInfo;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.sys.SYS80_007Service;
import com.stripcode.service.user.RscSysUserService;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/9/27.
 */
@Controller
@RequestMapping(value = "SYS80_007")
public class SYS80_007Controller extends BaseController {
    @Autowired
    private SYS80_007Service sys80_007Service;
    @Autowired
    private RscSysUserService rscSysUserService;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

//    @ResponseBody
//    @RequestMapping(value = "/read/list",method = RequestMethod.POST)
//    public JQGridObject list(HttpServletRequest request,HttpServletResponse response) {
//        Map<String, Object> params = WebUtil.getParameterMap(request);
//        return new JQGridObject(sys80_007Service.list(params));
//    }

    /**
     *分页查询所有分公司信息
     * @param request
     * @param response
     * @returns
     */
    @ResponseBody
    @RequestMapping(value = "/read/list",method = RequestMethod.GET)
    public JQGridObject list(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> params = WebUtil.getParameterMap(request);
        return new JQGridObject(sys80_007Service.selectForPage(params));
        }

    //加载简单搜索的下拉框
    @ResponseBody
    @RequestMapping(value = "/read/loadSelect",method = RequestMethod.POST)
    public Map<String,Object> loadSelect(HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("selectList", tCodeMacroDefineService.selectSFPipelineStore());
        return map;
    }

    /**
     * 更新（新增 编辑）
     * @param sysBranchOfficeInfo 分公司实体类
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(SYSBranchOfficeInfo sysBranchOfficeInfo,HttpServletResponse response) throws Exception{
        return setSuccessModelMap(sys80_007Service.update(sysBranchOfficeInfo));
        }

    /**
     * 根据rowId查
     * @param
     * @param rowId
     * @return
     */
    @RequestMapping(value = "/selectByRowId",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectByRowId(String rowId){
        Map<String,Object> map = new HashedMap();
        if(StringUtils.isNotBlank(rowId)){
            SYSBranchOfficeInfo sysBranchOfficeInfoResult = sys80_007Service.selectByRowId(rowId);
            sysBranchOfficeInfoResult.setRowId(rowId);
            map.put("main",sysBranchOfficeInfoResult);
        }
        map.put("codeList", tCodeMacroDefineService.selectSFPipelineStore());
        return  map;
    }

    //删除分公司信息
    @ResponseBody
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Map delete(@RequestParam(value = "rowId",required = true) String rowId, HttpServletResponse response){
        return setSuccessModelMap(sys80_007Service.delete(rowId));
    }

    /**
     * 检验分公司编码
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "isExistsByBranchesCode",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByBranchesCode(String branchesCode,String rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",sys80_007Service.isExistsByBranchesCode(branchesCode,rowId));
        return map;
    }

    /**
     * 检验分公司名称
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "isExistsByBranchesNameCn",method = RequestMethod.POST)
    public Map<String ,Object> isExistsByBranchesNameCn(String branchesNameCn,String rowId){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("valid",sys80_007Service.isExistsByBranchesNameCn(branchesNameCn,rowId));
        return map;
    }

    /**
     * 获取用户下拉列表
     * @return
     */
    @RequestMapping(value = "/getUserList",method = RequestMethod.POST)
        public @ResponseBody Map<String,Object> getUserList(){
            Map<String,Object> map = new HashedMap();
            List<RscSysUser> userItems = rscSysUserService.query();
            String currentUser = WebUtil.getCurrentUser();
            map.put("userItems",userItems);
            map.put("currentUser",currentUser);
            return  map;
        }

        @ResponseBody
        @RequestMapping(value = "/exportBranches")
        public String exportBranches(@RequestParam Map<String,Object> params,HttpServletRequest request,HttpServletResponse response){
            sys80_007Service.exportBranches(params,request,response);
            return null;
        }

    /**
     * 获取所有品牌
     * @return
     */
    @RequestMapping(value = "/selectBrand",method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> selectBrand(){
        Map<String,Object> map = new HashedMap();
        map.put("brandList",sys80_007Service.selectBrand());
        return  map;
    }
    }
