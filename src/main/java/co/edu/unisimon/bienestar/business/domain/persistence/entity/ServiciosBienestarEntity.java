package co.edu.unisimon.bienestar.business.domain.persistence.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Table(name = "servicios_bienestar", schema = "Bienestar")
@EqualsAndHashCode
@ToString
@Entity
public class ServiciosBienestarEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@CreationTimestamp
	@Column(name = "fecha_creacion", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP", nullable = false)
	private LocalDateTime fechaCreacion;

	@Column(name = "descripcion", nullable = true)
	private String descripcion;

	@Column(name = "sede_id", nullable = false)
	private Long sede_id;

	@Column(name = "categorias_servicio_areas_id", nullable = false)
	private Long categorias_servicio_areas_id;

	@Column(name = "estado", nullable = false)
	private Integer estado;
	
	@Column(name = "servicio_padre_id", nullable = false)
	private Long servicio_padre_id;
}
