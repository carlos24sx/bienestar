package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosSedeDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.repository.CategoriasServiciosRepository;
import co.edu.unisimon.bienestar.business.domain.service.ICategoriasServiciosService;
import lombok.AllArgsConstructor;

@Primary
@Service
@AllArgsConstructor
public class CategoriasServiciosService implements ICategoriasServiciosService {

	@Autowired
	CategoriasServiciosRepository repository;

	@Transactional(readOnly = true)
	@Override
	public List<CategoriasServiciosEntity> findAll() {

		return repository.findAllActives();
	}

	@Override
	public CategoriasServiciosEntity save(CategoriasServiciosEntity t) {

		return repository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<CategoriasServiciosEntity> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void delete(CategoriasServiciosEntity t) {

	}

	@Transactional(readOnly = true)
	@Override
	public List<CategoriasServiciosSedeDto> findSede() {

		return (List<CategoriasServiciosSedeDto>) repository.obtenerTodasLasCategoriasServiciosSedes();
	}

}
