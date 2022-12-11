package com.pruebatecnica.automotor.Service;


import com.pruebatecnica.automotor.Entity.Aceite;
import com.pruebatecnica.automotor.Repository.CambioDeAceiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AceiteServiceIMP implements AceiteService {

    @Autowired
    private CambioDeAceiteRepository aceiteRepository;


    @Override
    public List<Aceite> listaAceite() {
        return aceiteRepository.findAll();
    }
}
