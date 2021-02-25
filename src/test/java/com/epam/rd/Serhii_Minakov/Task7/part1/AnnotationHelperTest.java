package com.epam.rd.Serhii_Minakov.Task7.part1;

import com.epam.rd.Serhii_Minakov.Task7.part1.input.AnnotationHelper;
import com.epam.rd.Serhii_Minakov.Task7.part1.models.DepartureService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnnotationHelperTest {

    @Test
    void getKeyFromAnnotationTest() {
        AnnotationHelper helper = new AnnotationHelper(DepartureService.class);
        String expected = "master";
        String actual = helper.getKeyFromAnnotation("master");
        Assertions.assertEquals(expected, actual);
    }
}
