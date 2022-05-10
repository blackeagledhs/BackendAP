
package com.blackeagledhs.BackendAP.controller;

import com.blackeagledhs.BackendAP.dto.ProyectoDto;
import com.blackeagledhs.BackendAP.entity.Proyecto;
import com.blackeagledhs.BackendAP.service.ProyectoService;
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
@RequestMapping("/persona/proyecto")

public class ProyectoController {

    @Autowired
    ProyectoService proyectoService;

    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = proyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") Long id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = proyectoService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){    
        Proyecto proyecto = new Proyecto();
        proyecto.setNombreproyecto(proyectoDto.getNombreproyecto());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setEnlace(proyectoDto.getEnlace());                        
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("El proyecto fue creado"), HttpStatus.OK);
    }
     
     

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ProyectoDto proyectoDto){
        
        Proyecto proyecto = proyectoService.getOne(id).get();
        proyecto.setNombreproyecto(proyectoDto.getNombreproyecto());
        proyecto.setDescripcion(proyectoDto.getDescripcion());
        proyecto.setEnlace(proyectoDto.getEnlace());                        
        proyectoService.save(proyecto);
        return new ResponseEntity(new Mensaje("Registro de Proyecto Actualizado"), HttpStatus.OK);
    }
  
  

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!proyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de proyecto"), HttpStatus.NOT_FOUND);
        proyectoService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }


    
}
