/**
 *
 */
package com.stripcode.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.stripcode.core.config.Resources;
import com.stripcode.core.util.DataUtil;
import com.stripcode.core.util.PageSortUtil;
import com.stripcode.core.util.UUIDUtils;
import com.stripcode.core.util.excelUtil.ExportExcel;
import com.stripcode.mybatis.user.dao.RscSysUserMapper;
import com.stripcode.mybatis.user.model.RscSysUser;
import com.stripcode.service.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Metro
 */
@Service
@CacheConfig(cacheNames = "rscSysUser")
public class RscSysUserService extends BaseService {
    @Autowired
    private RscSysUserMapper rscSysUserMapper;

    public Map update(RscSysUser record) throws Exception {
        Map modelMap = new HashMap();
        if (isExists(record)) {
            modelMap.put("result", false);
            modelMap.put("message", "登录名已存在！");
            return modelMap;
        }
        int count = -1;
        if (StringUtils.isBlank(record.getUserId())) {
            record.setUserId(UUIDUtils.generateKey());
            count = rscSysUserMapper.insert(record);
            if (count == 1) {
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("loginName", record.getLoginName());
                List<RscSysUser> rscSysUsers = rscSysUserMapper.query(params);
                modelMap.put("result", true);
                modelMap.put("message", "保存成功！");
                modelMap.put("id", record.getUserId());
                return modelMap;
            }
            modelMap.put("result", false);
            modelMap.put("message", "保存失败！");
            return modelMap;
        }
        count = rscSysUserMapper.updateByPrimaryKey(record);
        if (count == 1) {
            modelMap.put("result", true);
            modelMap.put("message", "修改成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "修改失败！");
        return modelMap;
    }

    public boolean isExists(RscSysUser record) {
        int isExists = rscSysUserMapper.selectForExists(record);
        if (isExists > 0) {
            return true;
        }
        return false;
    }

    public boolean isExistsByLoginName(RscSysUser record) {
        int isExists = rscSysUserMapper.selectForExists(record);
        if (isExists > 0) {
            return false;
        }
        return true;
    }

    public RscSysUser getUserByid(String id) {
        RscSysUser u = rscSysUserMapper.getUserByid(id);
        return u;
    }

    @Transactional
    public Map delete(String id) {
        Map modelMap = new HashMap();
        int count = rscSysUserMapper.deleteByPrimaryKey(id);
        if (count == 1) {
            modelMap.put("result", true);
            modelMap.put("message", "删除成功！");
            return modelMap;
        }
        modelMap.put("result", false);
        modelMap.put("message", "删除失败！");
        return modelMap;
    }

    public RscSysUser queryById(String id) {
        return rscSysUserMapper.selectByPrimaryKey(id);
    }

    public List<RscSysUser> query(Map<String, Object> params) {
        return rscSysUserMapper.query(params);
    }

    public PageInfo<RscSysUser> queryForPage(Map<String, Object> params) {
        PageSortUtil.unoinSortBySord(params);
        PageHelper.startPage(params);
        return new PageInfo<RscSysUser>(rscSysUserMapper.queryForPage(params));
    }

    public List<RscSysUser> queryByConditions(Map<String, Object> params) {
        return rscSysUserMapper.queryByConditions(params);
    }
    public List<RscSysUser> query() {
        return rscSysUserMapper.selectAll();
    }

    /**
     * 用户登录
     */
    public Boolean login(String account, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return subject.isAuthenticated();
        } catch (LockedAccountException e) {
            throw new IllegalArgumentException(Resources.getMessage("ACCOUNT_LOCKED", token.getPrincipal()));
        } catch (DisabledAccountException e) {
            throw new IllegalArgumentException(Resources.getMessage("ACCOUNT_DISABLED", token.getPrincipal()));
        } catch (ExpiredCredentialsException e) {
            throw new IllegalArgumentException(Resources.getMessage("ACCOUNT_EXPIRED", token.getPrincipal()));
        } catch (Exception e) {
            throw new IllegalArgumentException(Resources.getMessage("LOGIN_FAIL"), e);
        }
    }

    public void exportUser(Map<String,Object> params,HttpServletRequest request, HttpServletResponse response) {

            /*List<ExcelHeader<RscSysUser>> headers = new ArrayList<ExcelHeader<RscSysUser>>();
            headers.add(new ExcelHeader<RscSysUser>("登录名", "loginName"));
            headers.add(new ExcelHeader<RscSysUser>("用户名", "userName"));
            headers.add(new ExcelHeader<RscSysUser>("岗位", "department"));
            headers.add(new ExcelHeader<RscSysUser>("角色", "title"));
            headers.add(new ExcelHeader<RscSysUser>("电子邮件", "mail"));
            headers.add(new ExcelHeader<RscSysUser>("手机号码", "mobile"));
            headers.add(new ExcelHeader<RscSysUser>("电话号码", "phone"));
            headers.add(new ExcelHeader<RscSysUser>("性别", "sex"));
            RscSysUser creator  = queryById(WebUtil.getCurrentUser());
            List<RscSysUser> data = rscSysUserMapper.selectForExport();
            new ExcelExporter(request,response).export(new ExcelDocument<RscSysUser>(5000,"全部用户信息",creator == null ? "" : creator.getUserName(),headers,data));*/
        try {
            Page<RscSysUser> page = rscSysUserMapper.queryForPage(params);
            List<RscSysUser> data = page.getResult();
            String fileName = "用户管理"+ DataUtil.getDate("yyyyMMddHHmmss")+".xlsx";
            new ExportExcel("用户管理", RscSysUser.class).setDataList(data).write(response, fileName).dispose();
        } catch (Exception e) {

        }
    }

    public RscSysUser loadUser(String userId){
        return rscSysUserMapper.loadUser(userId);
    }
}
