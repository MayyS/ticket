package gpnu.sw.gra.ticket.util;

import java.security.MessageDigest;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class MD5Util {

    public static String MD5(String enscrp){
        MessageDigest md5=null;
        try {
            md5=MessageDigest.getInstance("MD5");
        }catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[]chars=enscrp.toCharArray();
        byte[]bytes=new byte[chars.length];
        for (int i=0; i<chars.length; i++){
            bytes[i]=(byte)chars[i];
        }
        byte[]md5Bytes=md5.digest(bytes);
        StringBuffer hexValue=new StringBuffer();
        for (int i=0; i<md5Bytes.length; i++){
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

}
