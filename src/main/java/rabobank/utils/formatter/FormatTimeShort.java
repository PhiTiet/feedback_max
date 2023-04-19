package rabobank.utils.formatter;

import rabobank.utils.functions.model.Time;

import java.util.StringJoiner;

public class FormatTimeShort implements FormatTime {

    // Show zero values
    final boolean showZero;

    public FormatTimeShort() {
        showZero = true;
    }
    public FormatTimeShort(boolean showZero) {
        this.showZero = showZero;
    }
    public String format(Time time) {

        StringJoiner strj = new StringJoiner(" ");

        // Format hours
        if(time.hours() != 0 || showZero) {
            strj.add(Integer.toString(time.hours())+"h");
        }

        // Format minutes
        if(time.minutes() != 0 || showZero) {
            strj.add(Integer.toString(time.minutes())+"m");
        }

        // Format seconds
        if(time.seconds() != 0 || showZero) {
            strj.add(Integer.toString(time.seconds())+"s");
        }

        return strj.toString();
    }
}