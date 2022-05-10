
package com.blackeagledhs.BackendAP.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */

@Getter @Setter
public class DomicilioDto {
    
    private String calle;
    private String numero;
    private String cp;
    private String localidad;
    private String provincia;

    public DomicilioDto() {
    }

    public DomicilioDto(String calle, String numero, String cp, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
    }
    
    
}
