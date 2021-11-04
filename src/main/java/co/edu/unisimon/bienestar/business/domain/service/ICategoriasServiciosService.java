package co.edu.unisimon.bienestar.business.domain.service;

import java.util.List;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosSedeDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosEntity;

public interface ICategoriasServiciosService extends IService<CategoriasServiciosEntity, Long>{

	public List<CategoriasServiciosSedeDto> findSede();
	
}
