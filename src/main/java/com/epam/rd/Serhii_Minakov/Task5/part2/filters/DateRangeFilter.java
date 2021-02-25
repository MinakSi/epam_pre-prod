package com.epam.rd.Serhii_Minakov.Task5.part2.filters;


import java.io.File;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.function.Predicate;

/**
 * This class implements functionality of finding all the files between two dates
 */
public class DateRangeFilter extends FileFilter {
    private final String minDate;
    private final String maxDate;
    public static final String MASK = "yyyy-MM-dd HH:mm";

    public DateRangeFilter(FileFilter fileFilter, String minDate, String maxDate) {
        super(fileFilter);
        this.maxDate = maxDate;
        this.minDate = minDate;
    }

    /**
     * Checks if the date is between two dates
     * @return true if the date is between two dates, false if not
     */
    protected Predicate<File> filterCondition() {
        return x -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MASK);
            LocalDateTime minDate = LocalDateTime.parse(this.minDate, formatter);
            LocalDateTime maxDate = LocalDateTime.parse(this.maxDate, formatter);
            return minDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() < x.lastModified() &&
                    maxDate.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli() > x.lastModified();
        };
    }
}