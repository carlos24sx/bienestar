package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosEntity;

@Mapper
public interface CategoriasServicioMapper {

	CategoriasServiciosEntity convertDtoToEntity(CategoriasServiciosDto categoriasServiciosDto);
	
	CategoriasServiciosDto convertEntityToDto(CategoriasServiciosEntity categoriasServiciosEntity);
	
	List<CategoriasServiciosDto> convertEntityListToDtoList(List<CategoriasServiciosEntity>categoriasServiciosEntities);
	
}
