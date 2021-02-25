package com.epam.rd.Serhii_Minakov.Task7.part1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is a wrapper to LocalDateTime.
 * Created for converting string to date and easily compare dates
 */
public class DateTime implements Comparable<DateTime> {

    private final LocalDateTime dateTime;
    private static final String FORMAT = "yyyy-MM-dd HH:mm";

    public DateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public DateTime(String dateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(FORMAT);
        this.dateTime = LocalDateTime.parse(dateTime, formatter);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public int compareTo(DateTime otherDate) {
        return this.dateTime.isAfter(otherDate.dateTime) ? 1 : -1;
    }

    @Override
    public String toString() {
        return dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
