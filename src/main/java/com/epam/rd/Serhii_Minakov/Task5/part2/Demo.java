package com.epam.rd.Serhii_Minakov.Task5.part2;


import com.epam.rd.Serhii_Minakov.Task5.part1.FileReadWrapper;
import com.epam.rd.Serhii_Minakov.Task5.part2.filters.FileFilter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static final String YES = "1";
    public static final String ROOT = "C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5";

    public static void main(String[] args) {
        List<File> files = (List<File>) FileUtils.listFiles(new File(ROOT), null, true);
        Scanner scanner = new Scanner(System.in);

        FileReadWrapper readWrapper = new FileReadWrapper("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.txt");
        for (String line : readWrapper) {
            System.out.println(line);
        }
        FileFilter nextFilter = null;
        System.out.println("Filter by name?");
        String answer = scanner.nextLine();
        if (YES.equals(answer)) {
            nextFilter = FilterFiller.fillName(scanner, null);
        }
        System.out.println("Filter by extension?");
        answer = scanner.nextLine();
        if (YES.equals(answer)) {
            nextFilter = FilterFiller.fillExtension(scanner, nextFilter);
        }
        System.out.println("Filter by date range?");
        answer = scanner.nextLine();
        if (YES.equals(answer)) {
            nextFilter = FilterFiller.fillDateRange(scanner, nextFilter);
        }
        System.out.println("Filter by size range?");
        answer = scanner.nextLine();
        if (YES.equals(answer)) {
            nextFilter = FilterFiller.fillSizeRange(scanner, nextFilter);
        }

        files = nextFilter.filter(files);
        for (File file : files) {
            System.out.println(file);
        }
    }

}
