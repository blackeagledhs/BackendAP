package com.blackeagledhs.BackendAP.dto;

import com.blackeagledhs.BackendAP.entity.Persona;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */

@Getter @ Setter
public class ExperienciaLaboralDto {
    
    private String empresa;
    private String cargo;
    private String anio_ingreso;
    private String anio_egreso;
    private Persona persona;
    
    public ExperienciaLaboralDto() {
    }

    public ExperienciaLaboralDto(String empresa, String cargo, String anio_ingreso, String anio_egreso, Persona persona) {
        this.empresa = empresa;
        this.cargo = cargo;
        this.anio_ingreso = anio_ingreso;
        this.anio_egreso = anio_egreso;
        this.persona = persona;
    }
    
    
    
}
