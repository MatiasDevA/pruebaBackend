package com.pruebatecnica.automotor.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aceite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opcion;

    @OneToMany(mappedBy = "aceite",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cliente> cliente;
}
