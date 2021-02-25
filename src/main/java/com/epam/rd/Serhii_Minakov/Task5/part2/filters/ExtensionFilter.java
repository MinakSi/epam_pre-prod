package com.epam.rd.Serhii_Minakov.Task5.part2.filters;

import java.io.File;
import java.util.function.Predicate;

/**
 * This class implements functionality of finding all the files by specified file extension
 */
public class ExtensionFilter extends FileFilter {
    private final String extension;
    public static final String NAME_REGEX = ".+(?=\\.)";
    public static final String ABSOLUTE_PATH_REG = ".*\\\\";

    public ExtensionFilter(FileFilter fileFilter, String extension) {
        super(fileFilter);
        this.extension = extension;
    }

    /**
     * Checks if the file has the specified extension
     * @return true if the file has the specified extension, false if not
     */
    protected Predicate<File> filterCondition() {
        return x -> x.getAbsolutePath().matches(ABSOLUTE_PATH_REG + NAME_REGEX + this.extension);
    }

}