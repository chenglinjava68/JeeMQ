package com.stripcode.web.cs;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.mybatis.cp.model.CpMarketInfo;
import com.stripcode.mybatis.cs.model.CSMarketDiscountSplit;
import com.stripcode.service.cs.CS20_006Service;
import com.stripcode.service.cs.CS20_018Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("CS20_018")
public class CS20_018Controller{
    @Autowired
    private CS20_018Service cs20_018Service;

    @Autowired
    private CS20_006Service cs20_006Service;

    @ResponseBody
    @RequestMapping(value = "/insertCustomerErpInfo",method = RequestMethod.POST)
    public Map insertCustomerErpInfo(String optimauthId, String taskId, String customerId){
        CreateOrModifyCsTaskCompletionDto csTaskCompletionDto = new CreateOrModifyCsTaskCompletionDto();
        csTaskCompletionDto.setTaskId(taskId);
        csTaskCompletionDto.setOptimauthId(optimauthId);
        return cs20_018Service.insertCustomerErpInfo(optimauthId,customerId,csTaskCompletionDto.toModel());
    }

    @ResponseBody
    @RequestMapping(value = "listMarket",method = RequestMethod.POST)
    public List<CpMarketInfo> listMarket(String rowId){
        return cs20_018Service.selectListMarket(rowId);
    }

    @ResponseBody
    @RequestMapping(value = "selectCustomerSplit",method = RequestMethod.POST)
    public List<CSMarketDiscountSplit> selectCustomerSplit(String rowId){
        return cs20_006Service.selectDiscountSplit(rowId);
    }
}
