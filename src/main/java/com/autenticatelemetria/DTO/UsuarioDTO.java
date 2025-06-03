package com.autenticatelemetria.DTO;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.autenticatelemetria.entities.Usuario;
import com.autenticatelemetria.enums.TipoAcesso;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private Set<Integer> tipo_acesso = new HashSet<>();

	public UsuarioDTO() {
		addAcesso(TipoAcesso.ADMIN);
	}

	public UsuarioDTO(Usuario entity) {
		id = entity.getId();
		email = entity.getEmail();
		nome = entity.getNome();
		senha = entity.getSenha();
		tipo_acesso = entity.getTipoAcesso().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());

		addAcesso(TipoAcesso.ADMIN);

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
	
	

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(id, other.id);
	}

}
