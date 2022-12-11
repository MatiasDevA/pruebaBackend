package com.pruebatecnica.automotor;

import com.pruebatecnica.automotor.Entity.Cliente;
import com.pruebatecnica.automotor.Entity.Lavado;
import com.pruebatecnica.automotor.Repository.ClienteRepository;
import com.pruebatecnica.automotor.Service.ClienteServiceIMP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClienteServicioTest {

    @Mock
    private ClienteRepository clienteRepository;


    @InjectMocks
    private ClienteServiceIMP clienteServiceImp;

    private Cliente cliente;
    private Lavado lavado;
    @BeforeEach
    void setUp(){
        cliente = new Cliente();
        cliente.setNombre("Mateo");
        cliente.setVehiculo("AA11AA");
        cliente.setFecha("12/12/2022");
        cliente.setPrecio(900);
        cliente.setId(1L);
        cliente.setLavado(lavado);

    }
    @DisplayName("Test de agregar un cliente")
    @Test
    void testGuardarCliente(){

        given(clienteRepository.save(cliente)).willReturn(cliente);

        Cliente clienteAGuardar = clienteServiceImp.save(cliente);

        assertThat(clienteAGuardar).isNotNull();
    }
    @DisplayName(" Test de lista de clientes")
    @Test
    void testListaDeCliente(){
       Cliente cliente1 = new Cliente();
        cliente1.setNombre("Marta");
        cliente1.setVehiculo("bb11bb");
        cliente1.setFecha("2/2/2022");
        cliente1.setPrecio(100);
        cliente1.setId(2L);

        given(clienteRepository.findAll()).willReturn(List.of(cliente1, cliente));

        List<Cliente> clientes = clienteServiceImp.listaCliente();
        assertThat(clientes).isNotNull();
        assertThat(clientes.size()).isEqualTo(2);
    }


    @DisplayName("Test para retornar una lista vacia")
    @Test
    void testListarColeccionClientesVacia(){
        //given
        Cliente cliente2 = new Cliente();
        cliente2.setNombre("Marta");
        cliente2.setVehiculo("bb11bb");
        cliente2.setFecha("2/2/2022");
        cliente2.setPrecio(100);
        cliente2.setId(3L);
        given(clienteRepository.findAll()).willReturn(Collections.emptyList());

        //when
        List<Cliente> listaClientes = clienteServiceImp.listaCliente();

        //then
        assertThat(listaClientes).isEmpty();
        assertThat(listaClientes.size()).isEqualTo(0);
    }


    @DisplayName("Test para eliminar un Cliente")
    @Test
    void testEliminarEmpleado(){
        //given
        long clienteId = 1L;
        willDoNothing().given(clienteRepository).deleteById(clienteId);

        //when
        clienteServiceImp.eliminarCliente(clienteId);

        //then
        verify(clienteRepository,times(1)).deleteById(clienteId);
    }

}
