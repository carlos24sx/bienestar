package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

//import co.edu.unisimon.bienestar.business.domain.dto.AreasBienestarDto;
import co.edu.unisimon.bienestar.business.domain.dto.SedeCreditoDto;
//import co.edu.unisimon.bienestar.business.domain.persistence.entity.AreasBienestarEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.SedeCreditoEntity;

@Mapper
public interface SedeCreditoMapper {

	SedeCreditoEntity convertDtoToEntity(final SedeCreditoDto sedeCreditoDto);

	SedeCreditoDto convertEntityToDto(final SedeCreditoEntity sedeCreditoEntity);

	SedeCreditoEntity convertOptionalToEntity(final Optional<SedeCreditoEntity> optional);

	List<SedeCreditoDto> convertEntityListToDtoList(final List<SedeCreditoEntity> sedeCreditoEntities);

}
