package com.pruebatecnica.automotor.Service;

import com.pruebatecnica.automotor.Entity.Cliente;
import com.pruebatecnica.automotor.Entity.Lavado;

import java.util.List;

public interface ClienteService {

    public List<Cliente> listaCliente();

    public Cliente guardar(Cliente cliente);

    public Cliente save(Cliente cliente);

    void eliminarCliente(Long id);

}
