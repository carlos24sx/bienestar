package co.edu.unisimon.bienestar.business.domain.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "categorias_servicio_areas", schema = "Bienestar")
@EqualsAndHashCode
@ToString
public class CategoriasServiciosAreasEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "categorias_servicios_id", nullable = false)
	private Long categorias_servicios_id;

	@NotNull
	@Column(name = "areas_bienestar_id", nullable = false)
	private Long areas_bienestar_id;

	@Column(name = "sede_id", nullable = false)
	private Long sede_id;

	@Column(name = "estado", nullable = false)
	private Integer estado;

}
