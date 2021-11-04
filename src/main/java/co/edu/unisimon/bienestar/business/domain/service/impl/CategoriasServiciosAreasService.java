package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosAreasEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.repository.CategoriasServiciosAreasRepository;
import co.edu.unisimon.bienestar.business.domain.service.ICategoriasServiciosAreasService;
import lombok.AllArgsConstructor;


@Service
@Primary
@AllArgsConstructor
public class CategoriasServiciosAreasService implements ICategoriasServiciosAreasService {

	
	@Autowired
	CategoriasServiciosAreasRepository repository;

	@Override
	public List<CategoriasServiciosAreasEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public CategoriasServiciosAreasEntity save(CategoriasServiciosAreasEntity t) {

		return repository.save(t);
	}

	@Override
	public Optional<CategoriasServiciosAreasEntity> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void delete(CategoriasServiciosAreasEntity t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriasServicioAreasDto> findAllCategoriasServiciosAreasActives() {

		return repository.findAllCategoriasServiciosAreasActives();
	}
	
}