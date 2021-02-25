package com.epam.rd.Serhii_Minakov.Task6;

import com.epam.rd.Serhii_Minakov.Task6.input.creators.DepartureServiceCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.OnlineServiceCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.creators.ProductCreator;
import com.epam.rd.Serhii_Minakov.Task6.input.types.RandomGoodsInput;
import com.epam.rd.Serhii_Minakov.Task6.models.DepartureService;
import com.epam.rd.Serhii_Minakov.Task6.models.OnlineService;
import com.epam.rd.Serhii_Minakov.Task6.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreatorsTest {
    @Test
    void productTest() {
        Product product = new ProductCreator(new RandomGoodsInput()).create();
        Assertions.assertNotNull(product);
    }

    @Test
    void onlineServiceTest() {
        OnlineService onlineService = new OnlineServiceCreator(new RandomGoodsInput()).create();
        Assertions.assertNotNull(onlineService);
    }

    @Test
    void departureServiceTest() {
        DepartureService departureService = new DepartureServiceCreator(new RandomGoodsInput()).create();
        Assertions.assertNotNull(departureService);
    }
}
