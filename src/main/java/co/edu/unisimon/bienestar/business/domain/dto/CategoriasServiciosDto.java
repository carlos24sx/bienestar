package co.edu.unisimon.bienestar.business.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriasServiciosDto {

	private long id;

	private String descripcion;

	private String codigo;

	private Long sede_id;

}
