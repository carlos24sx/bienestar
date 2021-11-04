package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.ServiciosBienestarEntity;

@Repository
public interface ServiciosBienestarRespository extends JpaRepository<ServiciosBienestarEntity, Long>{

	
	@Query("SELECT s FROM ServiciosBienestarEntity s WHERE s.estado=1 AND (s.servicio_padre_id=0 OR s.servicio_padre_id=NULL)")
	public List<ServiciosBienestarEntity> findAll();
	
	@Query("SELECT s FROM ServiciosBienestarEntity s WHERE s.id=?1 AND s.estado=1 AND (s.servicio_padre_id=0 OR s.servicio_padre_id=NULL)")
	public Optional<ServiciosBienestarEntity> findById(@Param(value = "id") Long id);
	
	@Query("SELECT s FROM ServiciosBienestarEntity s WHERE s.estado=1 AND s.servicio_padre_id=?1 ")
	public List<ServiciosBienestarEntity> listarTodosLosSubServiciosDeUnServicio(@Param(value = "id")Long id);
	
	
	//Metodos Para Subservicios
	@Query("SELECT s FROM ServiciosBienestarEntity s WHERE s.estado=1 AND (s.servicio_padre_id>0 OR s.servicio_padre_id!=NULL)")
	public List<ServiciosBienestarEntity> findAllSubServicios();
	
	
	@Query("SELECT s FROM ServiciosBienestarEntity s WHERE s.id=?1 AND s.estado=1 AND (s.servicio_padre_id>0 OR s.servicio_padre_id!=NULL)")
	public Optional<ServiciosBienestarEntity> findSubServicioById(@Param(value = "id") Long id);
}
