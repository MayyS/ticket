package gpnu.sw.gra.ticket.util;

import org.omg.CosNaming.IstringHelper;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.SecureRandom;

/**
 * @Auther:S
 * @Date:20/3/17
 */
public class SymmetricEncoder {

    private static final String encodeRules="abcd1234";
    private static final String TYPE="AES";
    public static final String SIGN_ALGORITHMS = "SHA1PRNG";
    private static final String ENCODEING="utf-8";
    private static SecretKey key;
    private static Cipher cipher;

    static {
        try {

            //构造密钥，指定为AES算法，不区分大小写
            KeyGenerator keyGenerator=KeyGenerator.getInstance(TYPE);

            //根据规则初始化密钥生成器，根据传入的数组生成一个128的随机数
            //notice 固定randmon，否则每次重启都会生成一个新的key，就的密码就解不出来了
            SecureRandom random = SecureRandom.getInstance(SIGN_ALGORITHMS);
            random.setSeed(encodeRules.getBytes(ENCODEING));
            keyGenerator.init(128,random);

            //长生密钥
            SecretKey orginal_key=keyGenerator.generateKey();

            //获得原始对称密钥的字节数组
            byte[]raw=orginal_key.getEncoded();

            //根据字节数字产生AES密钥
            key=new SecretKeySpec(raw,"AES");

            //根据指定算法AES自成密码器
            cipher=Cipher.getInstance("AES");

        }catch (Exception e){

        }

    }


    /**加密：
     * 1、构造密钥生成器keyGenerator
     * 2、根据encodeRules规则初始化密钥生成器
     * 3、产生密钥
     * 4、创建和初始化密码器
     * 5、内容加密
     * 6、返回字符串
     */

    public static String AESEncode(String msg){
        try {

            /*
            //构造密钥，指定为AES算法，不区分大小写
            KeyGenerator keyGenerator=KeyGenerator.getInstance(TYPE);

            //根据规则初始化密钥生成器，根据传入的数组生成一个128的随机数
            keyGenerator.init(128,new SecureRandom(encodeRules.getBytes()));

            //长生密钥
            SecretKey orginal_key=keyGenerator.generateKey();

            //获得原始对称密钥的字节数组
            byte[]raw=orginal_key.getEncoded();

            //根据字节数字产生AES密钥
            SecretKey key=new SecretKeySpec(raw,"AES");

            //根据指定算法AES自成密码器
            Cipher cipher=Cipher.getInstance("AES");
            */


            //指定操作初始化密码器
            cipher.init(Cipher.ENCRYPT_MODE,key);

            //获取加密内容的字节数组，为了防止内容有中文英语解密乱码问题，设置编码格式
            byte[]byte_encode=msg.getBytes("utf-8");

            //根据密码器的初始化方式去加密，
            byte[]byte_AES=cipher.doFinal(byte_encode);

            //加密后的数据转化为字符串
            String AES_encode=new String(new BASE64Encoder().encode(byte_AES));
            return AES_encode;

        }catch (Exception e){
            e.toString();
            return null;
        }
    }

    public static String AESDecode(String mgs){
        try {

            cipher.init(Cipher.DECRYPT_MODE,key);

            byte[]byte_mgs=new BASE64Decoder().decodeBuffer(mgs);

            byte[]decode_msg=cipher.doFinal(byte_mgs);
            String AES_decode=new String(decode_msg,"utf-8");
            return AES_decode;

        } catch (Exception e) {
            e.printStackTrace();
            return "";

        }
    }

}
