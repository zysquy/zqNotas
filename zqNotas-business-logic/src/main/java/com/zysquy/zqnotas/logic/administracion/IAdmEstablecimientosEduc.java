package com.zysquy.zqnotas.logic.administracion;

import java.util.List;

import com.zysquy.zqnotas.entity.EstablecimientoEducativo;

public interface IAdmEstablecimientosEduc {
	
	public abstract EstablecimientoEducativo crear(EstablecimientoEducativo establecimientoEducativo);
	
	
	public abstract List<EstablecimientoEducativo> obtenerTodos(Integer page, Integer sizePage);
	
}
