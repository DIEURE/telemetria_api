package com.autenticatelemetria.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_empresa")
public class Empresa  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 
	private Long id;
	
 	private String fantasia;
 	
 	@OneToMany(mappedBy = "empresa")
 	private List<Usuario> usuarios;
	
	public Empresa() {}

	public Empresa(Long id, String fantasia) {
		super();
		this.id = id;
		this.fantasia = fantasia;
	}

	public Empresa(Empresa entity) {

		id = entity.getId();
		fantasia = entity.getFantasia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
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
		Empresa other = (Empresa) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", fantasia=" + fantasia + "]";
	}
}

	 