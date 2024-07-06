package org.matsuri.customerservice.external.webcontrollers;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.entities.VendorPriceList;
import org.matsuri.customerservice.external.dao.repositories.VendorPriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PublishPriceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VendorPriceListRepository vendorPriceListRepository;

    @Test
    void testPublishPricesController() throws Exception {

        LocalDateTime now = LocalDateTime.now();
        String instrumentId = "In003";
        String vendorId = "V002";
        VendorPriceList vendorPriceList = new VendorPriceList(new InstrumentIdVendorId(instrumentId, vendorId), 224.75, now);
        String expected = String.format("Insertion of a new price for instrument %s, vendor %s complete", instrumentId, vendorId);
        when(vendorPriceListRepository.updateOrInsert(any())).thenReturn(vendorPriceList);

        assertEquals(expected,
                this.mockMvc.perform(post("/publishPrices")
                .content("{\"instrumentId\":\"In003\",\"price\":224.75,\"priceDate\":\"" + now + "\",\"vendorId\":\"V002\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());

    }

}