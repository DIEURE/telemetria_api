package com.autenticatelemetria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
 
import com.autenticatelemetria.entities.Usuario;
import com.autenticatelemetria.projections.UsuarioMinProjection;

 

public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{

	
	@Query(nativeQuery = true, value = """
			SELECT * 
			FROM tb_usuarios
			INNER JOIN tb_empresa ON tb_usuarios.empresa_id = tb_empresa.id	""")
	List<UsuarioMinProjection> searchByList(Long listId);
	
}
