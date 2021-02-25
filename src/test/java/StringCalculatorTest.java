import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringCalculatorTest {

    @Test
    void for_empty_string_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void for_single_number_return_that_number() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void should_return_sum_of_two_numbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void should_return_sum_of_N_numbers() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(15, stringCalculator.add("1,2,3,4,5"));
    }

    @Test
    void should_return_sum_of_N_numbers_with_new_line() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(15, stringCalculator.add("1\n2,3,4,5"));
        assertEquals(10, stringCalculator.add("1,2\n3,4"));

    }

    @Test
    void should_return_sum_of_N_numbers_with_new_delimeter() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(15, stringCalculator.add("1\n2,3,4,5"));
        assertEquals(10, stringCalculator.add("//;\n1,2\n3,4"));

    }
}