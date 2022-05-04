
package com.blackeagledhs.BackendAP.dto;

import com.blackeagledhs.BackendAP.entity.Domicilio;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */
@Getter @Setter
public class PersonaDto {
    
  
    private String nombre;
    private String apellido;
    private String titulo;
    private Domicilio domicilio;
    private String telefono;
    private String foto_perfil;
}
