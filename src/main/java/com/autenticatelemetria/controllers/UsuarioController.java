package com.autenticatelemetria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autenticatelemetria.DTO.UsuarioMinDTO;
import com.autenticatelemetria.services.UsuarioService;

 
@RestController
@RequestMapping(value= "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@Transactional(readOnly = true)
	@GetMapping(value = "/{id}")
	public UsuarioMinDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	
	@GetMapping
	public List<UsuarioMinDTO> findAll() {
		List<UsuarioMinDTO> result = service.findByAll();
		return result;
	}
	
	
	
 
	 
	 
	
}
