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
import co.edu.unisimon.bienestar.business.domain.dto.PostCategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.dto.CategoriasServicioAreasDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.CategoriasServicioAreasMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CategoriasServiciosAreasEntity;
import co.edu.unisimon.bienestar.business.domain.service.ICategoriasServiciosAreasService;
import co.edu.unisimon.bienestar.common.Logger;
import co.edu.unisimon.bienestar.common.TokenUtil;
import co.edu.unisimon.bienestar.configuration.exception.BadRequestException;
import co.edu.unisimon.bienestar.configuration.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/categoriasServiciosAreas")
@Api(value = "Operaciones concernientes a la tabla CategoriasServiciosAreas")
public class CategoriasServiciosAreasController extends Controller {

	@Autowired
	ICategoriasServiciosAreasService service;

	final CategoriasServicioAreasMapper mapper;

	public CategoriasServiciosAreasController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);

		this.mapper = Mappers.getMapper(CategoriasServicioAreasMapper.class);
	}

	@ApiOperation(value = "Listar Categorias Servicios Areas Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = CategoriasServiciosAreasEntity.class, responseContainer = "List") })
	@GetMapping
	public ResponseDto<List<CategoriasServiciosAreasEntity>> getAllCategoriasServiciosAreas() {

		List<CategoriasServiciosAreasEntity> categoriasServiciosAreasEntities = this.service.findAll();

		if (categoriasServiciosAreasEntities.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		return ResponseDto.create(categoriasServiciosAreasEntities);
	}

	@ApiOperation(value = "Listar Categorias Servicios Areas Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = CategoriasServicioAreasDto.class, responseContainer = "List") })
	@GetMapping("/actives")
	public ResponseDto<List<CategoriasServicioAreasDto>> getAllCategoriasServiciosAreasActives() {

		List<CategoriasServicioAreasDto> categoriasServicioAreasDtos = this.service.findAllCategoriasServiciosAreasActives();

		if (categoriasServicioAreasDtos.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}


		return ResponseDto.create(categoriasServicioAreasDtos);
	}

	@PostMapping
	public ResponseDto<PostCategoriasServicioAreasDto> createOneCategoriaServiciosAreas(
			@Valid @RequestBody PostCategoriasServicioAreasDto categoriasServiciosAreasDto, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		Logger.tracing(request);

		if (result.hasErrors()) {
			throw new BadRequestException(this.message.getBadRequest());
		}

		CategoriasServiciosAreasEntity categoriasServiciosAreasEntity = this.mapper.convertDtoToEntity(categoriasServiciosAreasDto);

		categoriasServiciosAreasEntity.setSede_id(this.tokenUtil.getSede(request));

		categoriasServiciosAreasEntity.setEstado(1);

		categoriasServiciosAreasEntity = this.service.save(categoriasServiciosAreasEntity);

		categoriasServiciosAreasDto = this.mapper.convertEntityToDto(categoriasServiciosAreasEntity);

		return ResponseDto.create(categoriasServiciosAreasDto);
	}

}
