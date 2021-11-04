package co.edu.unisimon.bienestar.business.domain.persistence.entity;

import java.io.Serializable;
import java.util.Date;

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
@Entity
@Table(name="sede",schema = "BD_USB.credito")
@ToString
@EqualsAndHashCode
public class SedeCreditoEntity implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "ip")
	private String ip;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "fecha_cambio")
	private Date fecha_cambio;
	
	@Column(name = "estado")
	private Integer estado;
	
	@Column(name = "codigo")
	private String codigo;
	
	
}
