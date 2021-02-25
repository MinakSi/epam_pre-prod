package com.epam.rd.Serhii_Minakov.Task5;

import com.epam.rd.Serhii_Minakov.Task5.part1.FileReadWrapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FileReaderTest {

    @Test
    void fileReaderTest() {
        FileReadWrapper readWrapper = new FileReadWrapper("C:\\Users\\Serhii_Minakov\\IdeaProjects\\pre-prod-java-q3q4-2020\\src\\main\\java\\com\\epam\\rd\\Serhii_Minakov\\Task5\\part2\\123.txt");
        List<String> actual = new ArrayList<>();
        for (String line : readWrapper) {
            actual.add(line);
        }
        String[] expected = {"31242r235" ,
                "sdfergegewrg" ,
                "dgewhrngndgtnmfm f"};
        assertArrayEquals(expected, actual.toArray());
    }
}
