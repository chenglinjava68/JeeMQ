/**
 * 
 */
package com.stripcode.web.user;

import com.stripcode.core.util.tree.GenerateTreeDataUtil;
import com.stripcode.core.util.tree.TreeNode;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Metro
 */
@Controller
@RequestMapping("/dataType")
public class TCodeMacroDefineController extends BaseController {
	@Autowired
	private TCodeMacroDefineService tCodeMacroDefineService;

	@RequestMapping("/read/rangeTree")
	@ResponseBody
	public List<TreeNode> rangeTree(HttpServletResponse response){
		//定义接口可以被跨域访问
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin","*");
		return GenerateTreeDataUtil.recursionChildren("M0000",tCodeMacroDefineService.selectForRangeTree());
	}
}
