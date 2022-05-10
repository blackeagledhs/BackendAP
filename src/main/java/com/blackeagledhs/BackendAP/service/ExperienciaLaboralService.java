
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.ExperienciaLaboral;
import com.blackeagledhs.BackendAP.repository.ExperienciaLaboralRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 *
 * @author blackeagle
 */
@Service
@Transactional
public class ExperienciaLaboralService {
    
    @Autowired
    ExperienciaLaboralRepository experiencialaboralRepository;

    
    public List<ExperienciaLaboral> list(){
        return experiencialaboralRepository.findAll();
    }

    
    public Optional<ExperienciaLaboral> getOne(Long id){
        return experiencialaboralRepository.findById(id);
    }

  

    public void  save(ExperienciaLaboral experiencialaboral){
        experiencialaboralRepository.save(experiencialaboral);
    }
    
    public void delete(Long id){
        experiencialaboralRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return experiencialaboralRepository.existsById(id);
    }
}
