package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class StringCalculatorShould {

    @Test
    @Order(1)
    void empty_string_should_return_0() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    @Order(2)
    void string_with_single_number_should_return_number_as_int() {
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }
    
    @Test
    @Order(3)
    void string_with_numbers_delemited_by_comma_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(7, stringCalculator.add("3,4"));
    }
    
    @Test
    @Order(4)
    void string_with_multiple_numbers_delemited_by_comma_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(10, stringCalculator.add("1,2,4,3"));
    }
    
    @Test
    @Order(5)
    void string_with_multiple_numbers_on_different_lines_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(10, stringCalculator.add("1\n2,4,3"));
    }
    
    @Test
    @Order(6)
    void string_with_custom_delimiter_should_return_sum() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(9, stringCalculator.add("//:\n2:4:3"));
    }
    
    @Test
    @Order(7)
    void string_with_negative_numbers_should_throw_exception() {
    	try {
			StringCalculator stringCalculator = new StringCalculator();
			stringCalculator.add("//:\n2:4:-3:-8");
			fail("should throw exception");
		} catch (RuntimeException e) {
			assertEquals("negatives not allowed -3-8", e.getMessage());
		}
    }
    
    @Test
    @Order(8)
    void numbers_greater_than_1000_should_be_ignored() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(9, stringCalculator.add("//:\n2:4:3:3976"));
    }
    
    @Test
    @Order(9)
    void count_the_number_of_times_Add_was_invoked() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(8, stringCalculator.GetCalledCount());
    }
    
    @Test
    @Order(10)
    void should_accept_delimiter_of_any_length() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(9, stringCalculator.add("//[###]\n4###2###3"));
    }
    
    @Test
    @Order(11)
    void string_starting_with_plus_should_be_incremented_by_one() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(9, stringCalculator.add("+1,2,3"));
    }
    
    @Test
    @Order(12)
    void string_starting_with_plus_and_contains_double_slash_should_be_incremented_by_one() {
    	StringCalculator stringCalculator = new StringCalculator();
    	assertEquals(9, stringCalculator.add("+//[;]\n1;2;3"));
    }
}
