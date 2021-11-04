package co.edu.unisimon.bienestar.business.http.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unisimon.bienestar.business.domain.constant.Message;
import co.edu.unisimon.bienestar.business.domain.dto.EstadoCamposServicioDto;
import co.edu.unisimon.bienestar.business.domain.dto.HabilitarODeshabilitarDto;
import co.edu.unisimon.bienestar.business.domain.dto.util.ResponseDto;
import co.edu.unisimon.bienestar.business.domain.mapper.EstadoCamposServicioMapper;
import co.edu.unisimon.bienestar.business.domain.persistence.entity.EstadoCamposServicioEntity;
import co.edu.unisimon.bienestar.business.domain.service.IEstadoCamposServicioService;
import co.edu.unisimon.bienestar.common.Logger;
import co.edu.unisimon.bienestar.common.TokenUtil;
import co.edu.unisimon.bienestar.configuration.exception.BadRequestException;
import co.edu.unisimon.bienestar.configuration.exception.ResourceNotFoundException;

@RequestMapping("/estadoCampos")
@RestController
public class EstadoCamposServicioController extends Controller {

	@Autowired
	IEstadoCamposServicioService service;

	final EstadoCamposServicioMapper mapper;

	public EstadoCamposServicioController(Message message, TokenUtil tokenUtil) {
		super(message, tokenUtil);

		this.mapper = Mappers.getMapper(EstadoCamposServicioMapper.class);

	}

	@PostMapping
	public ResponseDto<EstadoCamposServicioDto> asignarCamposAUnServicio(
			@Valid @RequestBody EstadoCamposServicioDto camposServicioDto, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {
		Logger.tracing(request);

		if (result.hasErrors()) {
			throw new BadRequestException(this.message.getBadRequest());
		}

		EstadoCamposServicioEntity camposServicioEntity = this.mapper.convertDtoToEntity(camposServicioDto);

		camposServicioEntity.setSede_id(this.tokenUtil.getSede(request));

		camposServicioEntity.setEstado(1);

		camposServicioEntity = this.service.save(camposServicioEntity);

		camposServicioDto = this.mapper.convertEnityToDto(camposServicioEntity);

		return ResponseDto.create(camposServicioDto);
	}

	@PutMapping
	public ResponseDto<EstadoCamposServicioDto> habilitaroDesahbilitarCamposAUnServicio(
			@Valid @RequestBody HabilitarODeshabilitarDto accion, HttpServletRequest request,
			HttpServletResponse response) {
		Logger.tracing(request);

		Optional<EstadoCamposServicioEntity> optional = this.service.findById(accion.getId());

		if (optional.isEmpty()) {
			throw new ResourceNotFoundException(this.message.getNoFound());
		}
		EstadoCamposServicioEntity camposServicioEntity = optional.get();

		switch (accion.getTipo()) {
		case 1:

			camposServicioEntity.setEstado(1);

			camposServicioEntity.setEstado_campos(1);

			break;
		case 2:
			camposServicioEntity.setEstado(0);

			camposServicioEntity.setEstado_campos(0);
			break;
		default:
			throw new BadRequestException(this.message.getBadRequest());
		}

		camposServicioEntity = this.service.save(camposServicioEntity);
		
		EstadoCamposServicioDto camposServicioDto = this.mapper.convertEnityToDto(camposServicioEntity);

		return ResponseDto.create(camposServicioDto);
	}

}
