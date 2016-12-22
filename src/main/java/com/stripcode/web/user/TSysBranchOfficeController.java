package com.stripcode.web.user;

import com.stripcode.mybatis.user.model.TSysBranchOffice;
import com.stripcode.service.user.TSysBranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Metro on 2016/9/28.
 */
@Controller
@RequestMapping("/office")
public class TSysBranchOfficeController {
    @Autowired
    private TSysBranchOfficeService tSysBranchOfficeService;
    @RequestMapping(value = "/read/selectForTree",method= RequestMethod.POST)
    @ResponseBody
    public List<TSysBranchOffice> selectForTree(HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        return tSysBranchOfficeService.selectForTree();
    }
}
