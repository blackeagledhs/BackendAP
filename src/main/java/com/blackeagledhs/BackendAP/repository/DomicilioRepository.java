
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 *
 * @author blackeagle
 */

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long>{
    
}
