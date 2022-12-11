package com.pruebatecnica.automotor.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lavado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String opcion;


    @OneToMany(mappedBy = "lavado",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Cliente> cliente = new ArrayList<>();
}
