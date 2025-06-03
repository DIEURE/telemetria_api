package com.autenticatelemetria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autenticatelemetria.DTO.UsuarioMinDTO;
import com.autenticatelemetria.entities.Usuario;
import com.autenticatelemetria.projections.UsuarioMinProjection;
import com.autenticatelemetria.repositories.UsuarioRepository;

@Service
public class UsuarioService  {

	@Autowired
	public UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public UsuarioMinDTO findById(Long id) {
				
		Usuario entity  = repository.findById(id).get();
		UsuarioMinDTO dto = new UsuarioMinDTO(entity);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<UsuarioMinDTO> findByAll() {
		List<Usuario> result = repository.findAll();		
		return result.stream().map(UsuarioMinDTO::new).toList();
	}
	
 
	
	  @Transactional(readOnly = true) 
	  public List<UsuarioMinDTO> findByUsuarioList(Long listId) { 
		  List<UsuarioMinProjection> games =  repository.searchByList(listId);
		  return  games.stream().map(UsuarioMinDTO::new).toList();}
	 
	
}
