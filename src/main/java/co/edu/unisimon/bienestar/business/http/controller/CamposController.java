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
import co.edu.unisimon.bienestar.business.domain.dto.CamposDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.CamposMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.CamposEntity;
import co.edu.unisimon.bienestar.business.domain.service.ICamposService;
import co.edu.unisimon.bienestar.common.Logger;
import co.edu.unisimon.bienestar.common.TokenUtil;
import co.edu.unisimon.bienestar.configuration.exception.BadRequestException;
import co.edu.unisimon.bienestar.configuration.exception.ResourceNotFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/campos")
public class CamposController extends Controller {

	@Autowired
	ICamposService service;

	final CamposMapper mapper;

	public CamposController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);

		this.mapper = Mappers.getMapper(CamposMapper.class);

	}
	@ApiOperation(value = "Listar Campos Activos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listado obtenido exitosamente", response = CamposDto.class, responseContainer = "List") })
	@GetMapping
	public ResponseDto<List<CamposDto>> findAllCamposEnabled() {

		List<CamposEntity> camposEntities = this.service.findAll();
		if (camposEntities.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}

		List<CamposDto> camposDtos = this.mapper.convertEntityListToDtoList(camposEntities);
		return ResponseDto.create(camposDtos);
	}

	@ApiOperation(value = "Crear Objeto Campo")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Creacion exitosa", response = CamposDto.class) })
	@PostMapping
	public ResponseDto<CamposDto> createNewCampos(
			@ApiParam(value = "Objeto campo a guardar", required = true) @Valid @RequestBody CamposDto camposDto,
			BindingResult result, HttpServletRequest request, HttpServletResponse response) {

		Logger.tracing(request);

		if (result.hasErrors()) {

			throw new BadRequestException(this.message.getBadRequest());
		}
		CamposEntity camposEntity = this.mapper.convertDtoToEntity(camposDto);

		camposEntity.setSede_id(this.tokenUtil.getSede(request));

		camposEntity.setEstado(1);

		camposEntity = this.service.save(camposEntity);

		camposDto = this.mapper.convertEnityToDto(camposEntity);

		response.setStatus(HttpServletResponse.SC_CREATED);

		return ResponseDto.create(camposDto);
	}

}
