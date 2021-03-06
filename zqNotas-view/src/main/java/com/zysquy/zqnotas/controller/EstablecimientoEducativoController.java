package com.zysquy.zqnotas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zysquy.view.message.MessageBeanModel;
import com.zysquy.zqnotas.entity.EstablecimientoEducativo;
import com.zysquy.zqnotas.logic.administracion.IAdmEstablecimientosEduc;



@Controller
public class EstablecimientoEducativoController {

  @Autowired
  private MessageBeanModel messageModel;
  
	@Autowired
	private IAdmEstablecimientosEduc administradorEstablecimientosEducativos;
	
	public void crearEntidadEducativa(EstablecimientoEducativo establecimientoEducativo) {
		this.administradorEstablecimientosEducativos.crear(establecimientoEducativo);
		this.messageModel.addInfoMessage("establecimiento.educativo.creado");
	}
	
	public List<EstablecimientoEducativo> recuperarEstablecimientosEducativos(Integer page, Integer sizePage) {
		return this.administradorEstablecimientosEducativos.obtenerTodos(null, null);
	}

  public MessageBeanModel getMessageModel() {
    return messageModel;
  }

  public void setMessageModel(MessageBeanModel messageModel) {
    this.messageModel = messageModel;
  }
	
	
}
