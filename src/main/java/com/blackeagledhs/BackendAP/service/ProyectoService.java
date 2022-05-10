
package com.blackeagledhs.BackendAP.service;

import com.blackeagledhs.BackendAP.entity.Proyecto;
import com.blackeagledhs.BackendAP.repository.ProyectoRepository;
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
public class ProyectoService {
    
    @Autowired
    ProyectoRepository proyectoRepository;

    
    public List<Proyecto> list(){
        return proyectoRepository.findAll();
    }

    
    public Optional<Proyecto> getOne(Long id){
        return proyectoRepository.findById(id);
    }

  

    public void  save(Proyecto proyecto){
        proyectoRepository.save(proyecto);
    }
    
    public void delete(Long id){
        proyectoRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return proyectoRepository.existsById(id);
    }
}
