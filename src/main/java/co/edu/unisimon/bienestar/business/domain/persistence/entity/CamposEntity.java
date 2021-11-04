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
@Table(name = "campos", schema = "Bienestar")
@EqualsAndHashCode
@ToString
@Entity
public class CamposEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "tipo_dato")
	private String tipo_dato;
	
	@Column(name = "html")
	private String html;
	
	@Column(name = "sede_id", nullable =false)
	private Long sede_id;
	
	@Column(name = "estado",nullable =false)
	private Integer estado;

}
