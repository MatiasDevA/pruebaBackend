package com.pruebatecnica.automotor.Controller;


import com.pruebatecnica.automotor.Entity.Alineacion;

import com.pruebatecnica.automotor.Service.AlineacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alineacion")
@CrossOrigin()
public class AlineacionController {


    @Autowired
    private AlineacionService alineacionService;


    @GetMapping("/all")
    public ResponseEntity<List<Alineacion>> listaDeLavados(){

        return ResponseEntity.ok(alineacionService.listaAlineacion());
    }
}
