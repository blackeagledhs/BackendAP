
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blackeagle
 */

@Repository
public interface PersonaRepository  extends JpaRepository<Persona, Long>{
    
}
