package org.example;

import java.time.LocalDateTime;

public class TimeStamp {
    int day;
    int month;
    int year;
    int hour;
    int minute;

    public TimeStamp() {
        // the system current time

        LocalDateTime currentDateTime = LocalDateTime.now();

        day = currentDateTime.getDayOfMonth();
        month = currentDateTime.getMonthValue();
        year = currentDateTime.getYear();
        hour = currentDateTime.getHour();
        minute = currentDateTime.getMinute();
    }

    public String toString() {
        return "[" +day + "/" + month + "/" + year + " | " + hour + ":" + minute + "]";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof TimeStamp) {
            TimeStamp otherTimeStamp = (TimeStamp) other;
            return this.year == otherTimeStamp.year
                    && this.month == otherTimeStamp.month
                    && this.day == otherTimeStamp.day
                    && this.hour == otherTimeStamp.hour
                    && this.minute == otherTimeStamp.minute;
        }
        return false;
    }

}
