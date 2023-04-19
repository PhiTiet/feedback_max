package rabobank.utils.formatter;

import lombok.Builder;

import rabobank.utils.functions.model.Time;

import java.util.StringJoiner;
@Builder
public class TimeFormatterLong implements TimeFormatter {
    @Builder.Default
    private boolean showZero = true;

    public String format(Time time) {
        StringJoiner stringJoiner = new StringJoiner(" ");

        if(time.hours() != 0 || showZero) {
            stringJoiner.add(Integer.toString(time.hours()));
            stringJoiner.add("hours");
        }

        if(time.minutes() != 0 || showZero) {
            stringJoiner.add(Integer.toString(time.minutes()));
            stringJoiner.add("minutes");
        }

        if(time.seconds() != 0 || showZero) {
            stringJoiner.add(Integer.toString(time.seconds()));
            stringJoiner.add("seconds");
        }

        return stringJoiner.toString();
    }
}
