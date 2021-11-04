package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.SedeCreditoEntity;

@Repository
public interface SedeCreditoRepository extends JpaRepository<SedeCreditoEntity, Long> {

	@Query(value = "select * from BD_USB.credito.sede",nativeQuery = true)
	public List<SedeCreditoEntity> findAll();
}
