package com.stripcode.web.email;

import com.stripcode.core.Constants;
import com.stripcode.core.config.Resources;
import com.stripcode.core.util.RedisNewUtil;
import com.stripcode.core.util.emailUtil.MailUtil;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.email.model.TSysMailSendInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Metro on 2016/10/13.
 */
@Controller
public class EmailController {
    private Logger logger = LoggerFactory.getLogger(EmailController.class);
    /**
     * 发送邮件
     * @param msg  邮件发送实体
     * @param attached  附件实体
     * @param uuid  发送时间戳
     * @describe:发送邮件成功则入库，失败入缓存，定时器定时吃缓存
     */
    @ResponseBody
    @RequestMapping(value = "/sendemail", method= RequestMethod.POST)
    public Map send(TSysMailSendInfo msg, ArrayList<TSysCommonattached> attached,String uuid,HttpServletResponse response, Model model) throws Exception {
        HashMap resultmap = new HashMap();
        String result = "";
        boolean isSuccess = MailUtil.SendFileEmail(msg,attached);
        if (isSuccess) {
            // 此入库业务由项目组实现
            resultmap.put("code",200);//前端提示“邮件发送成功”，返回码由项目组自己定义
            return resultmap;
        } else {
            //邮件发送失败，先存缓存,由定时器去吃缓存定时发送
            HashMap map = new HashMap();
            map.put("msg",msg);
            if(attached != null && attached.size() > 0 ){
                map.put("attached",attached);
            }
            try{
                Assert.notNull(uuid, Resources.getMessage("uuid_IS_NULL"));
                String key = getCacheKey(uuid);
                RedisNewUtil.set(key,map);
                logger.info("邮件发送失败，存入缓存待发送");
            }catch (Exception e){
                throw  new RuntimeException(e.getMessage(),e);
            }
            resultmap.put("code",222);//前端提示邮件已入发送队列，或者发送中，返回编由项目组定义，所有的编码放入可配
            return null;
        }
    }
    /** 获取缓存键值 */
    private String getCacheKey(Object id) {
        return new StringBuilder(Constants.CACHE_NAMESPACE).append("email").append(":").append(id).toString();
    }
}
