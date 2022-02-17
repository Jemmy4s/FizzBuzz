package leboncoin.fizzbuzz;

import com.leboncoin.fizzbuzz.controller.FizzbuzzController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class FizzbuzzControllerTest {

    @Autowired
    FizzbuzzController fbcontroller;


    @Test
    public void contextLoads() {
        Assertions.assertThat(fbcontroller).isNotNull();
    }


}
