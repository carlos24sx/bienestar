package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.ServiciosBienestarEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.repository.ServiciosBienestarRespository;
import co.edu.unisimon.bienestar.business.domain.service.IServiciosBienestarService;
import lombok.AllArgsConstructor;

@Primary
@Service
@AllArgsConstructor
public class ServiciosBienestarService implements IServiciosBienestarService {

	@Autowired
	ServiciosBienestarRespository repository;
	
	
	@Override
	public List<ServiciosBienestarEntity> findAll() {

		return repository.findAll() ;
	}

	@Override
	public ServiciosBienestarEntity save(ServiciosBienestarEntity t) {

		return repository.save(t);
	}

	@Override
	public Optional<ServiciosBienestarEntity> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void delete(ServiciosBienestarEntity t) {


	}

	@Override
	public List<ServiciosBienestarEntity> findAllSubServicios() {

		return repository.findAllSubServicios();
	}

	@Override
	public Optional<ServiciosBienestarEntity> findSubServicioById(Long id) {

		return repository.findSubServicioById(id);
	}

	@Override
	public List<ServiciosBienestarEntity> listarTodosLosSubServiciosDeUnServicio(Long id) {

		return repository.listarTodosLosSubServiciosDeUnServicio(id);
	}

}
