package co.edu.unisimon.bienestar.business.domain.service;

import java.util.List;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosAreasEntity;

public interface ICategoriasServiciosAreasService extends IService<CategoriasServiciosAreasEntity, Long> {
	public List<CategoriasServicioAreasDto> findAllCategoriasServiciosAreasActives();
}
