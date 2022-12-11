package com.pruebatecnica.automotor.Service;

import com.pruebatecnica.automotor.Entity.Alineacion;
import com.pruebatecnica.automotor.Repository.AlineacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlineacionServiceIMP implements AlineacionService {

    @Autowired
    private AlineacionRepository alineacionRepository;


    @Override
    public List<Alineacion> listaAlineacion() {
        return alineacionRepository.findAll();
    }
}
