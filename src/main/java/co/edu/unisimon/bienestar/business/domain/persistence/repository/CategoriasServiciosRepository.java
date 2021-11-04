package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosSedeDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosEntity;

@Repository
public interface CategoriasServiciosRepository extends JpaRepository<CategoriasServiciosEntity, Long> {


	@Query(value = "select t.nombre as categoria, "
			+ "t.descripcion as descripcion,t.sede_id as sedeId, "
			+ "s.nombre as nombre, s.codigo as codigoSede "
			+ "from BD_TI_PRUEBAS_BIENESTAR.Bienestar.categorias_servicios t "
			+ "inner join BD_USB.credito.sede s on t.sede_id=s.id", nativeQuery = true)
	public List<CategoriasServiciosSedeDto> obtenerTodasLasCategoriasServiciosSedes();

	@Query("select t from CategoriasServiciosEntity t where t.estado=1")
	public List<CategoriasServiciosEntity> findAllActives();
}
