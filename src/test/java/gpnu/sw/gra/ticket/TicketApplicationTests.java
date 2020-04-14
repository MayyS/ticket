package gpnu.sw.gra.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class TicketApplicationTests {

    @Test
    void contextLoads() {
        String mgs="nihao%s";
        String mm=String.format(mgs,"12");
        System.out.println(mm);
        char ch;
        for(int i=0; i<26 ; i++){
            ch= (char) ('a'+i);

        }
    }

}
