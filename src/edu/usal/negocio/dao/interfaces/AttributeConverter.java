package edu.usal.negocio.dao.interfaces;

import java.sql.Date;
import java.time.LocalDate;

public interface AttributeConverter<T1, T2> {
	public Date convertToDatabaseColumn(LocalDate localDate);
	public LocalDate convertToEntityAttribute(Date date);
}
