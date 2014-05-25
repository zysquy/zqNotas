package com.zysquy.zqnotas.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.zysquy.rest.ResponseREST;
import com.zysquy.rest.ZysquyRESTSrv;
import com.zysquy.view.message.annotations.MessageRESTInterceptor;
import com.zysquy.zqnotas.controller.EstablecimientoEducativoController;
import com.zysquy.zqnotas.entity.EstablecimientoEducativo;

@Controller
@RequestMapping("/api/establecimientos")
public class EstablecimientosEduRESTService extends ZysquyRESTSrv {
	
	@Autowired
	private EstablecimientoEducativoController admEstablecimientosEducController;
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public ResponseREST get(@PathVariable Integer id)  {
		EstablecimientoEducativo eu = new EstablecimientoEducativo();
		eu.setId(1234567890);
		return new ResponseREST(eu);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody	
	@MessageRESTInterceptor
	public ResponseREST save(@RequestBody EstablecimientoEducativo establecimientoEducativo) {		
		admEstablecimientosEducController.crearEntidadEducativa(establecimientoEducativo);
		//throw new RuntimeException("Error al proposito");
		return new ResponseREST(establecimientoEducativo);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	@MessageRESTInterceptor
	public ResponseREST list() {		
		List<EstablecimientoEducativo> establecimientos = this.admEstablecimientosEducController.recuperarEstablecimientosEducativos(null,null);
		if(establecimientos != null) {
			for (EstablecimientoEducativo ee : establecimientos) {
				ee.setPeriodosLectivos(null);
			}
		}
		//throw new RuntimeException("Error al proposito");
		return new ResponseREST(establecimientos);
	}

	@RequestMapping(method=RequestMethod.GET, value="/{page}/{pageSize}")
	@ResponseBody
	public ResponseREST list(@PathVariable Integer page, @PathVariable Integer pageSize ) {		
		List<EstablecimientoEducativo> establecimientos = this.admEstablecimientosEducController.recuperarEstablecimientosEducativos(null,null);
		if(establecimientos != null) {
			for (EstablecimientoEducativo ee : establecimientos) {
				ee.setPeriodosLectivos(null);
			}
		}
		//throw new RuntimeException("Error al proposito");
		return new ResponseREST(establecimientos);
	}
}
