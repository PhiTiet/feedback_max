package rabobank.utils.formatter;

import rabobank.utils.functions.model.Time;

import java.util.StringJoiner;

public class FormatTimeLong implements FormatTime{

    // Show zero values
    final boolean showZero;

    public FormatTimeLong() {
        showZero = true;
    }
    public FormatTimeLong(boolean showZero) {
        this.showZero = showZero;
    }
    public String format(Time time) {

        StringJoiner strj = new StringJoiner(" ");

        // Format hours
        if(time.hours() != 0 || showZero) {
            strj.add(Integer.toString(time.hours()));
            strj.add("hours");
        }

        // Format minutes
        if(time.minutes() != 0 || showZero) {
            strj.add(Integer.toString(time.minutes()));
            strj.add("minutes");
        }

        // Format seconds
        if(time.seconds() != 0 || showZero) {
            strj.add(Integer.toString(time.seconds()));
            strj.add("seconds");
        }

        return strj.toString();
    }
}
