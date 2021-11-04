package co.edu.unisimon.bienestar.business.http.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisimon.bienestar.business.domain.constant.Message;
import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosDto;
import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServiciosSedeDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.CategoriasServicioMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosEntity;
import co.edu.unisimon.bienestar.business.domain.service.ICategoriasServiciosService;
import co.edu.unisimon.bienestar.common.Logger;
import co.edu.unisimon.bienestar.common.TokenUtil;
import co.edu.unisimon.bienestar.configuration.exception.BadRequestException;
import co.edu.unisimon.bienestar.configuration.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/categorias")
public class CategoriasServiciosController extends Controller {

	@Autowired
	ICategoriasServiciosService service;

	final CategoriasServicioMapper categoriasServicioMapper;

	public CategoriasServiciosController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);
		this.categoriasServicioMapper = Mappers.getMapper(CategoriasServicioMapper.class);

	}

	@GetMapping
	public ResponseDto<List<CategoriasServiciosDto>> getAllActivesCategoriasServicio() {
		List<CategoriasServiciosEntity> categoriasServiciosEntity = this.service.findAll();

		if (categoriasServiciosEntity.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}
		List<CategoriasServiciosDto> serviciosDtos = this.categoriasServicioMapper
				.convertEntityListToDtoList(categoriasServiciosEntity);

		return ResponseDto.create(serviciosDtos);
	}

	@GetMapping("/getSede")
	public ResponseDto<List<CategoriasServiciosSedeDto>> getAllActivesCategoriasServicioSede() {
		List<CategoriasServiciosSedeDto> categoriasServiciosSedeDto = this.service.findSede();

		if (categoriasServiciosSedeDto.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		return ResponseDto.create(categoriasServiciosSedeDto);
	}

	
	
	@PostMapping
	public ResponseDto<CategoriasServiciosDto> createCategoriaServicio(
			@ApiParam(value = "Objeto area bienestar a guardar", required = true) @Valid @RequestBody CategoriasServiciosDto categoriasServiciosDto,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		Logger.tracing(request);

		if (result.hasErrors()) {
			throw new BadRequestException(this.message.getBadRequest());
		}

		CategoriasServiciosEntity categoriasServiciosEntity = this.categoriasServicioMapper.convertDtoToEntity(categoriasServiciosDto);

		categoriasServiciosEntity.setEstado(1);

		categoriasServiciosEntity.setSede_id(this.tokenUtil.getSede(request));

		categoriasServiciosEntity = this.service.save(categoriasServiciosEntity);

		categoriasServiciosDto = this.categoriasServicioMapper.convertEntityToDto(categoriasServiciosEntity);

		response.setStatus(HttpServletResponse.SC_CREATED);

		return ResponseDto.create(categoriasServiciosDto);

	}
}
