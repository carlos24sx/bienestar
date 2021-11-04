package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.EstadoCamposServicioEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.repository.EstadoCamposServicioRepository;
import co.edu.unisimon.bienestar.business.domain.service.IEstadoCamposServicioService;
import lombok.AllArgsConstructor;
@Service
@Primary
@AllArgsConstructor
public class EstadoCamposServicioService implements IEstadoCamposServicioService {

	@Autowired
	EstadoCamposServicioRepository repository;
	
	@Override
	public List<EstadoCamposServicioEntity> findAll() {

	return repository.findAll();
	}

	@Override
	public EstadoCamposServicioEntity save(EstadoCamposServicioEntity t) {

		return repository.save(t);
	}

	@Override
	public Optional<EstadoCamposServicioEntity> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void delete(EstadoCamposServicioEntity t) {


	}

}
