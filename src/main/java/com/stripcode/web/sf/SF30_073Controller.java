package com.stripcode.web.sf;

import com.stripcode.core.dto.sf.CreateStorePhotoDto;
import com.stripcode.core.util.WebUtil;
import com.stripcode.mybatis.cs.model.TCsTaskCompletion;
import com.stripcode.mybatis.sf.model.SFStorePhotoAttachment;
import com.stripcode.service.sf.SF30_073Service;
import com.stripcode.service.user.TCodeMacroDefineService;
import com.stripcode.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Metro on 2016/10/20.
 */
@Controller
@RequestMapping("/SF30_073")
public class SF30_073Controller extends BaseController{
    @Autowired
    private SF30_073Service sf30_073Service;
    @Autowired
    private TCodeMacroDefineService tCodeMacroDefineService;

    /**
     * 店铺照片列表
      * @param ppId  客户意向店ppId
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/read/selectStorePhotoAll",method = RequestMethod.POST)
    public Map<String,Object> details(String ppId){
        Map<String,Object> map = new HashMap<String, Object>();
        List<SFStorePhotoAttachment> StorePhotoList = sf30_073Service.selectPhotoAttachement(ppId);
        map.put("main",StorePhotoList);
        return map;
    }
    /**
     * 保存修改信息
      * @param Dto 集合对象
     * @param request 接收前台的参数
     * @return Map
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Map update(String ppId,TCsTaskCompletion csTaskCompletion,CreateStorePhotoDto Dto,HttpServletRequest request)throws Exception{
        Map<String,Object> map = WebUtil.getParameterMap(request);
        return setSuccessModelMap(sf30_073Service.update(Dto.getStorePhotoList(),csTaskCompletion, ppId));
    }
}
