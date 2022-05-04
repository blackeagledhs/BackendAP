
package com.blackeagledhs.BackendAP.controller;

import com.blackeagledhs.BackendAP.dto.PersonaDto;
import com.blackeagledhs.BackendAP.entity.Persona;
import com.blackeagledhs.BackendAP.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author blackeagle
 */

@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = personaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Persona persona = personaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody PersonaDto personaDto){    
        Persona persona = new Persona();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setTitulo(personaDto.getTitulo());
        persona.setDomicilio(personaDto.getDomicilio());
        persona.setTelefono(personaDto.getTelefono());
        persona.setFoto_perfil(personaDto.getFoto_perfil());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("La persona fue creada"), HttpStatus.OK);
    }
     
     

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody PersonaDto personaDto){
        
        Persona persona = personaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setTitulo(personaDto.getTitulo());
        persona.setDomicilio(personaDto.getDomicilio());
        persona.setTelefono(personaDto.getTelefono());
        persona.setFoto_perfil(personaDto.getFoto_perfil());
        personaService.save(persona);
        return new ResponseEntity(new Mensaje("Registro de Persona Actualizado"), HttpStatus.OK);
    }
  
  

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!personaService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de educacion"), HttpStatus.NOT_FOUND);
        personaService.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminado"), HttpStatus.OK);
    }
}
