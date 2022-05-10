
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.ExperienciaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blackeagle
 */
@Repository
public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long> {

}
