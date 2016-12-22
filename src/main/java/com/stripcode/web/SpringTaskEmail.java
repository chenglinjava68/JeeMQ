
package com.stripcode.web;

import com.stripcode.core.util.RedisNewUtil;
import com.stripcode.core.util.RedisUtil;
import com.stripcode.core.util.emailUtil.MailUtil;
import com.stripcode.mybatis.cs.model.TSysCommonattached;
import com.stripcode.mybatis.email.model.TSysMailSendInfo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;

/** 
 * Spring3 @Scheduled email
 * @author Metro 2016-10-14
 * @describe:定时器定时检查缓存有无邮件可发送
 */
@Component
public class SpringTaskEmail {
    private static final Logger LOGGER = Logger.getLogger(SpringTaskEmail.class);

    // @Scheduled(cron = "0/5 * * * * *") //可配
    void doSomethingWith(){
        Set s = RedisNewUtil.keys("portal:email:*");
        if (null != s && s.size() > 0){
            Iterator it = s.iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                Map value = RedisUtil.hgetAll(key);
                TSysMailSendInfo msg = (TSysMailSendInfo)value.get("msg");
                ArrayList<TSysCommonattached> attached = (ArrayList<TSysCommonattached>)value.get("attached");
                try {
                    if (MailUtil.SendFileEmail(msg,attached)) {
                        RedisUtil.del(key);
                        //发送成功则入库，次业务由项目组写
                        LOGGER.info("未发送邮件再次发送成功");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(key + value);
            }
        }
        LOGGER.info("缓存无邮件可发送");
        System.out.println("缓存无邮件可发送");
    }
} 