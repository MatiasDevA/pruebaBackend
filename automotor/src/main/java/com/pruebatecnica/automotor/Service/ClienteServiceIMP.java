package com.pruebatecnica.automotor.Service;

import com.pruebatecnica.automotor.Entity.Cliente;
import com.pruebatecnica.automotor.Entity.Lavado;
import com.pruebatecnica.automotor.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceIMP implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listaCliente() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        List<Cliente> cli = clienteRepository.findAll();
        List<Cliente> auxCliente = new ArrayList<Cliente>();

       auxCliente = filtrarCliente(cli, cliente.getNombre());
        evaluarPrecio(cliente);
       if(auxCliente.size() >= 4){
           evaluarPrecio(cliente);
            cliente.setPrecio((int) (cliente.getPrecio() * 0.50));
        }

          return   clienteRepository.save(cliente);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }


    public List<Cliente> filtrarCliente(List<Cliente> cliente, String nombre){
    return cliente.stream().filter( x -> x.getNombre().equals(nombre)).collect(Collectors.toList());
    }

    public void evaluarPrecio(Cliente cliente){
        if(cliente.getLavado().getId() == 1 && cliente.getAceite().getId() == 1 && cliente.getAlineacion().getId() == 1){
            cliente.setPrecio(1000);
        } else if(cliente.getLavado().getId() == 1 && cliente.getAceite().getId() == 1 && cliente.getAlineacion().getId() == 2){
            cliente.setPrecio(900);
        } else if (cliente.getLavado().getId() == 1 && cliente.getAceite().getId() == 2 && cliente.getAlineacion().getId() == 1) {
            cliente.setPrecio(800);
        } else if(cliente.getLavado().getId() == 1 && cliente.getAceite().getId() == 2 && cliente.getAlineacion().getId() == 2){
            cliente.setPrecio(750);
        } else if(cliente.getLavado().getId() == 2 && cliente.getAceite().getId() == 1 && cliente.getAlineacion().getId() == 1){
            cliente.setPrecio(650);
        } else if(cliente.getLavado().getId() == 2 && cliente.getAceite().getId() == 1 && cliente.getAlineacion().getId() == 2){
            cliente.setPrecio(600);
        } else if(cliente.getLavado().getId() == 2 && cliente.getAceite().getId() == 2 && cliente.getAlineacion().getId() == 1){
            cliente.setPrecio(400);
        } else if(cliente.getLavado().getId() == 2 && cliente.getAceite().getId() == 2 && cliente.getAlineacion().getId()== 2){
            cliente.setPrecio(1500);
        }
    }

}


