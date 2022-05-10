
package com.blackeagledhs.BackendAP.dto;

import com.blackeagledhs.BackendAP.entity.Persona;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author blackeagle
 */

@Getter @Setter
public class ProyectoDto {
    
    private String nombreproyecto;
    private String descripcion;
    private String enlace;
    private Persona persona;

    public ProyectoDto() {
    }

    public ProyectoDto(String nombreproyecto, String descripcion, String enlace, Persona persona) {
        this.nombreproyecto = nombreproyecto;
        this.descripcion = descripcion;
        this.enlace = enlace;
        this.persona = persona;
    }
    
    
}
