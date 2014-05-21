package com.zysquy.zqnotas.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zysquy.zqnotas.entity.EstablecimientoEducativo;
import com.zysquy.zqnotas.logic.administracion.AdmEstablecimientosEduc;


@Controller
public class EstablecimientoEducativoController {

	@Autowired
	private AdmEstablecimientosEduc administradorEstablecimientosEducativos;
	
	public void crearEntidadEducativa(EstablecimientoEducativo establecimientoEducativo) {
		this.administradorEstablecimientosEducativos.crear(establecimientoEducativo);
	}
	
	public List<EstablecimientoEducativo> recuperarEstablecimientosEducativos(Integer page, Integer sizePage) {
		return this.administradorEstablecimientosEducativos.obtenerTodos(null, null);
	}
}
