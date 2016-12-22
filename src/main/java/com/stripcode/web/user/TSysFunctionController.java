package com.stripcode.web.user;

import com.github.pagehelper.PageInfo;
import com.stripcode.core.util.tree.GenerateTreeDataUtil;
import com.stripcode.core.util.tree.TreeModel;
import com.stripcode.core.util.tree.TreeNode;
import com.stripcode.mybatis.common.JQGridObject;
import com.stripcode.service.user.TSysFunctionService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/function")
public class TSysFunctionController extends BaseController {
    @Autowired
    private TSysFunctionService tSysFunctionService;
    @RequestMapping("/read/tree")
    @ResponseBody
    public JQGridObject tree(HttpServletResponse response){
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        List<TreeModel> treeModels = tSysFunctionService.selectForTree();
        PageInfo<TreeModel> pageInfo = new PageInfo<TreeModel>();
        pageInfo.setList(treeModels);
        pageInfo.setPages(treeModels.size());
        return new JQGridObject(pageInfo);
    }
    @RequestMapping("/read/menu")
    @ResponseBody
    public List<TreeNode> menu(HttpServletResponse response){
        String userId = getCurrUser();
        //定义接口可以被跨域访问
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin","*");
        List<TreeModel> treeModels = tSysFunctionService.selectForMenu(userId);
        return GenerateTreeDataUtil.recursionChildren("ROOT",treeModels);
    }
}
