package com.stripcode.web.cs;

import com.stripcode.mybatis.cs.model.CSAterMarketauz;
import com.stripcode.mybatis.cs.model.CSCustomerErpInfo;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.service.cs.CS20_006Service;
import com.stripcode.service.cs.CS20_007Service;
import com.stripcode.service.cs.CS20_008Service;
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
 * Created by Metro on 2016/12/15.
 */
@Controller
@RequestMapping(value = "CS20_008")
public class CS20_008Controller extends BaseController {
    @Autowired
    private CS20_007Service cs20_007Service;
    @Autowired
    private SF30_002Service sf30_002Service;
    @Autowired
    private CS20_008Service cs20_008Service;
    @Autowired
    private RscSysUserService rscSysUserService;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;
    @Autowired
    private CS20_006Service cS20_006Service;
    @ResponseBody
    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
    public Map<String,Object> queryByReNewInfo(String rowId,String customerId,String erpCode,String optimauthId,HttpServletResponse response){
        Map<String,Object> map = new HashMap<String,Object>();
        CSCustomerErpInfo csCustomerErpInfo = cs20_007Service.queryByReNewInfo(customerId, erpCode);
        CSAterMarketauz csAterMarketauz = cs20_008Service.selectMarketauz(optimauthId,rowId,erpCode);
        if(csAterMarketauz==null){
            CSAterMarketauz csAterMarketauz1 = new  CSAterMarketauz ();
            csAterMarketauz1.setCsCustomerErpInfo(csCustomerErpInfo);
            map.put("main",csAterMarketauz1);
        }else {
            csAterMarketauz.setCsCustomerErpInfo(csCustomerErpInfo);
            map.put("main",csAterMarketauz);
        }
        map.put("CustomerList",cS20_006Service.selectCustomerName());
        map.put("erpList",cs20_008Service.selectErpList(optimauthId));
        map.put("userList",sf30_002Service.selectAllUser());//查询负责人
        map.put("codeList", tCodeMacroDefineService.selectForMarketAOadd());
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map updateByReNewInfo(CSAterMarketauz csAterMarketauz,TCsTaskCompletion tCsTaskCompletion,HttpServletResponse response){
        return setSuccessModelMap(cs20_008Service.update(csAterMarketauz, tCsTaskCompletion));
    }

}
