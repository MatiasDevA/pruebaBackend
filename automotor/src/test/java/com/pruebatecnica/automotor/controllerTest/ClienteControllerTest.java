package com.pruebatecnica.automotor.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pruebatecnica.automotor.Controller.ClienteController;
import com.pruebatecnica.automotor.Entity.Cliente;
import com.pruebatecnica.automotor.Service.ClienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ClienteService clienteService;


    @Test
    void testListarCliente() throws Exception {
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(new Cliente(1L,"Mateo","AABBCC", 900, "12/12/2020", null, null, null));
        listaClientes.add(new Cliente(2L,"Laura","AACCAA", 800, "11/12/2020", null, null, null));
        listaClientes.add(new Cliente(3L,"Santiago","AAHHCC", 700, "10/12/2020", null, null, null));

    given(clienteService.listaCliente()).willReturn(listaClientes);

        ResultActions response = mockMvc.perform(get("/cliente/all"));

        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()", is(listaClientes.size())));
    }
}
