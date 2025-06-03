package com.autenticatelemetria.DTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.autenticatelemetria.entities.Usuario;
import com.autenticatelemetria.enums.TipoAcesso;
import com.autenticatelemetria.projections.UsuarioMinProjection;

public class UsuarioMinDTO {

	private Long id;
	private String email;
	private String nome;
	private Set<Integer> tipo_acesso = new HashSet<>();

	public UsuarioMinDTO() {
		addAcesso(TipoAcesso.ADMIN);
	}

	public UsuarioMinDTO(Usuario entity) {
		id = entity.getId();
		email = entity.getEmail();
		nome = entity.getNome();
		tipo_acesso = entity.getTipoAcesso().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());

		addAcesso(TipoAcesso.ADMIN);

	}
	
	  public UsuarioMinDTO(UsuarioMinProjection projection) {
			
			id = projection.getId();
			email = projection.getEmail();
			nome = projection.getNome();
					}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<TipoAcesso> getTipoAcesso() {
		return tipo_acesso.stream().map(x -> TipoAcesso.toEnum(x)).collect(Collectors.toSet());
	}

	public void addAcesso(TipoAcesso tipoAcesso) {
		this.tipo_acesso.add(tipoAcesso.getCodigo());
	}	 

	public void setTipoAcesso(Set<Integer> tipo_acesso) {
		this.tipo_acesso = tipo_acesso;
	} 

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioMinDTO other = (UsuarioMinDTO) obj;
		return Objects.equals(id, other.id);
	}

}
