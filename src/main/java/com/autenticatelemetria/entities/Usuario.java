package com.autenticatelemetria.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.autenticatelemetria.enums.TipoAcesso;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity

@Table(name = "tb_usuarios")

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long id;

	@Column(name = "nome")
	public String nome;

	@Column(name = "email")
	public String email;

	@Column(name = "senha")
	public String senha;
	
	@ManyToOne
	@JoinColumn(name="empresa_id")
	private Empresa empresa;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tb_acesso")
	protected Set<Integer> tipo_acesso = new HashSet<>();
 
	
	public Usuario()
    
    {
    	super();
    	addAcesso(TipoAcesso.ADMIN);
    	
    }

	public Usuario(Long id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		
		addAcesso(TipoAcesso.ADMIN);
		 
				 
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		Usuario other = (Usuario) obj;
		return Objects.equals(id, other.id);
	}

	
}
