package com.stripcode.web.sf;

import com.stripcode.core.dto.cs.CreateOrModifyCsTaskCompletionDto;
import com.stripcode.core.dto.sf.CreateLicenceAttachmentListDto;
import com.stripcode.mybatis.sf.model.SFLicenceAttachment;
import com.stripcode.service.sf.SF30_072Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Metro on 2016/10/24.
 */
@Controller
@RequestMapping("SF30_072")
public class SF30_072Controller {
    @Autowired
    private SF30_072Service sf30_072Service;

    @ResponseBody
    @RequestMapping(value = "queryAll",method = RequestMethod.POST)
    public List<SFLicenceAttachment> queryAll(String ppId){
        return sf30_072Service.queryAll(ppId);
    }

    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ModelMap update(CreateLicenceAttachmentListDto dto, CreateOrModifyCsTaskCompletionDto dto1){
        return sf30_072Service.update(dto.getList(),dto1.toModel());
    }
}
