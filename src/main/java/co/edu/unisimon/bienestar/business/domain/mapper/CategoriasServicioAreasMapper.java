package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unisimon.bienestar.business.domain.dto.PostCategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosAreasEntity;

@Mapper
public interface CategoriasServicioAreasMapper {

	CategoriasServiciosAreasEntity convertDtoToEntity(final PostCategoriasServicioAreasDto tiposServiciosAreasDto);

	PostCategoriasServicioAreasDto convertEntityToDto(final CategoriasServiciosAreasEntity categoriasServiciosAreasEntity);

	List<PostCategoriasServicioAreasDto> convertEntityListToDtoList(final List<CategoriasServiciosAreasEntity> tiposServiciosEntities);

}
