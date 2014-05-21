package com.zysquy.zqnotas.logic.administracion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zysquy.zqnotas.entity.EstablecimientoEducativo;
import com.zysquy.zqnotas.entity.persistence.EstablecimientoEducativoRepository;

@Service
@Transactional
public class AdmEstablecimientosEduc implements IAdmEstablecimientosEduc {

	@Autowired
	private EstablecimientoEducativoRepository establecimientoEducativoRepository;
	
	@Override
	public EstablecimientoEducativo crear(EstablecimientoEducativo establecimientoEducativo) {
		this.establecimientoEducativoRepository.save(establecimientoEducativo);
		return establecimientoEducativo;
	}

	@Override
	public List<EstablecimientoEducativo> obtenerTodos(Integer page, Integer sizePage) {
		boolean withPagination = true;
		if( page == null || sizePage == null || page == 0 || sizePage == 0 ) {
			withPagination = false;
		}
		List<EstablecimientoEducativo> establecimientosEducativos = null;
		Sort sort = new Sort("razonSocial");
		if( !withPagination ) {		
			establecimientosEducativos = this.establecimientoEducativoRepository.findAll(sort);
		} else {						
			establecimientosEducativos = this.establecimientoEducativoRepository.findAll(new PageRequest(page, sizePage,sort)).getContent();
		}
		return establecimientosEducativos;
	}


	
	
}
