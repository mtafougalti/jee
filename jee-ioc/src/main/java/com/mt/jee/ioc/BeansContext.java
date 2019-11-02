package com.mt.jee.ioc;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class BeansContext {
	
	private Map<String, Object> beansMap;
	
	public void init() {
		beansMap = new HashMap<>();
		Properties prop = Configuration.loadProperties();
        try { 
	        for (Entry<Object,Object> entry : prop.entrySet()) {
	        	System.out.println(entry.getKey().toString()+"="+entry.getValue().toString());
	        	Class<? extends Object> beanClass = Class.forName(entry.getValue().toString());
	        	beansMap.put(entry.getKey().toString(), beanClass.newInstance());
			}
        
	        for (Entry<Object,Object> entry : prop.entrySet()) {
	        	Class<? extends Object> beanClass = Class.forName(entry.getValue().toString());
	        	Object beanObject = beansMap.get(entry.getKey().toString());
	        	injectDependencies(beanObject, beanClass);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String beanName) {
		return beansMap.get(beanName);
	}
	
	private void injectDependencies(Object beanObject, Class<? extends Object> beanClass) throws Exception {
		Field[] allFields = beanClass.getDeclaredFields();
		for (Field field : allFields) {
		    if (Modifier.isPrivate(field.getModifiers())) {
		        Object beanToInject = beansMap.get(field.getName());
		        String methodName = "set"+ capitalize(field.getName());
		        Method setMethod = beanClass.getMethod(methodName, new Class[] {field.getType()});
		        setMethod.invoke(beanObject, new Object[] {beanToInject});
		    }
		}
	}
	
	private static String capitalize(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

}
