import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;


public class YearTest {
    Main checkYear = new Main();

    @BeforeAll
    public static void beforeAllMethod() {
        System.out.println("BeforeAll call");
    }

    @BeforeEach
    public void beforeEachMethod() {
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("AfterEach call");
    }

    @AfterAll
    public static void afterAllMethod() {
        System.out.println("AfterAll call");
    }


    @Test
    public void checkYearPositive() {
        //arrange
        int year = 2022;
        int days = 365;
        boolean expected = true;

        //act
        boolean result = checkYear.checkYear(year, days);

        //assert
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(ints = {2012, 2016, 2020})
    public void testCheckYears(int years) {
        int days = 366;
        boolean result = checkYear.checkYear(years, days);
        boolean expected = true;

        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("TestSource")
    public void testParCheckWithSource(int year, int days, boolean expected) {
        boolean result = checkYear.checkYear(year, days);
        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> TestSource() {
        return Stream.of(
                Arguments.of(1764, 366, true),
                Arguments.of(2013, 365, true)
        );
    }
}







