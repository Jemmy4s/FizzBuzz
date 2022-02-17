package leboncoin.fizzbuzz;

import com.leboncoin.fizzbuzz.controller.FizzbuzzController;
import com.leboncoin.fizzbuzz.controller.FizzbuzzControllerImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@WebMvcTest(FizzbuzzControllerImpl.class)
public class FizzbuzzControllerTest {


    @MockBean
    FizzbuzzController fbcontroller;
    @Autowired
    MockMvc mockMvc;


    @Test
    public void contextLoads() {
        Assertions.assertThat(fbcontroller).isNotNull();
    }


}
