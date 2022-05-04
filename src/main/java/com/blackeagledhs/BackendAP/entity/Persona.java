
package com.blackeagledhs.BackendAP.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "persona")
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String titulo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
    private String telefono;
    private String foto_perfil;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String titulo, Domicilio domicilio, String telefono, String foto_perfil) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto_perfil = foto_perfil;
    }

    public Persona(String nombre, String apellido, String titulo, Domicilio domicilio, String telefono, String foto_perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.foto_perfil = foto_perfil;
    }

    
    
    
}
