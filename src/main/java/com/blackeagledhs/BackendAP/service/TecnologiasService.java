
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.Tecnologias;
import com.blackeagledhs.BackendAP.repository.TecnologiasRepository;
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
public class TecnologiasService {
    
    @Autowired
    TecnologiasRepository tecnologiasRepository;

    
    public List<Tecnologias> list(){
        return tecnologiasRepository.findAll();
    }

    
    public Optional<Tecnologias> getOne(Long id){
        return tecnologiasRepository.findById(id);
    }

  

    public void  save(Tecnologias tecnologias){
        tecnologiasRepository.save(tecnologias);
    }
    
    public void delete(Long id){
        tecnologiasRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return tecnologiasRepository.existsById(id);
    }
}
