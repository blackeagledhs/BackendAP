
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.Tecnologias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blackeagle
 */

@Repository
public interface TecnologiasRepository extends JpaRepository<Tecnologias, Long>{
    
}
