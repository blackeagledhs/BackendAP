
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.Educacion;
import com.blackeagledhs.BackendAP.repository.EducacionRepository;
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
public class EducacionService {
    
    @Autowired
    EducacionRepository educacionRepository;

    
    public List<Educacion> list(){
        return educacionRepository.findAll();
    }

    
    public Optional<Educacion> getOne(Long id){
        return educacionRepository.findById(id);
    }

  

    public void  save(Educacion educacion){
        educacionRepository.save(educacion);
    }
    
    public void delete(Long id){
        educacionRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return educacionRepository.existsById(id);
    }
}
