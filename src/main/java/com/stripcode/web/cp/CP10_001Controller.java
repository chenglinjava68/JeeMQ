/**
 * 
 */
package com.stripcode.web.cp;

import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.mybatis.cp.dao.CpMarketInfoMapper;
import com.stripcode.service.cp.CP10_001Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/CP10_001")
public class CP10_001Controller extends BaseController {
	@Autowired
	private CP10_001Service cp10_001Service;
	@Autowired
	private CpMarketInfoMapper cpMarketInfoMapper;
	@Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

	// 查询用户
	@ResponseBody
	@RequestMapping(value = "/read/list",method = RequestMethod.POST)
	public JQGridObject list(HttpServletRequest request,HttpServletResponse response) {
		Map<String, Object> params = WebUtil.getParameterMap(request);
		return new JQGridObject(cp10_001Service.queryForPage(params));
	}
	//加载简单搜索的下拉框
	@ResponseBody
	@RequestMapping(value = "/read/loadSelect",method = RequestMethod.POST)
	public Map<String,Object> loadSelect(String marketId, HttpServletResponse response) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("codeList",cp10_001Service.selectCpMarket(marketId));
		map.put("selectList", tCodeMacroDefineService.selectForMarket());
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/queryCustomerByMarketForPage",method = RequestMethod.POST)
	public JQGridObject queryCustomerByMarketForPage(HttpServletRequest request){
		Map<String,Object> parmas = WebUtil.getParameterMap(request);
		return new JQGridObject(cp10_001Service.queryCustomerByMarketForPage(parmas));
	}

	@ResponseBody
	@RequestMapping(value = "/exportMarket")
	public String exportMarket(@RequestParam Map<String,Object> params, HttpServletRequest request, HttpServletResponse response){
		cp10_001Service.exportMarket(params,request,response);
		return null;
	}
	/*Excel导出*/
	@RequestMapping(value = "/exportMarketExcel")
	public String exportFile(Map<String,Object> params, HttpServletRequest request, HttpServletResponse response) {
		cp10_001Service.exportMarket(params, request, response);
		return null;
	}
}
