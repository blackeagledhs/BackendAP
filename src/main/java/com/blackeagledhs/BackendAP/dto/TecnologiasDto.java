
package com.blackeagledhs.BackendAP.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */

@Getter @Setter
public class TecnologiasDto {
    
    private String lenguaje;
    private String porcentaje;

    public TecnologiasDto() {
    }

    public TecnologiasDto(String lenguaje, String porcentaje) {
        this.lenguaje = lenguaje;
        this.porcentaje = porcentaje;
    }
    
    
}
