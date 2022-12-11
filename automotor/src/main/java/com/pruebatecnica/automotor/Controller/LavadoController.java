package com.pruebatecnica.automotor.Controller;


import com.pruebatecnica.automotor.Entity.Lavado;
import com.pruebatecnica.automotor.Service.LavadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lavado")
@CrossOrigin()
public class LavadoController {


    @Autowired
    private LavadoService lavadoService;


    @GetMapping("/all")
    public ResponseEntity<List<Lavado>> listaDeLavados(){
        return ResponseEntity.ok( lavadoService.listaLavado());
    }
}
