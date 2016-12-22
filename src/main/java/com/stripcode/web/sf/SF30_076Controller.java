package com.stripcode.web.sf;

import com.stripcode.core.dto.common.CreateOrModifyInvestmentCopartnerDto;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.service.sf.SF30_076Service;
import com.stripcode.web.BaseController;
import com.stripcode.web.file.FileUploadController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/11/15.
 */
@Controller
@RequestMapping("/SF30_076")
public class SF30_076Controller extends BaseController{
    @Autowired
    private SF30_076Service sf30_076Service;
    @Resource
    private FileUploadController fileUploadController;
    //投资预测保存方法
    @RequestMapping(value = "/saveInvestmentCopartner",method = RequestMethod.POST)
    @ResponseBody
    public Map saveInvestmentCopartner(CreateOrModifyInvestmentCopartnerDto dto, TSysCommonattached tSysCommonattached, HttpServletResponse response, HttpServletRequest request) throws  Exception{
        String filePath = dto.getFilePath();
        HashMap map = null;
        if(StringUtils.isNotBlank(filePath)){
           map = fileUploadController.upLoadExistFileToServer(filePath,true,tSysCommonattached,request,response);
        }
        if(dto.getInvestment() != null){
            dto.getInvestment().setAttachId((String) map.get("attachId"));
        }
        return  sf30_076Service.saveInvestmentCopartner(dto);
    }
    //投资预测查询方法
    @RequestMapping("/selectInvestmentCopartner")
    @ResponseBody
    public CreateOrModifyInvestmentCopartnerDto selectInvestmentCopartner(String ppId,String investmentId) throws  Exception{
        return  sf30_076Service.selectInvestmentCopartner(ppId,investmentId);
    }
}
