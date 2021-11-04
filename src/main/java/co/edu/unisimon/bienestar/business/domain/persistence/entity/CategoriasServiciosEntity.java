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
@EqualsAndHashCode
@Table(name = "categorias_servicios", schema = "Bienestar")
@ToString
public class CategoriasServiciosEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nombre", nullable = false)
	@NotNull
	private String codigo;

	@Column(name = "descripcion", nullable = false)
	@NotNull
	private String descripcion;

	@Column(name = "sede_id", nullable = false)
	private Long sede_id;

	@NotNull
	@Column(name = "estado", nullable = false)
	private Integer estado;
	
}
