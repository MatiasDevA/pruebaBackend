package com.pruebatecnica.automotor.Repository;

import com.pruebatecnica.automotor.Entity.Aceite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CambioDeAceiteRepository extends JpaRepository<Aceite,Long> {
}
