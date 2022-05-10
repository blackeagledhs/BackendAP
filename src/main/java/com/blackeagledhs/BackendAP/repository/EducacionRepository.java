
package com.blackeagledhs.BackendAP.repository;

import com.blackeagledhs.BackendAP.entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blackeagle
 */
@Repository
public interface EducacionRepository extends JpaRepository<Educacion, Long> {

}
