package leboncoin.fizzbuzz;


import com.leboncoin.fizzbuzz.service.FizzbuzzService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FizzbuzzServiceTest {


   @Autowired FizzbuzzService fizzbuzzService;

        @Test
        public void contextLoads() throws Exception {
            assertThat(fizzbuzzService).isNotNull();
        }

     @Test
     void createAndFindFizzbuzz(){
         fizzbuzzService.createFizzBuzzList(2,3, "str1", "str2", 5);

     }
}
