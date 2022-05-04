
package com.blackeagledhs.BackendAP.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author blackeagle
 */

@Getter @Setter
@Entity
@Table(name = "domicilio")
public class Domicilio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private String numero;
    private String cp;
    private String localidad;
    private String provincia;
    @OneToOne(mappedBy = "domicilio")
    private Persona persona;

    public Domicilio() {
    }

    public Domicilio(Long id, String calle, String numero, String cp, String localidad, String provincia, Persona persona) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.cp = cp;
        this.localidad = localidad;
        this.provincia = provincia;
        this.persona = persona;
    }
    
    
}
