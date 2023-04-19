import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import rabobank.utils.formatter.FormatTimeLong;
import rabobank.utils.formatter.FormatTimeShort;
import rabobank.utils.functions.ConvertMilliseconds;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertMillisecondsTest {

    @Test
    @DisplayName("Test converter with formatter TimeLong don't show zeroes")
    public void ConvertFormatTimeLongNoZeroTest() {
        assertEquals("3 minutes 34 seconds", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeLong(false)));
        assertEquals("1 hours 5 minutes", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeLong(false)));
        assertEquals("3 hours 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeLong(false)));
        assertEquals("3 hours 2 minutes 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeLong(false)));

        // 0 milliseconds
        assertEquals("", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeLong(false)));

        // 576 milliseconds
        assertEquals("", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeLong(false)));
    }

    @Test
    @DisplayName("Test converter with formatter TimeLong show zeroes")
    public void ConvertFormatTimeLongShowZeroTest() {
        assertEquals("0 hours 3 minutes 34 seconds", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeLong(true)));
        assertEquals("1 hours 5 minutes 0 seconds", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeLong(true)));
        assertEquals("3 hours 0 minutes 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeLong(true)));
        assertEquals("3 hours 2 minutes 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeLong(true)));

        // 0 milliseconds
        assertEquals("0 hours 0 minutes 0 seconds", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeLong(true)));

        // 576 milliseconds
        assertEquals("0 hours 0 minutes 0 seconds", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeLong(true)));

        assertEquals("0 hours 3 minutes 34 seconds", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeLong()));
        assertEquals("1 hours 5 minutes 0 seconds", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeLong()));
        assertEquals("3 hours 0 minutes 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeLong()));
        assertEquals("3 hours 2 minutes 59 seconds", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeLong()));

        // 0 milliseconds
        assertEquals("0 hours 0 minutes 0 seconds", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeLong()));

        // 576 milliseconds
        assertEquals("0 hours 0 minutes 0 seconds", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeLong()));
    }

    @Test
    @DisplayName("Test converter with formatter TimeShort don't show zeroes")
    public void ConvertFormatTimeshortNoZeroTest() {
        assertEquals("3m 34s", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeShort(false)));
        assertEquals("1h 5m", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeShort(false)));
        assertEquals("3h 59s", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeShort(false)));
        assertEquals("3h 2m 59s", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeShort(false)));
        assertEquals("2h 3m 34s", ConvertMilliseconds.convert(2*60*60*1000+3*60*1000+34*1000,new FormatTimeShort(false)));

        // 0 milliseconds
        assertEquals("", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeShort(false)));

        // 576 milliseconds
        assertEquals("", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeShort(false)));
    }

    @Test
    @DisplayName("Test converter with formatter TimeShort don't show zeroes")
    public void ConvertFormatTimeshortShowZeroTest() {
        assertEquals("0h 3m 34s", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeShort(true)));
        assertEquals("1h 5m 0s", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeShort(true)));
        assertEquals("3h 0m 59s", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeShort(true)));
        assertEquals("3h 2m 59s", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeShort(true)));
        assertEquals("2h 3m 34s", ConvertMilliseconds.convert(2*60*60*1000+3*60*1000+34*1000,new FormatTimeShort(true)));

        // 0 milliseconds
        assertEquals("0h 0m 0s", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeShort(true)));

        // 576 milliseconds
        assertEquals("0h 0m 0s", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeShort(true)));

        assertEquals("0h 3m 34s", ConvertMilliseconds.convert(3*60*1000+34*1000,new FormatTimeShort()));
        assertEquals("1h 5m 0s", ConvertMilliseconds.convert(1*60*60*1000+5*60*1000,new FormatTimeShort()));
        assertEquals("3h 0m 59s", ConvertMilliseconds.convert(3*60*60*1000+59*1000,new FormatTimeShort()));
        assertEquals("3h 2m 59s", ConvertMilliseconds.convert(3*60*60*1000+2*60*1000+59*1000,new FormatTimeShort()));
        assertEquals("2h 3m 34s", ConvertMilliseconds.convert(2*60*60*1000+3*60*1000+34*1000,new FormatTimeShort()));

        // 0 milliseconds
        assertEquals("0h 0m 0s", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000,new FormatTimeShort()));

        // 576 milliseconds
        assertEquals("0h 0m 0s", ConvertMilliseconds.convert(0*60*60*1000+0*60*1000+0*1000+576,new FormatTimeShort()));
    }
}
