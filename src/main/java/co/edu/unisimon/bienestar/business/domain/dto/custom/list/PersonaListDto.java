package co.edu.unisimon.bienestar.business.domain.dto.custom.list;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaListDto implements Serializable {

    public static final String NAME = "Persona";

    private Long id;
    private String nombreCompleto;

}
