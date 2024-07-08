package org.matsuri.customerservice.external.webcontrollers;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.dao.entities.GetPricesForVendor;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.repositories.PricesForVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GetPricesForVendorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PricesForVendorRepository pricesForVendorRepository;

    @Test
    void testGetPricesForVendorController() throws Exception {

        LocalDateTime now = LocalDateTime.now();
        List<GetPricesForVendor> pricesForVendor = new ArrayList() {{add(new GetPricesForVendor(new InstrumentIdVendorId("In001", "V001"), "Description of an instrument", 12345.67, now));}};
        String expected = "[{\"InstrumentIdVendorId\":{\"InstrumentId\":\"In001\",\"VendorId\":\"V001\"},\"InstrumentDescription\":\"Description of an instrument\",\"Price\":12345.67,\"PriceDate\":\"" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\"}]";
        when(pricesForVendorRepository.getPricesForVendor(anyString())).thenReturn(pricesForVendor);

        assertEquals(expected,
        this.mockMvc.perform(get("/getPricesForVendor?vendorId=V002").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }


}
