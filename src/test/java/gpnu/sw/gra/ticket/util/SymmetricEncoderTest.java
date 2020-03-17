package gpnu.sw.gra.ticket.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther:S
 * @Date:20/3/17
 */
class SymmetricEncoderTest {

    @Test
    void AESEncode() {
        String msg="1他你23456";
        String tmp=SymmetricEncoder.AESEncode(msg);
        System.out.println(tmp);
        System.out.println(SymmetricEncoder.AESDecode(tmp));
    }

    @Test
    void AESDecode() {

        String msg="hIivVp866uYTOTeGXMQKMA==";
        System.out.println(SymmetricEncoder.AESDecode(msg));

    }
}