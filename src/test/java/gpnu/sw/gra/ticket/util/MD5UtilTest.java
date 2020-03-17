package gpnu.sw.gra.ticket.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther:S
 * @Date:20/3/17
 */
class MD5UtilTest {

    @Test
    void MD5() {
        String str="123456";
        System.out.println(MD5Util.MD5(str));
    }
}