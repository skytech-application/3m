package fr.skytech.application.adapter;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class GenericAdapter<DTO, MODEL> {

	private final Class<DTO> dtoClass;
	private final Class<MODEL> modelClass;

	public GenericAdapter(final Class<DTO> dto, final Class<MODEL> model) {
		this.dtoClass = dto;
		this.modelClass = model;
	}

	public List<MODEL> dtosToModels(final List<DTO> dtos) {
		final ModelMapper modelMapper = new ModelMapper();
		final Type targetListType = new TypeToken<List<DTO>>() {
		}.getType();

		return modelMapper.map(dtos, targetListType);
	}

	public MODEL dtoToModel(final DTO dto) {
		final ModelMapper modelMapper = new ModelMapper();
		final MODEL user = modelMapper.map(dto, this.modelClass);
		return user;
	}

	public List<DTO> modelsToDtos(final List<MODEL> models) {
		final ModelMapper modelMapper = new ModelMapper();
		final Type targetListType = new TypeToken<List<MODEL>>() {
		}.getType();
		return modelMapper.map(models, targetListType);
	}

	public DTO modelToDto(final MODEL model) {
		final ModelMapper modelMapper = new ModelMapper();
		final DTO userDto = modelMapper.map(model, this.dtoClass);
		return userDto;
	}

}
