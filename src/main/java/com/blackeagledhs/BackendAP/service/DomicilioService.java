
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.Domicilio;
import com.blackeagledhs.BackendAP.repository.DomicilioRepository;
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
public class DomicilioService {
    
    @Autowired
    DomicilioRepository domicilioRepository;
    
    public List<Domicilio> list(){
        return domicilioRepository.findAll();
    }

    
    public Optional<Domicilio> getOne(Long id){
        return domicilioRepository.findById(id);
    }
  

    public void  save(Domicilio educacion){
        domicilioRepository.save(educacion);
    }
    
    public void delete(Long id){
        domicilioRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return domicilioRepository.existsById(id);
    }

}
