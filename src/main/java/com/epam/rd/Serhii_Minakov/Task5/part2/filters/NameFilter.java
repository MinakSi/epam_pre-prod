package com.epam.rd.Serhii_Minakov.Task5.part2.filters;

import java.io.File;
import java.util.function.Predicate;

/**
 * This class implements functionality of finding all the files by specified file name
 */
public class NameFilter extends FileFilter {
    private final String name;
    public static final String EXTENSION_REG = "\\..+$";
    public static final String ABSOLUTE_PATH_REG = ".*\\\\";

    public NameFilter(FileFilter fileFilter, String name) {
        super(fileFilter);
        this.name = name;
    }

    /**
     * Checks if the file has the specified name
     * @return true if the file has the specified name, false if not
     */
    protected Predicate<File> filterCondition() {
        return x -> x.getAbsolutePath().matches(ABSOLUTE_PATH_REG + this.name + EXTENSION_REG);
    }
}
