package com.pruebatecnica.automotor.Repository;

import com.pruebatecnica.automotor.Entity.Lavado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LavadoRepository extends JpaRepository<Lavado,Long> {
}
