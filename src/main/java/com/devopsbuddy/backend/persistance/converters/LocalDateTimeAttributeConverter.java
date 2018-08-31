package com.devopsbuddy.backend.persistance.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * 
 * @author munga
 *
 */
@Converter
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp>{

	/**
	 * 
	 */
	@Override
	public Timestamp convertToDatabaseColumn(LocalDateTime localDateTime) {
		return (localDateTime == null ? null : Timestamp.valueOf(localDateTime));
	}

	/**
	 * 
	 */
	@Override
	public LocalDateTime convertToEntityAttribute(Timestamp sqlTimeStamp) {
		return (sqlTimeStamp == null ?  null : sqlTimeStamp.toLocalDateTime());
	}
}
