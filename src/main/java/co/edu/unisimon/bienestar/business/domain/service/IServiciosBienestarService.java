package co.edu.unisimon.bienestar.business.domain.service;

import java.util.List;
import java.util.Optional;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.ServiciosBienestarEntity;

public interface IServiciosBienestarService extends IService<ServiciosBienestarEntity, Long> {

	public List<ServiciosBienestarEntity> findAllSubServicios();
	
	public List<ServiciosBienestarEntity> listarTodosLosSubServiciosDeUnServicio(Long id);
	
	//subServicios
	public Optional<ServiciosBienestarEntity> findSubServicioById(Long id);
	
}
