package com.epam.rd.Serhii_Minakov.Task5.part2.filters;

import java.io.File;
import java.util.function.Predicate;

import static java.lang.Integer.parseInt;

/**
 * This class implements functionality of finding all the files between the specified file sizes
 */
public class SizeRangeFilter extends FileFilter {
    private final String maxSize;
    private final String minSize;

    public SizeRangeFilter(FileFilter fileFilter, String minSize, String maxSize) {
        super(fileFilter);
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    /**
     * Checks if the file size is between two specified file sizes
     * @return true if the file is between two specified file sizes, false if not
     */
    protected Predicate<File> filterCondition() {
        return x -> x.length() >= parseInt(this.minSize) && x.length() <= parseInt(this.maxSize);
    }
}
