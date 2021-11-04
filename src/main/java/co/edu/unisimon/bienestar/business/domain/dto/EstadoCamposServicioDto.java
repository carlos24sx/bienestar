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
public class EstadoCamposServicioDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private Long servicios_bienestar_id;
	
	private Long campos_id;
	
	private Long estado_campos;

}
