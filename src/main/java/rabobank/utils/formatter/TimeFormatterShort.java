package rabobank.utils.formatter;

import lombok.Builder;
import rabobank.utils.functions.model.Time;

import java.util.StringJoiner;

@Builder
public class TimeFormatterShort implements TimeFormatter {
    @Builder.Default
    private boolean showZero = true;

    public String format(Time time) {

        StringJoiner stringJoiner = new StringJoiner(" ");

        if (time.hours() != 0 || showZero) {
            stringJoiner.add(Integer.toString(time.hours()));
            stringJoiner.add("h");
        }

        if (time.minutes() != 0 || showZero) {
            stringJoiner.add(time.minutes() + "m");
        }

        if (time.seconds() != 0 || showZero) {
            stringJoiner.add(time.seconds() + "s");
        }

        return stringJoiner.toString();
    }
}
