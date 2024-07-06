package org.matsuri.customerservice.external.webcontrollers;

import org.junit.jupiter.api.Test;
import org.matsuri.customerservice.external.dao.entities.Instrument;
import org.matsuri.customerservice.external.dao.repositories.InstrumentRepository;
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
public class AddInstrumentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    InstrumentRepository instrumentRepository;

    @Test
    void testAddInstrumentController() throws Exception {

        String expected = "Insertion of instrument IN987 complete";
        when(instrumentRepository.updateOrInsert(any())).thenReturn(new Instrument("IN987", "This is a description for IN987"));

        assertEquals(expected,
                 mockMvc.perform(post("/addInstrument")
                .content("{\"instrumentId\": \"IN987\", \"instrumentDescription\": \"This is an instrument IN987\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString());
    }


}
