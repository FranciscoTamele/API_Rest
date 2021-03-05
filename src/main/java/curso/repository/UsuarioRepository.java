package curso.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{

	
	@Query(value="select u from Usuario u where u.contacto=?1 and u.senha=?2")
	Usuario buscarUsuario(String contacto, String senha);
}
