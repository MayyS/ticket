package gpnu.sw.gra.ticket.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import gpnu.sw.gra.ticket.pojo.Passenger;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public static List<Passenger>jsonToList(String jsonData){
//        JSONObject obj=JSON.parseObject(jsonData);
        JSONArray arr = JSONObject.parseArray(jsonData);
        List<Passenger>passengers=new ArrayList<>();
        Passenger passenger;
        HashMap<String,String>item;
        for (int i=0; i<arr.size(); i++){
            System.out.println("-----------------------------");
            JSONObject obj=(JSONObject) arr.get(i);
            passenger=wrapperToP(obj.getInnerMap());
            passengers.add(passenger);
            System.out.println("-----------------------------");
        }
        Collections.sort(passengers);
        return passengers;
    }

    private static Passenger wrapperToP(Map<String,Object>res){
        Passenger passenger=new Passenger();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=null;
        /*
        *
        * */
        passenger.setPassengerName(res.get("passenger_name").toString());
        passenger.setAdult(res.get("isAdult").equals("Y"));
        passenger.setAllEncStr(res.get("allEncStr").toString());
        try {

            date=sdf.parse(res.get("born_date").toString());
            System.out.println(date.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        passenger.setBornDate(date);
        passenger.setBoy(res.get("sex_code").equals("F"));
        passenger.setCountryCode(res.get("country_code").toString());
        passenger.setEmail(res.get("email").toString());
        passenger.setIndexId(Integer.valueOf(res.get("index_id").toString()));
        passenger.setMobileNo(res.get("mobile_no").toString());
        passenger.setOldThan60(res.get("isOldThan60").toString().equals("N"));
        passenger.setYongThan10(res.get("isYongThan10").toString().equals("N"));
        passenger.setYongThan14(res.get("isYongThan14").toString().equals("N"));
        passenger.setPassengerUuid(res.get("passenger_uuid").toString().toString());
        passenger.setPassengerIdNo(res.get("passenger_id_no").toString());
        passenger.setPassengerIdTypeName(res.get("passenger_id_type_name").toString());
        return passenger;
    }


}
