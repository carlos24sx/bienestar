package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unisimon.bienestar.business.domain.dto.ServiciosBienestarDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.ServiciosBienestarEntity;

@Mapper 
public interface ServiciosBienestarMapper {

	ServiciosBienestarEntity convertDtoToEntity (final ServiciosBienestarDto serviciosBienestarDto);
	
	ServiciosBienestarDto convertEntityToDto (final ServiciosBienestarEntity serviciosBienestarEntity);
	
	List<ServiciosBienestarDto> convertEntityListToDto(final List<ServiciosBienestarEntity> serviciosBienestarEntities);
	
	
}
