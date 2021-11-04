
package co.edu.unisimon.bienestar.business.http.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisimon.bienestar.business.domain.constant.Message;
import co.edu.unisimon.bienestar.business.domain.dto.ServiciosBienestarDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.ServiciosBienestarMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.ServiciosBienestarEntity;
import co.edu.unisimon.bienestar.business.domain.service.IServiciosBienestarService;
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
@RequestMapping("/serviciosBienestar")
@Api(value = "Operaciones Concernientes a Servicios Bienestar")
public class ServiciosBienestarController extends Controller {

	@Autowired
	IServiciosBienestarService service;

	final ServiciosBienestarMapper mapper;

	public ServiciosBienestarController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);
		this.mapper = Mappers.getMapper(ServiciosBienestarMapper.class);

	}

	@ApiOperation(value = "Listar Servicios Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = ServiciosBienestarDto.class, responseContainer = "List") })
	@GetMapping("/servicios")
	public ResponseDto<List<ServiciosBienestarDto>> getAllServiciosBienestarActives() {

		List<ServiciosBienestarDto> serviciosBienestarDtos = this.mapper.convertEntityListToDto(this.service.findAll());

		if (serviciosBienestarDtos.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		return ResponseDto.create(serviciosBienestarDtos);
	}

	@ApiOperation(value = "Buscar Un Servicio Bienestar por Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "obtenido exitosamente", response = ServiciosBienestarDto.class) })
	@GetMapping("/servicios/{id}")
	public ResponseDto<ServiciosBienestarDto> getOneServicioBienestar(
			@Valid @PathVariable(name = "id", required = true) Long id) {

		Optional<ServiciosBienestarEntity> serviciosBienestarEntity = this.service.findById(id);
		if (serviciosBienestarEntity.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}
		ServiciosBienestarDto serviciosBienestarDto = this.mapper.convertEntityToDto(serviciosBienestarEntity.get());

		return ResponseDto.create(serviciosBienestarDto);
	}

	@ApiOperation(value = "Crear Servicios/SubServicios  ")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "obtenido exitosamente", response = ServiciosBienestarDto.class) })
	@PostMapping
	public ResponseDto<ServiciosBienestarDto> createServicioBienestar(
			@ApiParam(value = "Objeto area bienestar a Guardar", required = true) @Valid @RequestBody ServiciosBienestarDto serviciosBienestarDto,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {
		Logger.tracing(request);

		if (result.hasErrors()) {
			throw new BadRequestException(this.message.getBadRequest());

		}

		ServiciosBienestarEntity serviciosBienestarEntity = this.mapper.convertDtoToEntity(serviciosBienestarDto);

		serviciosBienestarEntity.setSede_id(this.tokenUtil.getSede(request));

		serviciosBienestarEntity.setEstado(1);

		serviciosBienestarEntity = this.service.save(serviciosBienestarEntity);

		serviciosBienestarDto = this.mapper.convertEntityToDto(serviciosBienestarEntity);

		response.setStatus(HttpServletResponse.SC_CREATED);

		return ResponseDto.create(serviciosBienestarDto);
	}
	
	@ApiOperation(value = "Listar los SubServicios de un Servicio Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "obtenido exitosamente", response = ServiciosBienestarDto.class, responseContainer = "List") })
	@GetMapping("/servicios/subServicios/{id}")
	public ResponseDto<List<ServiciosBienestarDto>> listarTodosLosSubServiciosDeUnServicioPorId(
			@Valid @PathVariable(name = "id", required = true) Long id) {

		List<ServiciosBienestarEntity> serviciosBienestarEntity = this.service.listarTodosLosSubServiciosDeUnServicio(id);
		if (serviciosBienestarEntity.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}
		List<ServiciosBienestarDto> serviciosBienestarDto = this.mapper.convertEntityListToDto(serviciosBienestarEntity);

		return ResponseDto.create(serviciosBienestarDto);
	}
	
	

	//Metodos relacionados a subServicios
	

	@ApiOperation(value = "Listar Sub Servicios Bienestar")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = ServiciosBienestarDto.class, responseContainer = "List") })
	@GetMapping(value = "/subServicios")
	public ResponseDto<List<ServiciosBienestarDto>> getAllSubServiciosBienestarActives() {

		List<ServiciosBienestarDto> serviciosBienestarDtos = this.mapper.convertEntityListToDto(this.service.findAllSubServicios());

		if (serviciosBienestarDtos.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		
		
		return ResponseDto.create(serviciosBienestarDtos);
	}
	
	@ApiOperation(value = "Buscar Un SubServicio Bienestar por Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "obtenido exitosamente", response = ServiciosBienestarDto.class) })
	@GetMapping("/subServicios/{id}")
	public ResponseDto<ServiciosBienestarDto> getOneSubServicioBienestar(
			@Valid @PathVariable(name = "id", required = true) Long id) {

		Optional<ServiciosBienestarEntity> serviciosBienestarEntity = this.service.findSubServicioById(id);
		if (serviciosBienestarEntity.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}
		ServiciosBienestarDto serviciosBienestarDto = this.mapper.convertEntityToDto(serviciosBienestarEntity.get());

		return ResponseDto.create(serviciosBienestarDto);
	}
	
	
	
}
