package co.edu.unisimon.bienestar.business.domain.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "estado_campos_servicio",schema = "Bienestar")
@EqualsAndHashCode
@ToString
@Entity
public class EstadoCamposServicioEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "servicios_bienestar_id")
	private Long servicios_bienestar_id;
	
	@Column(name = "campos_id")
	private Long campos_id;
	
	@Column(name = "estado_campos")
	private Integer estado_campos;
	
	@Column(name = "sede_id")
	private Long sede_id;
	
	@Column(name = "estado")
	private Integer estado;
	
	
}
