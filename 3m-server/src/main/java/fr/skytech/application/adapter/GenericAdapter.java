package fr.skytech.application.adapter;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

public class GenericAdapter<DTO, MODEL> {

	private final Class<DTO> dtoClass;
	private final Class<MODEL> modelClass;
	private Converter<Date, String> dateConverter;

	public GenericAdapter(final Class<DTO> dto, final Class<MODEL> model) {
		this.dtoClass = dto;
		this.modelClass = model;
		final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		this.dateConverter = new AbstractConverter<Date, String>() {
			@Override
			protected String convert(final Date source) {
				return source == null ? null : " tolo";
			}
		};
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
		modelMapper.addConverter(this.dateConverter);
		final Type targetListType = new TypeToken<List<MODEL>>() {
		}.getType();
		return modelMapper.map(models, targetListType);
	}

	public DTO modelToDto(final MODEL model) {
		final ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(this.dateConverter);
		final DTO userDto = modelMapper.map(model, this.dtoClass);
		return userDto;
	}

}
