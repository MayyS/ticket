package gpnu.sw.gra.ticket.util;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther:S
 * @Date:20/3/17
 */
class ThreeDESUtilTest {



    @Test
    void encry() {
        String res="12345678";
        String tmp=ThreeDESUtil.encry(res);
        System.out.println(tmp);
        System.out.println(ThreeDESUtil.descry(tmp));
    }

    @Test
    void descry() {

    }
}