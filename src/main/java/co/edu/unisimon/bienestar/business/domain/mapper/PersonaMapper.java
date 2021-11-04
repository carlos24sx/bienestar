package co.edu.unisimon.bienestar.business.domain.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import co.edu.unisimon.bienestar.business.domain.dto.PersonaDto;
import co.edu.unisimon.bienestar.business.domain.dto.custom.list.PersonaListDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.PersonaEntity;

@Mapper
public interface PersonaMapper {

    PersonaDto convertEntityToDto(PersonaEntity personaEntity);

    PersonaEntity convertDtoToEntity(PersonaDto personaDto);

    List<PersonaDto> convertEntityListToDtoList(List<PersonaEntity> personaEntities);

    @Named("convertEntityToCustomDto")
    @Mappings({
            @Mapping(target = "nombreCompleto", expression = "java(" +
                    "personaEntity.getNombre().concat(\" \").concat(personaEntity.getApellido())" + ")")
    })
    PersonaListDto convertEntityToCustomDto(PersonaEntity personaEntity);

    @IterableMapping(qualifiedByName = "convertEntityToCustomDto")
    List<PersonaListDto> convertEntityListToCustomDtoList(List<PersonaEntity> personaEntities);


}
