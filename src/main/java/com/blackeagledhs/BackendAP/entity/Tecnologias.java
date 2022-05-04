
package com.blackeagledhs.BackendAP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author blackeagle
 */

@Getter @Setter
@Entity
@Table(name = "tecnologia")
public class Tecnologias implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lenguaje;
    private String porcentaje;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "persona_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Persona persona;

    public Tecnologias() {
    }

    public Tecnologias(Long id, String lenguaje, String porcentaje, Persona persona) {
        this.id = id;
        this.lenguaje = lenguaje;
        this.porcentaje = porcentaje;
        this.persona = persona;
    }
    
    
}
