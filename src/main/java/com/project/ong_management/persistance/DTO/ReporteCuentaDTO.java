package com.project.ong_management.persistance.DTO;

import com.project.ong_management.persistance.entity.TipoCuota;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;


import java.time.LocalDateTime;

@Data
public class ReporteCuentaDTO {

    private int reporteId;
//    @NotNull(message = "El id del socio no puede ser nulo")
    private int socioId;
    @NotNull(message = "La fecha de pago no puede ser nula")
    private LocalDateTime fechaPago;

    @NotBlank(message = "La cuenta bancaria no puede estar en blanco")
    private String cuentaBancaria;

    @NotNull(message = "El tipo de cuota no puede ser nulo")
    private TipoCuota tipoCuota;

    @NotNull(message = "El importe total no puede ser nulo")
    @PositiveOrZero(message = "El importe total debe ser mayor o igual a cero")
    private Double importeTotal;
}
