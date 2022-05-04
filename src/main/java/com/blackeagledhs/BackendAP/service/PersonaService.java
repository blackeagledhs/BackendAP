
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.Persona;
import com.blackeagledhs.BackendAP.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blackeagle
 */

@Service
@Transactional
public class PersonaService {
    
    
   @Autowired
   PersonaRepository personaRepository;
   
   public List<Persona> list() {
       return personaRepository.findAll();
   }
   
   public Optional<Persona> getOne(Long id) {
       return personaRepository.findById(id);
   }
   
   public void  save(Persona persona){
        personaRepository.save(persona);
    }
    
    public void delete(Long id){
        personaRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return personaRepository.existsById(id);
    }
    
    
}
