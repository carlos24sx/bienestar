package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unisimon.bienestar.business.domain.dto.EstadoCamposServicioDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.EstadoCamposServicioEntity;

@Mapper
public interface EstadoCamposServicioMapper {

	

	EstadoCamposServicioEntity convertDtoToEntity(final EstadoCamposServicioDto camposServicioDto);

	EstadoCamposServicioDto convertEnityToDto(final EstadoCamposServicioEntity camposServicioEntity);

	List<EstadoCamposServicioDto> convertEntityListToDtoList(final List<EstadoCamposServicioEntity> camposServicioEntities);
	
}
