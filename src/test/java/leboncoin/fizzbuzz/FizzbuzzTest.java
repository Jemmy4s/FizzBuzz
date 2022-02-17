package leboncoin.fizzbuzz;


import com.leboncoin.fizzbuzz.model.FizzBuzz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FizzbuzzTest {
    @Test
    @DisplayName("str1 : fizz |str2 : buzz |int1 : 3 |int2: 5 | limit 5")
    void fizzBuzz35limit5(){
        FizzBuzz fbTest = new FizzBuzz(3,5,"fizz", "buzz", 5);
        List<String> listFbTest = fbTest.calculFizzbuzz();
        String [] arrayFizzByzz = {"1","2","fizz","4","buzz"};
        Assertions.assertEquals(Arrays.asList(arrayFizzByzz), listFbTest);
    }

    @Test
    @DisplayName("str1 : fizz |str2 : buzz |int1 : 3 |int2: 5 | limit 5")
    void fizzBuzz12limit5(){
        FizzBuzz fbTest = new FizzBuzz(1,2,"fizz", "buzz", 5);
        List<String> listFbTest = fbTest.calculFizzbuzz();
        String [] arrayFizzByzz = {"fizz","fizzbuzz","fizz","fizzbuzz","fizz"};
        Assertions.assertEquals(Arrays.asList(arrayFizzByzz), listFbTest);
    }
}
