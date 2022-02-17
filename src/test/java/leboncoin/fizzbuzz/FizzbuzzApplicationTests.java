package leboncoin.fizzbuzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.leboncoin.fizzbuzz")
public class FizzbuzzApplicationTests {

    public static void main(String[] args) {
        SpringApplication.run(FizzbuzzApplicationTests.class, args);
    }
}