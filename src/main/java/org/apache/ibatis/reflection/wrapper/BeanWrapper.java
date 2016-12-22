//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.ibatis.reflection.wrapper;

import com.stripcode.core.util.UnitConvertUtils;
import org.apache.ibatis.reflection.*;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.invoker.Invoker;
import org.apache.ibatis.reflection.property.PropertyTokenizer;

import java.util.List;

public class BeanWrapper extends BaseWrapper {
    private Object object;
    private MetaClass metaClass;

    public BeanWrapper(MetaObject metaObject, Object object) {
        super(metaObject);
        this.object = object;
        this.metaClass = MetaClass.forClass(object.getClass());
    }

    public Object get(PropertyTokenizer prop) {
        if(prop.getIndex() != null) {
            Object collection = this.resolveCollection(prop, this.object);
            return this.getCollectionValue(prop, collection);
        } else {
            return this.getBeanProperty(prop, this.object);
        }
    }

    public void set(PropertyTokenizer prop, Object value) {
        if(prop.getIndex() != null) {
            Object collection = this.resolveCollection(prop, this.object);
            this.setCollectionValue(prop, collection, value);
        } else {
            this.setBeanProperty(prop, this.object, value);
        }

    }

    public String findProperty(String name, boolean useCamelCaseMapping) {
        return this.metaClass.findProperty(name, useCamelCaseMapping);
    }

    public String[] getGetterNames() {
        return this.metaClass.getGetterNames();
    }

    public String[] getSetterNames() {
        return this.metaClass.getSetterNames();
    }

    public Class<?> getSetterType(String name) {
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()) {
            MetaObject metaValue = this.metaObject.metaObjectForProperty(prop.getIndexedName());
            return metaValue == SystemMetaObject.NULL_META_OBJECT?this.metaClass.getSetterType(name):metaValue.getSetterType(prop.getChildren());
        } else {
            return this.metaClass.getSetterType(name);
        }
    }

    public Class<?> getGetterType(String name) {
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()) {
            MetaObject metaValue = this.metaObject.metaObjectForProperty(prop.getIndexedName());
            return metaValue == SystemMetaObject.NULL_META_OBJECT?this.metaClass.getGetterType(name):metaValue.getGetterType(prop.getChildren());
        } else {
            return this.metaClass.getGetterType(name);
        }
    }

    public boolean hasSetter(String name) {
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()) {
            if(this.metaClass.hasSetter(prop.getIndexedName())) {
                MetaObject metaValue = this.metaObject.metaObjectForProperty(prop.getIndexedName());
                return metaValue == SystemMetaObject.NULL_META_OBJECT?this.metaClass.hasSetter(name):metaValue.hasSetter(prop.getChildren());
            } else {
                return false;
            }
        } else {
            return this.metaClass.hasSetter(name);
        }
    }

    public boolean hasGetter(String name) {
        PropertyTokenizer prop = new PropertyTokenizer(name);
        if(prop.hasNext()) {
            if(this.metaClass.hasGetter(prop.getIndexedName())) {
                MetaObject metaValue = this.metaObject.metaObjectForProperty(prop.getIndexedName());
                return metaValue == SystemMetaObject.NULL_META_OBJECT?this.metaClass.hasGetter(name):metaValue.hasGetter(prop.getChildren());
            } else {
                return false;
            }
        } else {
            return this.metaClass.hasGetter(name);
        }
    }

    public MetaObject instantiatePropertyValue(String name, PropertyTokenizer prop, ObjectFactory objectFactory) {
        Class type = this.getSetterType(prop.getName());

        try {
            Object e = objectFactory.create(type);
            MetaObject metaValue = MetaObject.forObject(e, this.metaObject.getObjectFactory(), this.metaObject.getObjectWrapperFactory());
            this.set(prop, e);
            return metaValue;
        } catch (Exception var7) {
            throw new ReflectionException("Cannot set value of property \'" + name + "\' because \'" + name + "\' is null and cannot be instantiated on instance of " + type.getName() + ". Cause:" + var7.toString(), var7);
        }
    }

    private Object getBeanProperty(PropertyTokenizer prop, Object object) {
        try {
            Invoker t = this.metaClass.getGetInvoker(prop.getName());
            try {
                Object value = t.invoke(object, NO_ARGUMENTS);
                // return  t.invoke(object, NO_ARGUMENTS);
                return UnitConvertUtils.multiply(t,value);
            } catch (Throwable var5) {
                throw ExceptionUtil.unwrapThrowable(var5);
            }
        } catch (RuntimeException var6) {
            throw var6;
        } catch (Throwable var7) {
            throw new ReflectionException("Could not get property \'" + prop.getName() + "\' from " + object.getClass() + ".  Cause: " + var7.toString(), var7);
        }
    }

    private void setBeanProperty(PropertyTokenizer prop, Object object, Object value) {
        try {
            Invoker t = this.metaClass.getSetInvoker(prop.getName());
            value = UnitConvertUtils.divide(t,value);
            Object[] params = new Object[]{value};
            try {
                t.invoke(object, params);
            } catch (Throwable var7) {
                throw ExceptionUtil.unwrapThrowable(var7);
            }
        } catch (Throwable var8) {
            throw new ReflectionException("Could not set property \'" + prop.getName() + "\' of \'" + object.getClass() + "\' with value \'" + value + "\' Cause: " + var8.toString(), var8);
        }
    }

    public boolean isCollection() {
        return false;
    }

    public void add(Object element) {
        throw new UnsupportedOperationException();
    }

    public <E> void addAll(List<E> list) {
        throw new UnsupportedOperationException();
    }
}
