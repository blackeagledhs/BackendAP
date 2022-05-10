
package com.blackeagledhs.BackendAP.controller;

import com.blackeagledhs.BackendAP.dto.DomicilioDto;
import com.blackeagledhs.BackendAP.entity.Domicilio;
import com.blackeagledhs.BackendAP.service.DomicilioService;
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
@RequestMapping("/persona/domicilio")
public class DomicilioController {
    
    
   @Autowired
    DomicilioService domicilioService;

    @GetMapping("/lista")
    public ResponseEntity<List<Domicilio>> list(){
        List<Domicilio> list = domicilioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
 
    @GetMapping("/detail/{id}")
    public ResponseEntity<Domicilio> getById(@PathVariable("id") Long id){
        if(!domicilioService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro el resgitro"), HttpStatus.NOT_FOUND);
        Domicilio domicilio = domicilioService.getOne(id).get();
        return new ResponseEntity(domicilio, HttpStatus.OK);
    }

    @PostMapping("/create")
     public ResponseEntity<?> create(@RequestBody DomicilioDto domicilioDto){    
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioDto.getCalle());
        domicilio.setNumero(domicilioDto.getNumero());
        domicilio.setCp(domicilio.getCp());
        domicilio.setLocalidad(domicilioDto.getLocalidad());
        domicilio.setProvincia(domicilioDto.getProvincia());
        domicilioService.save(domicilio);
        return new ResponseEntity(new Mensaje("El domicilio fue creado"), HttpStatus.OK);
    }
     
     

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody DomicilioDto domicilioDto){
        
        Domicilio domicilio = domicilioService.getOne(id).get();
        domicilio.setCalle(domicilioDto.getCalle());
        domicilio.setNumero(domicilioDto.getNumero());
        domicilio.setCp(domicilio.getCp());
        domicilio.setLocalidad(domicilioDto.getLocalidad());
        domicilio.setProvincia(domicilioDto.getProvincia());
        domicilioService.save(domicilio);        
        return new ResponseEntity(new Mensaje("Registro de Domicilio Actualizado"), HttpStatus.OK);
    }
  
  

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")Long id){
        if(!domicilioService.existsById(id))
            return new ResponseEntity(new Mensaje("No se encontro ningun registro de domicilio"), HttpStatus.NOT_FOUND);
        domicilioService.delete(id);
        return new ResponseEntity(new Mensaje("Domicilio eliminado"), HttpStatus.OK);
    }
}
