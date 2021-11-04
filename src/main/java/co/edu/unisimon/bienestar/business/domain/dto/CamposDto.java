package co.edu.unisimon.bienestar.business.domain.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CamposDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nombre;

	private String tipo_dato;

	private String html;

}
