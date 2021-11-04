package co.edu.unisimon.bienestar.business.domain.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosAreasEntity;

@Repository
public interface CategoriasServiciosAreasRepository extends JpaRepository<CategoriasServiciosAreasEntity, Long>{

	
	@Query(value="SELECT ta.id as id ,a.nombre as areaBienestar , t.nombre as categoriaServicio, s.codigo as sede FROM BD_TI_PRUEBAS_BIENESTAR.Bienestar.areas_bienestar a INNER JOIN BD_TI_PRUEBAS_BIENESTAR.Bienestar.categorias_servicio_areas ta ON a.id=ta.areas_bienestar_id INNER JOIN BD_TI_PRUEBAS_BIENESTAR.Bienestar.categorias_servicios t ON ta.categorias_servicios_id=t.id INNER JOIN BD_USB.credito.sede s ON ta.sede_id=s.id where ta.estado=1",nativeQuery = true)
	public List<CategoriasServicioAreasDto> findAllCategoriasServiciosAreasActives();
	
	
	
	
}
