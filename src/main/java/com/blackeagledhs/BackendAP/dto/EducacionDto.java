
package com.blackeagledhs.BackendAP.dto;

import com.blackeagledhs.BackendAP.entity.Persona;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */

@Getter @Setter
public class EducacionDto {
    
    private String titulo;
    private String instituto;
    private String anio_egreso;
    private Persona persona;

    public EducacionDto() {
    }

    public EducacionDto(String titulo, String instituto, String anio_egreso, Persona persona) {
        this.titulo = titulo;
        this.instituto = instituto;
        this.anio_egreso = anio_egreso;
        this.persona = persona;
    }
    
    
}
