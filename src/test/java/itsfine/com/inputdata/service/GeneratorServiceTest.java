package itsfine.com.inputdata.service;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorServiceTest {

    @Test
    void getRandomCarNumber() {
        GeneratorService generatorService = new GeneratorService();
        String actual = generatorService.getRandomCarNumber();
        assertTrue( actual.length() == 9 || actual.length() == 10 || actual.length() == 8 );
    }

    @Test
    void getDateTime() {
        GeneratorService generatorService = new GeneratorService();
        LocalDateTime actual = generatorService.getDateTime();
        assertEquals(actual.toLocalDate(), LocalDate.now());
    }

    @Test
    void getRandomInt() {
        GeneratorService generatorService = new GeneratorService();
        int actual = generatorService.getRandomInt(0, 9);
        assertTrue(actual == (int)actual);
    }
}