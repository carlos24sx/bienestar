package co.edu.unisimon.bienestar.business.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiciosBienestarDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private Long categorias_servicio_areas_id;
	
	private Long servicio_padre_id;
	
}
