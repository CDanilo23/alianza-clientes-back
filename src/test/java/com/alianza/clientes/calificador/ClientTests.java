package com.alianza.clientes.calificador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
class ClientTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void crearClienteYobtenerClientesPrecargadosCorrectamente() throws Exception {

        mvc.perform(
                MockMvcRequestBuilders.post("/client")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new SolicitudCrearClienteTest(
                                "cordoñez", "Cristian", "Ordoñez",
                                "3115648797", "bob.johnson@example.com", LocalDate.of(2024,02,5),
                                LocalDate.of(2024, 02, 29)))))
                .andExpect(status().isOk())
                .andReturn();

        mvc.perform(MockMvcRequestBuilders
                .get("/client")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].sharedKey", is("jdoe")))
                .andExpect(jsonPath("$[0].name", is("John")))
                .andExpect(jsonPath("$[0].lastName", is("Doe")))
                .andExpect(jsonPath("$[0].phone", is("+1-555-1234567")))
                .andExpect(jsonPath("$[1].sharedKey", is("asmith")))
                .andExpect(jsonPath("$[1].name", is("Alice")))
                .andExpect(jsonPath("$[1].lastName", is("Smith")))
                .andExpect(jsonPath("$[1].phone", is("+1-555-9876543")))
                .andExpect(jsonPath("$[2].sharedKey", is("bjohnson")))
                .andExpect(jsonPath("$[2].name", is("Bob")))
                .andExpect(jsonPath("$[2].lastName", is("Johnson")))
                .andExpect(jsonPath("$[2].phone", is("+1-555-7412589")))
                .andExpect(jsonPath("$[3].sharedKey", is("cordoñez")))
                .andExpect(jsonPath("$[3].name", is("Cristian")))
                .andExpect(jsonPath("$[3].lastName", is("Ordoñez")))
                .andExpect(jsonPath("$[3].phone", is("3115648797")));

    }

}
