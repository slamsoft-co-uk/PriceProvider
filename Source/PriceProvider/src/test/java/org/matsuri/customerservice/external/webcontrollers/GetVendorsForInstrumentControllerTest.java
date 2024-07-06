package org.matsuri.customerservice.external.webcontrollers;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.dao.entities.GetPricesForVendor;
import org.matsuri.customerservice.external.dao.entities.GetVendorsForInstrument;
import org.matsuri.customerservice.external.dao.entities.InstrumentIdVendorId;
import org.matsuri.customerservice.external.dao.repositories.PricesForVendorRepository;
import org.matsuri.customerservice.external.dao.repositories.VendorsForInstrumentRepository;
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
public class GetVendorsForInstrumentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VendorsForInstrumentRepository vendorsForInstrumentRepository;

    @Test
    void testGetVendorForInstrumentController() throws Exception {

        LocalDateTime now = LocalDateTime.now();
        List<GetVendorsForInstrument> vendorsForInstrument = new ArrayList() {{add(new GetVendorsForInstrument(new InstrumentIdVendorId("In003", "V002"), "Vendor Name 002", 224.75, now));}};
        String expected = "[{\"VendorDescription\":\"Vendor Name 002\",\"Price\":224.75,\"PriceDate\":\"" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\"}]";
        when(vendorsForInstrumentRepository.getVendorsForInstrument(anyString())).thenReturn(vendorsForInstrument);

        assertEquals(expected,
                this.mockMvc.perform(get("/getVendorsForInstrument?instrumentId=In003").contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn().getResponse().getContentAsString());
    }


}
