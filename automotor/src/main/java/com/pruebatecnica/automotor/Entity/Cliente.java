package com.pruebatecnica.automotor.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "El campo es requerido")
    private String nombre;


    @NotBlank(message = "El campo es requerido")
    @Pattern(regexp = "([A-Z]{3}[0-9]{3})|([0-9]{3}[A-Z]{4})")
    private String vehiculo;


    private int precio;

    private String fecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lavado_id")
    private Lavado lavado;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "alineacion_id")
    private Alineacion alineacion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aceite_id")
    private Aceite aceite;
}
