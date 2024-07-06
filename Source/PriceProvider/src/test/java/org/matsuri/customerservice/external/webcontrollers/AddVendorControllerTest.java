package org.matsuri.customerservice.external.webcontrollers;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.dao.entities.Vendor;
import org.matsuri.customerservice.external.dao.repositories.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddVendorControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VendorRepository vendorRepository;

    @Test
    void testAddVendorController() throws Exception {

        String expected = "Insertion of vendor V876 complete";
        when(vendorRepository.updateOrInsert(any())).thenReturn(new Vendor("V876", "Vendor Description for V876"));

        assertEquals(expected,
                 mockMvc.perform(post("/addVendor")
                .content("{\"vendorDescription\":\"Vendor Description for V876\",\"vendorId\":\"V876\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }

}