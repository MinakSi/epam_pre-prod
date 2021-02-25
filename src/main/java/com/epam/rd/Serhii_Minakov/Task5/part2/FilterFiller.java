package com.epam.rd.Serhii_Minakov.Task5.part2;


import com.epam.rd.Serhii_Minakov.Task5.part2.filters.DateRangeFilter;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.ExtensionFilter;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.FileFilter;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.NameFilter;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.SizeRangeFilter;

import java.util.Scanner;

/**
 * This class is a util class.
 * It creates the chain of responsibility and fills filters with needed data
 */
public class FilterFiller {
    /**
     * This method creates new NameFilter, fills it with needed data
     * and adds it to the chain.
     * @param scanner Scanner which reads needed data
     * @param fileFilter chain of FileFilters, where new NameFilter will be added. Can be null if there is no chain yet.
     * @return NameFilter connected to
     */
    public static NameFilter fillName(Scanner scanner, FileFilter fileFilter) {
        System.out.println("name?");
        String name = scanner.nextLine();
        return new NameFilter(fileFilter, name);
    }

    /**
     * This method creates new ExtensionFilter, fills it with needed data
     * and adds it to the chain.
     * @param scanner Scanner which reads needed data
     * @param fileFilter chain of FileFilters, where new ExtensionFilter will be added. Can be null if there is no chain yet.
     * @return ExtensionFilter connected to
     */
    public static ExtensionFilter fillExtension(Scanner scanner, FileFilter fileFilter) {
        System.out.println("extension?");
        String extension = scanner.nextLine();
        return new ExtensionFilter(fileFilter, extension);
    }

    /**
     * This method creates new SizeRangeFilter, fills it with needed data
     * and adds it to the chain.
     * @param scanner Scanner which reads needed data
     * @param fileFilter chain of FileFilters, where new SizeRangeFilter will be added. Can be null if there is no chain yet.
     * @return SizeRangeFilter connected to
     */
    public static SizeRangeFilter fillSizeRange(Scanner scanner, FileFilter fileFilter) {
        System.out.println("min size?");
        String minSize = scanner.nextLine();
        System.out.println("max size?");
        String maxSize = scanner.nextLine();
        return new SizeRangeFilter(fileFilter, minSize, maxSize);
    }

    /**
     * This method creates new DateRangeFilter, fills it with needed data
     * and adds it to the chain.
     * @param scanner Scanner which reads needed data
     * @param fileFilter chain of FileFilters, where new DateRangeFilter will be added. Can be null if there is no chain yet.
     * @return DateRangeFilter connected to
     */
    public static DateRangeFilter fillDateRange(Scanner scanner, FileFilter fileFilter) {
        System.out.println("min date?");
        String minDate = scanner.nextLine();
        System.out.println("max date?");
        String maxDate = scanner.nextLine();
        return new DateRangeFilter(fileFilter, minDate, maxDate);
    }
}
