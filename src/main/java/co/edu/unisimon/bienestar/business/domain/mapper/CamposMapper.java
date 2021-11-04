package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.unisimon.bienestar.business.domain.dto.CamposDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CamposEntity;

@Mapper
public interface CamposMapper {

	CamposEntity convertDtoToEntity(final CamposDto camposDto);

	CamposDto convertEnityToDto(final CamposEntity camposEntity);

	List<CamposDto> convertEntityListToDtoList(final List<CamposEntity> camposEntities);

}
