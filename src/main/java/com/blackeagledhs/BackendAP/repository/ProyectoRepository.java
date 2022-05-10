
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blackeagle
 */

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    
}
