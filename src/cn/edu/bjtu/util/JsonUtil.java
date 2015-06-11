package cn.edu.bjtu.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;

/**
 * Json工具类
 * @author RussWest0
 * @date   2015年6月11日 下午11:18:16
 */
public class JsonUtil {
	
	public static String list2Json(List<?> list) {     
        StringBuilder json = new StringBuilder();     
        json.append("[");     
       if (list != null && list.size() > 0) {     
           for (Object obj : list) {     
                json.append(object2Json(obj));     
                json.append(",");     
            }     
            json.setCharAt(json.length() - 1, ']');     
        } else {     
            json.append("]");     
        }     
       return json.toString();     
    }
	
	 public static String object2Json(Object object) {     
         StringBuilder json = new StringBuilder();     
        if (object == null) {     
             json.append("\"\"");     
         } else if (object instanceof String || object instanceof Integer) {   
             json.append("\"").append(object.toString()).append("\"");    
         } else {     
             json.append(beanToJson(object));     
         }     
        return json.toString();     
     }  
	 
	 public static String beanToJson(Object bean) {     
         StringBuilder json = new StringBuilder();     
         json.append("{");     
         PropertyDescriptor[] props = null;     
        try {     
             props = Introspector.getBeanInfo(bean.getClass(), Object.class)     
                     .getPropertyDescriptors();     
         } catch (IntrospectionException e) {     
         }     
        if (props != null) {     
            for (int i = 0; i < props.length; i++) {     
                try {    
                     String name = object2Json(props[i].getName());     
                     String value = object2Json(props[i].getReadMethod().invoke(bean));    
                     json.append(name);     
                     json.append(":");     
                     json.append(value);     
                     json.append(",");    
                 } catch (Exception e) {     
                 }     
             }     
             json.setCharAt(json.length() - 1, '}');     
         } else {     
             json.append("}");     
         }     
        return json.toString();     
     }  

}
