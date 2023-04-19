import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import rabobank.utils.formatter.TimeFormatterLong;
import rabobank.utils.formatter.TimeFormatterShort;
import rabobank.utils.functions.ConvertMilliseconds;


import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.stream.Stream;

class ConvertMillisecondsTest {

    @ParameterizedTest()
    @MethodSource("getTestTimesLongWithoutZeroes")
    @DisplayName("Test converter with formatter TimeLong don't show zeroes")
    public void ConvertFormatTimeLongNoZeroTest(int milliseconds, String expected) {
        TimeFormatterLong timeFormatterLongHideZero = TimeFormatterLong.builder().showZero(false).build();

        assertEquals(ConvertMilliseconds.convert(milliseconds,timeFormatterLongHideZero),expected);
    }

    private static Stream<Arguments> getTestTimesLongWithoutZeroes(){
        return Stream.of(
                Arguments.of(timeToMillis(0,3,34),"3 minutes 34 seconds" ),
                Arguments.of(timeToMillis(1,5,0), "1 hours 5 minutes"),
                Arguments.of(timeToMillis(3,0,59), "3 hours 59 seconds"),
                Arguments.of(timeToMillis(3,2,59), "3 hours 2 minutes 59 seconds"),
                Arguments.of(0, ""),
                Arguments.of(999, "")
        );
    }

    @ParameterizedTest
    @MethodSource("getTestTimesLongWithZeroes")
    @DisplayName("Test converter with formatter TimeLong show zeroes")
    public void ConvertFormatTimeLongShowZeroTest(int milliseconds, String expected) {
        TimeFormatterLong timeFormatterLongShowZero = TimeFormatterLong.builder().build();
        assertEquals(ConvertMilliseconds.convert(milliseconds,timeFormatterLongShowZero),expected);

    }
    private static Stream<Arguments> getTestTimesLongWithZeroes(){
        return Stream.of(
                Arguments.of(timeToMillis(0,3,34), "0 hours 3 minutes 34 seconds" ),
                Arguments.of(timeToMillis(1,5,0), "1 hours 5 minutes 0 seconds"),
                Arguments.of(timeToMillis(3,0,59), "3 hours 0 minutes 59 seconds"),
                Arguments.of(timeToMillis(3,2,59), "3 hours 2 minutes 59 seconds"),
                Arguments.of(0, "0 hours 0 minutes 0 seconds"),
                Arguments.of(999, "0 hours 0 minutes 0 seconds")
        );
    }

    @ParameterizedTest
    @MethodSource("getTestTimesShortWithoutZeroes")
    @DisplayName("Test converter with formatter TimeShort don't show zeroes")
    public void ConvertFormatTimeShortNoZeroTest(int milliseconds, String expected) {
        TimeFormatterShort timeFormatterShortHideZero = TimeFormatterShort.builder().showZero(false).build();

        assertEquals(ConvertMilliseconds.convert(milliseconds,timeFormatterShortHideZero),expected);
    }
    private static Stream<Arguments> getTestTimesShortWithoutZeroes(){
        return Stream.of(
                Arguments.of(timeToMillis(0,3,34), "3m 34s" ),
                Arguments.of(timeToMillis(1,5,0), "1h 5m"),
                Arguments.of(timeToMillis(3,0,59), "3h 59s"),
                Arguments.of(timeToMillis(3,2,59), "3h 2m 59s"),
                Arguments.of(0, ""),
                Arguments.of(999, "")
        );
    }
    @ParameterizedTest
    @MethodSource("getTestTimesShortWithZeroes")
    @DisplayName("Test converter with formatter TimeShort don't show zeroes")
    public void ConvertFormatTimeShortShowZeroTest(int milliseconds, String expected) {
        TimeFormatterShort timeFormatterShortShowZero = TimeFormatterShort.builder().build();

        assertEquals(ConvertMilliseconds.convert(milliseconds,timeFormatterShortShowZero),expected);
    }

    private static Stream<Arguments> getTestTimesShortWithZeroes(){
        return Stream.of(
                Arguments.of(timeToMillis(0,3,34), "0h 3m 34s" ),
                Arguments.of(timeToMillis(1,5,0), "1h 5m 0s"),
                Arguments.of(timeToMillis(3,0,59), "3h 0m 59s"),
                Arguments.of(timeToMillis(3,2,59), "3h 2m 59s"),
                Arguments.of(0, "0h 0m 0s"),
                Arguments.of(999, "0h 0m 0s")
        );
    }

    private static int timeToMillis(int hours, int minutes, int seconds) {
        return hours * 3600000 + minutes * 60000 + seconds * 1000;
    }
}
