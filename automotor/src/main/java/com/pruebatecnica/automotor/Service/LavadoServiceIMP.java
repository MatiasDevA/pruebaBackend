package com.pruebatecnica.automotor.Service;

import com.pruebatecnica.automotor.Entity.Lavado;
import com.pruebatecnica.automotor.Repository.LavadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LavadoServiceIMP implements LavadoService{


    @Autowired
    private LavadoRepository lavadoRepository;

    @Override
    public List<Lavado> listaLavado() {
        return lavadoRepository.findAll();
    }
}
