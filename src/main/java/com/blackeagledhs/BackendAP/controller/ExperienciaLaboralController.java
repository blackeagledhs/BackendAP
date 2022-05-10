
package com.blackeagledhs.BackendAP.controller;

import com.blackeagledhs.BackendAP.dto.ExperienciaLaboralDto;
import com.blackeagledhs.BackendAP.entity.ExperienciaLaboral;
import com.blackeagledhs.BackendAP.service.ExperienciaLaboralService;
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
@RequestMapping("/persona/experiencialaboral")

public class ExperienciaLaboralController {

    @Autowired
    ExperienciaLaboralService experiencialaboralService;

    @GetMapping("/lista")
    public ResponseEntity<List<ExperienciaLaboral>> list(){
        List<ExperienciaLaboral> list = experiencialaboralService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<ExperienciaLaboral> getById(@PathVariable("id") Long id){
        if(!experiencialaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        ExperienciaLaboral experiencialaboral = experiencialaboralService.getOne(id).get();
        return new ResponseEntity(experiencialaboral, HttpStatus.OK);
    }

    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody ExperienciaLaboralDto experiencialaboralDto){    
        ExperienciaLaboral experiencialaboral = new ExperienciaLaboral();
        
        experiencialaboral.setEmpresa(experiencialaboral.getEmpresa());
        experiencialaboral.setCargo(experiencialaboral.getCargo());
        experiencialaboral.setAnio_ingreso(experiencialaboral.getAnio_ingreso());
        experiencialaboral.setAnio_egreso(experiencialaboral.getAnio_egreso());                        
        experiencialaboralService.save(experiencialaboral);
        return new ResponseEntity(new Mensaje("El trabajo fue creado"), HttpStatus.OK);
    }
     
     

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ExperienciaLaboralDto experiencialaboralDto){
        
        ExperienciaLaboral experiencialaboral = new ExperienciaLaboral();
        
        experiencialaboral.setEmpresa(experiencialaboral.getEmpresa());
        experiencialaboral.setCargo(experiencialaboral.getCargo());
        experiencialaboral.setAnio_ingreso(experiencialaboral.getAnio_ingreso());
        experiencialaboral.setAnio_egreso(experiencialaboral.getAnio_egreso());                        
        experiencialaboralService.save(experiencialaboral);
        return new ResponseEntity(new Mensaje("Registro de Trabajo Actualizado"), HttpStatus.OK);
    }
  
  

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!experiencialaboralService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de trabajo"), HttpStatus.NOT_FOUND);
        experiencialaboralService.delete(id);
        return new ResponseEntity(new Mensaje("Trabajo eliminado"), HttpStatus.OK);
    }


    
}
