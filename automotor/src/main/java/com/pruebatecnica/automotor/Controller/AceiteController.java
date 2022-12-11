package com.pruebatecnica.automotor.Controller;


import com.pruebatecnica.automotor.Entity.Aceite;

import com.pruebatecnica.automotor.Service.AceiteService;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aceite")
@CrossOrigin()
public class AceiteController {


    @Autowired
    private AceiteService aceiteService;


    @GetMapping("/all")
    public ResponseEntity<List<Aceite>> listaDeLavados(){
        return  ResponseEntity.ok(aceiteService.listaAceite());
    }
}
