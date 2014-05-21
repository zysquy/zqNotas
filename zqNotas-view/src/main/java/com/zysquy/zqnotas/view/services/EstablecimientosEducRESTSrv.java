package com.zysquy.zqnotas.view.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zysquy.zqnotas.entity.EstablecimientoEducativo;
import com.zysquy.zqnotas.view.controller.AdmEstablecimientosEduController;

@Controller
@RequestMapping("/establecimientos")
public class EstablecimientosEducRESTSrv {
	
	@Autowired
	private AdmEstablecimientosEduController admEstablecimientosEducController;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody	
	public EstablecimientoEducativo crear(@RequestBody EstablecimientoEducativo establecimientoEducativo) {
		admEstablecimientosEducController.crearEntidadEducativa(establecimientoEducativo);
		return establecimientoEducativo;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EstablecimientoEducativo> list() {		
		List<EstablecimientoEducativo> establecimientos = this.admEstablecimientosEducController.recuperarEstablecimientosEducativos(null,null);
		if(establecimientos != null) {
			for (EstablecimientoEducativo ee : establecimientos) {
				ee.setPeriodosLectivos(null);
			}
		}
		throw new RuntimeException("Error al proposito");
		//return establecimientos;
	}

}