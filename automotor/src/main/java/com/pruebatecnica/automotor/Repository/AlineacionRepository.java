package com.pruebatecnica.automotor.Repository;


import com.pruebatecnica.automotor.Entity.Alineacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlineacionRepository extends JpaRepository<Alineacion,Long> {
}
