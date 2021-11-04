package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import co.edu.unisimon.bienestar.business.domain.persistence.entity.CamposEntity;
import co.edu.unisimon.bienestar.business.domain.persistence.repository.CamposRepository;
import co.edu.unisimon.bienestar.business.domain.service.ICamposService;
import lombok.AllArgsConstructor;

@Service
@Primary
@AllArgsConstructor
public class CamposService implements ICamposService {

	@Autowired
	CamposRepository repository;
	
	
	@Override
	public List<CamposEntity> findAll() {

		return repository.findAll();
	}

	@Override
	public CamposEntity save(CamposEntity t) {

		return repository.save(t);
	}

	@Override
	public Optional<CamposEntity> findById(Long id) {

		return repository.findById(id);
	}

	@Override
	public void delete(CamposEntity t) {


	}

}
