package co.edu.unisimon.bienestar.business.http.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisimon.bienestar.business.domain.constant.Message;
import co.edu.unisimon.bienestar.business.domain.dto.AreasBienestarDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.AreasBienestarMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.AreasBienestarEntity;
import co.edu.unisimon.bienestar.business.domain.service.IAreasBienestarService;
import co.edu.unisimon.bienestar.common.Logger;
import co.edu.unisimon.bienestar.common.TokenUtil;
import co.edu.unisimon.bienestar.configuration.exception.BadRequestException;
import co.edu.unisimon.bienestar.configuration.exception.ResourceNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/areas")
@Api(value = "Operaciones Concernientes a las Areas de Bienestar")
public class AreasBienestarController extends Controller {

	@Autowired
	private IAreasBienestarService areasBienestarService;

	private final AreasBienestarMapper areasBienestarMapper;

	public AreasBienestarController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);
		this.areasBienestarMapper = Mappers.getMapper(AreasBienestarMapper.class);
	}

	@ApiOperation(value = "Listas Areas Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = AreasBienestarDto.class, responseContainer = "List") })
	@GetMapping
	public ResponseDto<List<AreasBienestarDto>> getAreasBienestarActivas() {

		List<AreasBienestarEntity> areasBienestarEntities = this.areasBienestarService.findAll();

		if (areasBienestarEntities.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		List<AreasBienestarDto> areasBienestarDto = this.areasBienestarMapper
				.convertEntityListToDtoList(areasBienestarEntities);

		return ResponseDto.create(areasBienestarDto);

	}

	@ApiOperation(value = "Crear Objeto Areas Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Creacion exitosa", response = AreasBienestarDto.class) })
	@PostMapping
	public ResponseDto<AreasBienestarDto> crearAreaBienestar(
			@ApiParam(value = "Objeto area bienestar a guardar", required = true) @Valid @RequestBody AreasBienestarDto areaBienestarDto,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		Logger.tracing(request);

		if (result.hasErrors()) {
			throw new BadRequestException(this.message.getBadRequest());
		}

		AreasBienestarEntity areasBienestarEntity = this.areasBienestarMapper.convertDtoToEntity(areaBienestarDto);
		// obtener dato sede del token
		areasBienestarEntity.setSede_id((long) this.tokenUtil.getSede(request));
		/*
		 * obtener ip y usuario que esta creando el area
		 * areasBienestarEntity.setIp(request.getRemoteAddr());
		 * areasBienestarEntity.setUsuario(request.getUserPrincipal().getName());
		 */
		// Guardamos el Objeto Area Bienestar
		areasBienestarEntity.setEstado(1);
		areasBienestarEntity = this.areasBienestarService.save(areasBienestarEntity);

		areaBienestarDto = this.areasBienestarMapper.convertEntityToDto(areasBienestarEntity);

		response.setStatus(HttpServletResponse.SC_CREATED);

		return ResponseDto.create(areaBienestarDto);
	}

	@ApiOperation(value = "Desahabilitar Objeto areas Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Desactivacion exitosa", response = AreasBienestarDto.class) })
	@DeleteMapping("{id}")
	public ResponseEntity<AreasBienestarEntity> deshabilitarAreaBienestar(
			@ApiParam(value = "Objeto area bienestar a desactivar", required = true) @Valid @PathVariable(name = "id") Long id,
			HttpServletRequest request, HttpServletResponse response) {

		Logger.tracing(request);
		Optional<AreasBienestarEntity>optional=this.areasBienestarService.findById(id);
		
		if(optional.isEmpty()) {
			throw new ResourceNotFoundException(message.getNoFound());
		}
	
		AreasBienestarEntity areasBienestarEntity = optional.get();
		areasBienestarEntity.setEstado(0);
		areasBienestarEntity = this.areasBienestarService.save(areasBienestarEntity);
		response.setStatus(HttpServletResponse.SC_CREATED);

		return ResponseEntity.ok(areasBienestarEntity);
	}

	@ApiOperation(value = "Obtener objeto Area bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Obtenido exitosamente", response = AreasBienestarDto.class) })
	@GetMapping("/getById/{id}")
	public ResponseDto<AreasBienestarDto> getAreaById(@PathVariable(name = "id") Long id) {

		Optional<AreasBienestarEntity> optionalAreasServ = this.areasBienestarService.findById(id);

		if (optionalAreasServ.isEmpty()) {

			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		AreasBienestarDto areasBienestarDto = this.areasBienestarMapper.convertEntityToDto(optionalAreasServ.get());

		return ResponseDto.create(areasBienestarDto);
	}

}
