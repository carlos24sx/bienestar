package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.AreasBienestarEntity;

@Repository
public interface AreasBienestarRepository extends JpaRepository<AreasBienestarEntity, Long>{
	
	@Query("select a from AreasBienestarEntity a where a.estado=1")
	public List<AreasBienestarEntity> findAll();
	
}
