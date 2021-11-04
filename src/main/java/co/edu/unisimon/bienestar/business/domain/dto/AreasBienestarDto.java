package co.edu.unisimon.bienestar.business.domain.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AreasBienestarDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	private String nombre;

	private Long sede_id;

	@NotNull
	private String descripcion;

}
