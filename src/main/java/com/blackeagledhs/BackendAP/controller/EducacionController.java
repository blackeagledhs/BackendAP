
package com.blackeagledhs.BackendAP.controller;

import com.blackeagledhs.BackendAP.dto.EducacionDto;
import com.blackeagledhs.BackendAP.entity.Educacion;
import com.blackeagledhs.BackendAP.service.EducacionService;
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
@RequestMapping("/persona/educacion")

public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = educacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") Long id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Educacion educacion = educacionService.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }

    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){    
        Educacion educacion = new Educacion();
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setInstituto(educacionDto.getInstituto());
        educacion.setAnio_egreso(educacionDto.getAnio_egreso());                    
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("El estudio fue creado"), HttpStatus.OK);
    }
     
     

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody EducacionDto educacionDto){
        
        Educacion educacion = educacionService.getOne(id).get();
        educacion.setTitulo(educacionDto.getTitulo());
        educacion.setInstituto(educacionDto.getInstituto());
        educacion.setAnio_egreso(educacionDto.getAnio_egreso());  
        educacionService.save(educacion);
        return new ResponseEntity(new Mensaje("Registro de Educacion Actualizado"), HttpStatus.OK);
    }
  
  

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!educacionService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de educacion"), HttpStatus.NOT_FOUND);
        educacionService.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminado"), HttpStatus.OK);
    }


    
}
