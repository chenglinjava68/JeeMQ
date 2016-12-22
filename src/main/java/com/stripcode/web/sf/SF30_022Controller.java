package com.stripcode.web.sf;

import com.stripcode.core.dto.common.CreateOrModifySFEstInvestmentDto;
import com.stripcode.core.util.excelUtil.ImportExcel;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.sf.model.SFTrafficcountDetail;
import com.stripcode.service.sf.SF30_022Service;
import com.stripcode.web.BaseController;
import com.stripcode.web.file.DownFileController;
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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/11/15.
 */
@Controller
@RequestMapping("/SF30_022")
public class SF30_022Controller extends BaseController{
    @Autowired
    private SF30_022Service sf30_022Service;
    @Resource
    private DownFileController downFileController;
    @Resource
    private FileUploadController fileUploadController;
    //投资预测保存方法
    @RequestMapping(value = "/saveInvestmentInfo",method = RequestMethod.POST)
    @ResponseBody
    public Map saveInvestmentInfo(CreateOrModifySFEstInvestmentDto dto,TSysCommonattached tSysCommonattached, HttpServletResponse response, HttpServletRequest request) throws  Exception{
        String filePath = dto.getFilePath();
        HashMap map = null;
        if(StringUtils.isNotBlank(filePath)){
           map = fileUploadController.upLoadExistFileToServer(filePath,true,tSysCommonattached,request,response);
        }
        if(dto.getInvestment() != null){
            dto.getInvestment().setAttachId((String) map.get("attachId"));
        }
        return  sf30_022Service.update(dto);
    }
    //投资预测查询方法
    @RequestMapping("/selectInvestmentInfo")
    @ResponseBody
    public CreateOrModifySFEstInvestmentDto selectInvestmentInfo(String investmentId,String ppId) throws  Exception{
        return  sf30_022Service.selectInvestmentInfo(investmentId,ppId);
    }

    //意向店销售测算 Excel导入功能
    @RequestMapping("/importTrafficcountExcel")
    @ResponseBody
    public void importTrafficcountExcel(String filePath, TCsTaskCompletion tCsTaskCompletion)throws  Exception {
        ImportExcel ie = new ImportExcel();
        try {
            InputStream is = new FileInputStream(filePath);
            Map<String, Object> map = ie.readExcelContent(is);
            sf30_022Service.insertSFTrafficcount(map,tCsTaskCompletion);
        }catch (FileNotFoundException e) {
            logger.info("未找到指定路径的文件!");
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/selectSFTrafficcount",method = RequestMethod.POST)
    public HashMap<String, Object> selectSFTrafficcount(String ppId){
        return sf30_022Service.selectSFTrafficcount(ppId);
    }

    @ResponseBody
    @RequestMapping(value = "/selectSFTrafficcountDetail",method = RequestMethod.POST)
    public List<SFTrafficcountDetail> selectSFTrafficcountDetail(String testId){
        return sf30_022Service.selectSFTrafficcountDetail(testId);
    }

    @ResponseBody
    @RequestMapping(value = "/updateSFTrafficcount",method = RequestMethod.POST)
    public Map updateSFTrafficcount(String rowId,String ppId){
        return sf30_022Service.updateSFTrafficcount(rowId, ppId);
    }
}
