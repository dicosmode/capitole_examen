package com.capitole.capitolTest.integrationTest.entrypoints;

import com.capitole.capitolTest.CapitolTestApplication;
import com.capitole.capitolTest.core.useCases.impl.DefaultGetPriceUseCase;
import com.capitole.capitolTest.repositories.GetPriceRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CapitolTestApplication.class)
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    private GetPriceRepository getPriceRepository;
    @Autowired
    private DefaultGetPriceUseCase defaultGetPriceUseCase;

    @Test
    public void WhenExecuteTest1_ThenReturnPriceList_1() throws Exception {
        //Act
        mvc.perform(MockMvcRequestBuilders.get("/price?implementationDate=2020-06-14T10:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.price", equalTo(35.5)));
    }
    @Test
    public void WhenExecuteTest2_ThenReturnPriceList_2() throws Exception {
        //Act
        mvc.perform(MockMvcRequestBuilders.get("/price?implementationDate=2020-06-14T16:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T15:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-06-14T18:30:00")))
                .andExpect(jsonPath("$.priceList", equalTo(2)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.price", equalTo(25.45)));
    }
    @Test
    public void WhenExecuteTest3_ThenReturnPriceList_1() throws Exception {
        //Act
        mvc.perform(MockMvcRequestBuilders.get("/price?implementationDate=2020-06-14T21:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-14T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(1)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.price", equalTo(35.5)));
    }
    @Test
    public void WhenExecuteTest4_ThenReturnPriceList_3() throws Exception {
        //Act
        mvc.perform(MockMvcRequestBuilders.get("/price?implementationDate=2020-06-15T10:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-15T00:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-06-15T11:00:00")))
                .andExpect(jsonPath("$.priceList", equalTo(3)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.price", equalTo(30.5)));
    }
    @Test
    public void WhenExecuteTest5_ThenReturnPriceList_4() throws Exception {
        //Act
        mvc.perform(MockMvcRequestBuilders.get("/price?implementationDate=2020-06-16T21:00:00&productId=35455&brandId=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.brandId", equalTo(1)))
                .andExpect(jsonPath("$.startDate", equalTo("2020-06-15T16:00:00")))
                .andExpect(jsonPath("$.endDate", equalTo("2020-12-31T23:59:59")))
                .andExpect(jsonPath("$.priceList", equalTo(4)))
                .andExpect(jsonPath("$.productId", equalTo(35455)))
                .andExpect(jsonPath("$.price", equalTo(38.95)));
    }
}