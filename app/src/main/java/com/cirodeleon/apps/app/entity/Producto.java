package com.cirodeleon.apps.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTOS")
@Getter
@Setter
@NoArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacío.")
    @NotNull(message = "El nombre no puede ser null.")
    private String nombre;
    @NotBlank(message = "La descripcion no puede estar vacía.")
    @NotNull(message = "La descripcion no puede ser null.")
    private String descripcion;
    @DecimalMin(value = "0.01", inclusive = false, message = "El precio debe ser mayor que cero.")
    @NotNull(message = "El precio no puede ser null.")
    private BigDecimal precio;

    
}
