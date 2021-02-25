package com.epam.rd.Serhii_Minakov.Task5.part2.filters;


import java.io.File;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class implements a node of chain of responsibility
 */
public abstract class FileFilter {
    private FileFilter next;

    public FileFilter() {
    }

    public FileFilter(FileFilter next) {
        this.next = next;
    }

    /**
     * This method filters list of files by Predicate expression
     * @param files list of files to be filtered
     * @return filtered files by next FileFilter in the chain
     */
    public List<File> filter(List<File> files) {
        files = files.stream()
                .filter(filterCondition())
                .collect(Collectors.toList());
        if (next == null || files.isEmpty()) {
            return files;
        }
        return next.filter(files);
    }

    /**
     * Describes the condition when file passes filtering
     * @return Predicate
     */
    protected abstract Predicate<File> filterCondition();


}


