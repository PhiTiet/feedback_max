package rabobank.utils.functions;

import rabobank.utils.formatter.TimeFormatter;
import rabobank.utils.functions.model.Time;

public class ConvertMilliseconds {

    public static String convert(int milliSec, TimeFormatter format) {

        int seconds = milliSec / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;

        seconds %= 60;
        minutes %= 60;

        Time time = new Time(hours,minutes,seconds);

        return format.format(time);
    }
}
