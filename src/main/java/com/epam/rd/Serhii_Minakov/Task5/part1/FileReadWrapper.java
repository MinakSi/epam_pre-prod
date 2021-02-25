package com.epam.rd.Serhii_Minakov.Task5.part1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class allows reading a file through for-each loop
 */
public class FileReadWrapper implements Iterable<String> {
    private final File file;

    public FileReadWrapper(String file) {
        this.file = new File(file);
    }

    public Iterator<String> iterator() {
        try {
            return new IteratorImpl();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    private class IteratorImpl implements Iterator<String> {
        private final Scanner scanner;

        private IteratorImpl() throws FileNotFoundException {
            scanner = new Scanner(file);
        }

        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }

        @Override
        public String next() {
            return scanner.nextLine();
        }
    }
}
