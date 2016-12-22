package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.RenewMarketauz;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.service.cs.CS20_007Service;
import com.stripcode.service.sf.SF30_002Service;
import com.stripcode.service.user.RscSysUserService;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/8/22.
 */
@Controller
@RequestMapping(value = "CS20_007")
public class CS20_007Controller extends BaseController {
    @Autowired
    private CS20_007Service cs20_007Service;
    @Autowired
    private SF30_002Service sf30_002Service;
    @Autowired
    private RscSysUserService rscSysUserService;

    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @ResponseBody
    @RequestMapping(value = "/queryByReNewInfo",method = RequestMethod.POST)
    public Map<String,Object> queryByReNewInfo(String customerId,String erpCode,String optimauthId,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        CSCustomerErpInfo csCustomerErpInfo = cs20_007Service.queryByReNewInfo(customerId,erpCode);
        RenewMarketauz renewMarketauz = cs20_007Service.selectRenewMarketauzById(optimauthId);
        if(renewMarketauz==null){
            RenewMarketauz renewMarketauz1 = new  RenewMarketauz ();
            renewMarketauz1.setCsCustomerErpInfo(csCustomerErpInfo);
            map.put("main",renewMarketauz1);
        }else {
            renewMarketauz.setCsCustomerErpInfo(csCustomerErpInfo);
            map.put("main",renewMarketauz);
        }
        csCustomerErpInfo.setUserId(getCurrUser());
        map.put("userList",sf30_002Service.selectAllUser());//查询负责人
        map.put("ctList",tCodeMacroDefineService.selectForFlan());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/updateByReNewInfo",method = RequestMethod.POST)
    public Map updateByReNewInfo(RenewMarketauz renewMarketauz,TCsTaskCompletion tCsTaskCompletion,HttpServletResponse response){
        return setSuccessModelMap(cs20_007Service.updateByReNewInfo(renewMarketauz,tCsTaskCompletion));
    }

}
