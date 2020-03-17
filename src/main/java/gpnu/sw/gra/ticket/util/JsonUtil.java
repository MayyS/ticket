package gpnu.sw.gra.ticket.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class JsonUtil {

    private static final ObjectMapper MRP=new ObjectMapper();

    public static String objectToJson(Object data){
        String str=null;
        try {
            str=MRP.writeValueAsString(data);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }finally {
            return str;
        }
    }

    public static <T> T jsonToPojo(String jsonData,Class<T>beanType){
        try {
            T t=MRP.readValue(jsonData,beanType);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T>List<T> jsonToList(String jsonData,Class<T>beanType){
        JavaType javaType=MRP.getTypeFactory().constructParametricType(List.class,beanType);
        try {
            List<T>list=MRP.readValue(jsonData,javaType);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  null;
    }


    public static Map<String,Object>jsonToMap(String jsonData){
        JSONObject obj=JSON.parseObject(jsonData);
        Map<String, Object>map=obj.getInnerMap();

        return map;
    }

}
