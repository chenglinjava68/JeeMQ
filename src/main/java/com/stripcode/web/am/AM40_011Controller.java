package com.stripcode.web.am;

import com.stripcode.mybatis.am.model.AMPolicySupport;
import com.stripcode.service.am.AM40_011Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Metro on 2016/12/16.
 */
@Controller
@RequestMapping(value = "AM40_011")
public class AM40_011Controller {
    @Autowired
    private AM40_011Service am40_011Service;

    /**
     * 查询店铺政策支持集合
     * @param storeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/selectAMPolicySupport",method = RequestMethod.POST)
    public List<AMPolicySupport> selectAMPolicySupport(String storeId){
        return am40_011Service.selectAMPolicySupport(storeId);
    }
}
