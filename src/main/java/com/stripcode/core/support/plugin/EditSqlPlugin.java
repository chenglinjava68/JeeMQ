package com.stripcode.core.support.plugin;

import com.github.pagehelper.*;
import com.stripcode.core.util.ReflectUtil;
import com.stripcode.core.util.SqlPermissionUtil;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.plugin.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Metro on 2016/10/27.
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class,
        Integer.class}) })
public class EditSqlPlugin implements Interceptor {

    /** 配置 */
    protected Properties properties;
    /* 日志 */
    private static final Logger log = LoggerFactory.getLogger(EditSqlPlugin.class);
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Page page = SqlUtil.getLocalPage();
        Object result = null;
        //是通过Interceptor的plugin方法进行包裹的，所以我们这里拦截到的目标对象肯定是RoutingStatementHandler对象。
        RoutingStatementHandler handler = (RoutingStatementHandler) invocation.getTarget();
        //通过反射获取到当前RoutingStatementHandler对象的delegate属性
        StatementHandler delegate = (StatementHandler)ReflectUtil.getFieldValue(handler, "delegate");
        BoundSql boundSql = delegate.getBoundSql();
        String nativeSql = boundSql.getSql();
        if(page!=null||!"select".equalsIgnoreCase(nativeSql.substring(0,5)))
        {
            return invocation.proceed();
        }
        String permissionSql = new SqlPermissionUtil().getPermissionSql(nativeSql);
        //利用反射设置当前BoundSql对应的sql属性建立好的分页Sql语句
        ReflectUtil.setFieldValue(boundSql, "sql", permissionSql);
        result = invocation.proceed();
        return result;
    }

    /**
     * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
     *
     * @param text
     *            要判断的文本
     * @return 如果匹配返回TRUE,否则返回FALSE
     */
    private boolean isBracketCanPartnership(String text) {
        if (text == null || getIndexOfCount(text, '(') != getIndexOfCount(text, ')')) {
            return false;
        }
        return true;
    }

    /**
     * 得到一个字符在另一个字符串中出现的次数
     *
     * @param text
     *            文本
     * @param ch
     *            字符
     */
    private int getIndexOfCount(String text, char ch) {
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            count = text.charAt(i) == ch ? count + 1 : count;
        }

        return count;
    }

    /**
     * 在结果列中查找是否存在目标列
     *
     * @param @param column
     * @param @param columnSql
     * @param @return 设定文件
     * @return String 返回类型
     * @throws
     */
    private boolean getColumn(String column, String columnSql) {
        return columnSql.toLowerCase().indexOf(column.toLowerCase()) > -1;
    }

    /**
     * <p>从代理对象中获取真实对象。</p>
     *
     * 插件中获得的对象可能是代理，应用此方法将代理层层剥去，获得原始对象
     *
     * @param target 代理对象
     * @return 原始对象
     */
    @SuppressWarnings("unchecked")
    protected <T> T unProxy(T target)
    {
        if (log.isDebugEnabled())
        {
            log.debug("unProxy:target={}:{}", target.getClass().getName(), target);
        }

        T unProxyObj = target;
        while (Proxy.isProxyClass(unProxyObj.getClass()))
        {
            Plugin plugin = (Plugin) Proxy.getInvocationHandler(target);
            MetaObject<Plugin> meta = MetaObject.fromObject(plugin);
            unProxyObj = (T)meta.getValue("target");

            if (log.isDebugEnabled())
            {
                log.debug("unProxy:unProxyObj={}:{}", unProxyObj.getClass().getName(), target);
            }
        }

        return unProxyObj;
    }

    /**
     * <p>从委托对象中获取真实对象。</p>
     *
     * 插件中获得的对象可能是委托，应用此方法获得原始对象。
     * 如果传入的对象中不存在delegate属性
     *
     * @param target 委托对象
     * @return 原始对象
     */
    @SuppressWarnings("unchecked")
    protected <T> T unDelegate(T target)
    {
        if (log.isDebugEnabled())
        {
            log.debug("unDelegate:target={}:{}", target.getClass().getName(), target);
        }

        T unDelegateObj = target;
        MetaObject<T> meta = MetaObject.fromObject(target);
        if (meta.hasFiled("delegate"))
        {
            unDelegateObj = (T)meta.getValue("delegate");
        }

        return unDelegateObj;
    }


    /*
	 * 先处理排序问题 获取当前结果集属性-列名映射 用作排序时作转换用
	 */
    private Map<String, String> getColumnMap(MappedStatement mappedStatement) {

        Map<String, String> columnMap = new HashMap<String, String>();
        List<ResultMap> resultMaps = mappedStatement.getResultMaps();
        for (ResultMap resultMap : resultMaps) {
            List<ResultMapping> resultMappings = resultMap.getResultMappings();
            for (ResultMapping resultMapping : resultMappings) {
                String property = resultMapping.getProperty();
                String column = resultMapping.getColumn();
                columnMap.put(property, column);
            }
        }
        return columnMap;
    }

    @Override
    public final Object plugin(Object target)
    {
        if (log.isDebugEnabled())
        {
            log.debug("plugin:{}->{}", this, target);
        }

        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties p) {
        this.properties = properties;
    }
}
