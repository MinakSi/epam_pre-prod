package com.epam.rd.Serhii_Minakov.Task5;

import com.epam.rd.Serhii_Minakov.Task5.part2.FilterFiller;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.FileFilter;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileFilterTest {
    private List<File> files;
    private Scanner scanner;

    @BeforeEach
    void initFiles() {
        String root = "C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5";
        this.files = (List<File>) FileUtils.listFiles(new File(root), null, true);
    }

    @Test
    void nameFilterTest() {
        BufferedReader input = new BufferedReader(new StringReader("123" + System.lineSeparator()));
        scanner = new Scanner(input);
        FileFilter fileFilter = FilterFiller.fillName(scanner, null);
        files = fileFilter.filter(files);
        List<File> expected = new ArrayList<>();
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.doc"));
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.txt"));
        assertArrayEquals(expected.toArray(), files.toArray());
    }

    @Test
    void extensionFilterTest() {
        BufferedReader input = new BufferedReader(new StringReader(".txt" + System.lineSeparator()));
        scanner = new Scanner(input);
        FileFilter fileFilter = FilterFiller.fillExtension(scanner, null);
        files = fileFilter.filter(files);
        List<File> expected = new ArrayList<>();
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.txt"));
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\456.txt"));
        assertArrayEquals(expected.toArray(), files.toArray());
    }

    @Test
    void dateRangeFilterTest() {
        BufferedReader input = new BufferedReader(new StringReader("2021-01-10 22:15" + System.lineSeparator() +
                "2021-01-10 22:17" + System.lineSeparator()));
        scanner = new Scanner(input);
        FileFilter fileFilter = FilterFiller.fillDateRange(scanner, null);
        files = fileFilter.filter(files);
        List<File> expected = new ArrayList<>();
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.txt"));
        assertArrayEquals(expected.toArray(), files.toArray());
    }

    @Test
    void sizeRangeFilterTest() {
        BufferedReader input = new BufferedReader(new StringReader("3000" + System.lineSeparator() +
                "5000" + System.lineSeparator()));
        scanner = new Scanner(input);
        FileFilter fileFilter = FilterFiller.fillSizeRange(scanner, null);
        files = fileFilter.filter(files);
        List<File> expected = new ArrayList<>();
        expected.add(new File("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\FilterFiller.java"));
        assertArrayEquals(expected.toArray(), files.toArray());
    }
}
