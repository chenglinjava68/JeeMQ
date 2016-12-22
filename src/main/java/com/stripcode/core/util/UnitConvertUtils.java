package com.stripcode.core.util;

import com.stripcode.core.annotation.Divide;
import com.stripcode.core.annotation.Multiply;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.invoker.MethodInvoker;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

/**
 * Created by Metro on 2016/12/9.
 */
public class UnitConvertUtils {
    //乘法运算转换
    protected static final Object[] NO_ARGUMENTS = new Object[0];
    public static Object multiply(Invoker t,Object value) throws Exception {
        if(t instanceof  MethodInvoker) {
        MethodInvoker methodInvoker =  (MethodInvoker)t;
        Method method = methodInvoker.getMethod();
        Multiply  multiply= method.getAnnotation(Multiply.class);
        if(multiply !=null && value != null){
            if(value instanceof  Double){
                Double temp =Double.valueOf(value.toString());
                DecimalFormat df   = new DecimalFormat("######0.00");
                temp = Double.valueOf(df.format(temp));
                return temp*multiply.value();
            }
            if(value instanceof  Integer){
                return Integer.valueOf(value.toString())*multiply.value();
            }
            return value;
        }
        }
        return value;
    }
    //除法运算转换
    public static Object divide(Invoker t,Object value) throws NoSuchMethodException {
        if(t instanceof  MethodInvoker) {
        MethodInvoker methodInvoker =  (MethodInvoker)t;
        Method method = methodInvoker.getMethod();
        Divide divide = method.getAnnotation(Divide.class);
        if(divide !=null && value != null){
            if(value instanceof  Double){
                Double temp =Double.valueOf(value.toString());
                DecimalFormat df   = new DecimalFormat("######0.00");
                temp = Double.valueOf(df.format(temp));
                value = temp/divide.value();
            }
            if(value instanceof  Integer){
                value = Integer.valueOf(value.toString())/divide.value();
            }
        }
        }
        return value;
    }
}
