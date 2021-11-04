package co.edu.unisimon.bienestar.business.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCategoriasServicioAreasDto implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long categorias_servicios_id;
	@NotNull
	private Long areas_bienestar_id;

}
