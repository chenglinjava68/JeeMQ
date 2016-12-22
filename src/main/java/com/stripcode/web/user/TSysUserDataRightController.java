package com.stripcode.web.user;

import com.stripcode.core.dto.user.CreateUserRightDto;
import com.stripcode.mybatis.cs.model.CSCSustomerOfficeMap;
import com.stripcode.mybatis.user.model.TSysBranchOffice;
import com.stripcode.mybatis.user.model.TSysUserDataRight;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.service.user.TSysBranchOfficeService;
import com.stripcode.service.user.TSysUserDataRightService;
import com.stripcode.web.BaseController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userright")
public class TSysUserDataRightController extends BaseController {
    private final static Logger LOGGER = Logger.getLogger(TSysUserDataRightController.class);

    @Autowired
    private TSysUserDataRightService tSysUserDataRightService;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private TSysBranchOfficeService tSysBranchOfficeService;
    @ResponseBody
    @RequestMapping("/save")
    public Map<String,Object> save(CreateUserRightDto dto, HttpServletResponse response) throws  Exception{
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return setSuccessModelMap(tSysUserDataRightService.save(dto.getUserRights(),dto.getPositionId()));
    }

    @ResponseBody
    @RequestMapping("/read/queryRange")
    public Map<String,Object> rangeList(TSysUserDataRight tSysUserDataRight,HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");        response.setHeader("Access-Control-Allow-Origin","*");
        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("userRights",tSysUserDataRightService.selectByPositionId(tSysUserDataRight));
        map.put("brands",tCodeMacroDefineService.selectForUserRight());
        return map;
    }
    @ResponseBody
    @RequestMapping("/read/queryBatchCompany")
    public List<TSysBranchOffice> queryBatchCompany(TSysBranchOffice tSysBranchOffice, HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return tSysBranchOfficeService.selectByBrand(tSysBranchOffice);
    }
    @ResponseBody
    @RequestMapping("/read/queryCustomer")
    public List<Map<String,Object>> queryCustomer(CSCSustomerOfficeMap cscSustomerOfficeMap, HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return tSysUserDataRightService.selectCustomer(cscSustomerOfficeMap);
    }
}
