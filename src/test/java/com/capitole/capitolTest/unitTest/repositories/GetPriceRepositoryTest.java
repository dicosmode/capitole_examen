package com.capitole.capitolTest.unitTest.repositories;

import com.capitole.capitolTest.core.entities.Price;
import com.capitole.capitolTest.repositories.GetPriceRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class GetPriceRepositoryTest {
/*
-          Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
-          Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
-          Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
* */
    @Autowired
    private GetPriceRepository getPriceRepository;

    @Test
    public void WhenExecuteTest1_ThenGetPriceObj() {
        //Arrange
        String str = "2020-06-14T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        //Act
        List<Price> prices = this.getPriceRepository.findAllPrices(dateTime, 1, 35455);
        //Assert
        assertEquals(1,prices.size());
        assertEquals(1, prices.get(0).getPriceId());
        assertEquals("2020-06-14T00:00:00", prices.get(0).getStartDate().format(formatter));
        assertEquals("2020-12-31T23:59:59", prices.get(0).getEndDate().format(formatter));
        assertEquals(0, prices.get(0).getPriority());
    }

    @Test
    public void WhenExecuteTest2_ThenGetTwoPriceObj() {
        //Arrange
        String str = "2020-06-14T16:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        //Act
        List<Price> prices = this.getPriceRepository.findAllPrices(dateTime, 1, 35455);
        //Assert
        assertEquals(2,prices.size());
        assertEquals(1, prices.get(0).getPriceId());
        assertEquals(2, prices.get(1).getPriceId());
        assertEquals(0, prices.get(0).getPriority());
        assertEquals(1, prices.get(1).getPriority());
    }

    @Test
    public void WhenExecuteTest3_ThenGetPriceObj() {
        //Arrange
        String str = "2020-06-14T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        //Act
        List<Price> prices = this.getPriceRepository.findAllPrices(dateTime, 1, 35455);
        //Assert
        assertEquals(1,prices.size());
        assertEquals(1, prices.get(0).getPriceId());
        assertEquals("2020-06-14T00:00:00", prices.get(0).getStartDate().format(formatter));
        assertEquals("2020-12-31T23:59:59", prices.get(0).getEndDate().format(formatter));
        assertEquals(0, prices.get(0).getPriority());
    }

    @Test
    public void WhenExecuteTest4_ThenGetTwoPriceObj() {
        //Arrange
        String str = "2020-06-15T10:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        //Act
        List<Price> prices = this.getPriceRepository.findAllPrices(dateTime, 1, 35455);
        //Assert
        assertEquals(2,prices.size());
        assertEquals(1, prices.get(0).getPriceId());
        assertEquals(3, prices.get(1).getPriceId());
        assertEquals(0, prices.get(0).getPriority());
        assertEquals(1, prices.get(1).getPriority());
    }

    @Test
    public void WhenExecuteTest5_ThenGetTwoPriceObj() {
        //Arrange
        String str = "2020-06-16T21:00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        //Act
        List<Price> prices = this.getPriceRepository.findAllPrices(dateTime, 1, 35455);
        //Assert
        assertEquals(2,prices.size());
        assertEquals(1, prices.get(0).getPriceId());
        assertEquals(4, prices.get(1).getPriceId());
        assertEquals(0, prices.get(0).getPriority());
        assertEquals(1, prices.get(1).getPriority());
    }
}