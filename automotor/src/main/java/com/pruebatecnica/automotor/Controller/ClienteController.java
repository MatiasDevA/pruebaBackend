package com.pruebatecnica.automotor.Controller;


import com.pruebatecnica.automotor.Entity.Cliente;
import com.pruebatecnica.automotor.Entity.Lavado;
import com.pruebatecnica.automotor.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cliente")
@CrossOrigin()
public class ClienteController {


    @Autowired
    private ClienteService clienteService;



    @GetMapping("/all")
    public ResponseEntity<List<Cliente>> listaDeClientes(){

        return ResponseEntity.ok( clienteService.listaCliente());
    }

    @PostMapping("/save")
    public ResponseEntity<Cliente> guardarCliente(@RequestBody @Valid Cliente cliente){
       return new ResponseEntity<>(clienteService.guardar(cliente), HttpStatus.CREATED) ;
    }
}
