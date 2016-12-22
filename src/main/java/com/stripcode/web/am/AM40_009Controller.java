package com.stripcode.web.am;

import com.stripcode.mybatis.am.model.AMContractAttachMent;
import com.stripcode.service.am.AM40_009Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Metro on 2016/12/19.
 */
@Controller
@RequestMapping(value = "AM40_009")
public class AM40_009Controller {
    @Autowired
    private AM40_009Service am40_009Service;

    /**
     * 查询店铺租期详细信息集合
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMContractAttachMent",method = RequestMethod.POST)
    public List<AMContractAttachMent> selectAMContractAttachMent(String storeId){
        return am40_009Service.selectAMContractAttachMent(storeId);
    }
}
