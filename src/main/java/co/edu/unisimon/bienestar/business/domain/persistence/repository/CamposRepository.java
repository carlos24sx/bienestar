package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.CamposEntity;

public interface CamposRepository extends JpaRepository<CamposEntity, Long> {

	
	@Query("select  c from CamposEntity c where c.estado=1")
	public List<CamposEntity> findAll();

}
