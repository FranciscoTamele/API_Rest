package curso.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.repository.UsuarioRepository;
import model.Usuario;

@RestController
@RequestMapping(value="/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	/*
	 * A arquitetura REST tem um modo diferente de passar variaveis, segue o modo abaixo:
	 * http://localhost:8080/5
	 * */
	
	// @GetMapping
	
	// Pegar usuario especifico
	@GetMapping(value="/{id}",produces="application/json")
	public ResponseEntity<Usuario> usuario(@PathVariable(value="id") Integer id) {
		
		try {
			
			Optional<Usuario> usuario= usuarioRepository.findById(id);
			
			Usuario usuarioR=usuario.get();
			return new ResponseEntity(usuarioR,HttpStatus.OK);
			
			
			
		}catch(NoSuchElementException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return new ResponseEntity("Dados incorretos!",HttpStatus.CONFLICT);
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return new ResponseEntity("Dados incorretos!",HttpStatus.NOT_FOUND);
		}
			
	}

	
	// Pegar todos usuarios
	@GetMapping(value="/")
	public ResponseEntity<List<Usuario>> lista(){
		
		try {
			
			List<Usuario> lista=(List<Usuario>)usuarioRepository.findAll();
			return new ResponseEntity(lista,HttpStatus.OK);
		
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return new ResponseEntity("Ocorreu um erro !",HttpStatus.CONFLICT);
		}
		
	}
	
	// @PostMapping

	// Inserir novo usuario
	/*
	 * Para inserir novo objecto enviando um arquivo json pela url so temos que nos
	 * certificarmos de que todos os atributos do objecto estao declarados com
	 * mesmos nomes que foram declarados dentro das classes.
	 * 
	 * Ex: Classe Usuario
	 * 
	 * { "id":null "userName":"francisco" "senha":"0000" }
	 * 
	 * Ao enviar dados de um objecto que nao estao completos qualquer atributo json
	 * que considir com nome do atributo da classe montara um objecto com apenas
	 * esse atributo e os outros campos estarao null.
	 * 
	 * { "id":null "userName":"Rafael" }
	 */

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Usuario> registar(@RequestBody Usuario usuario) {

		try {

			Usuario usuarioG = usuarioRepository.save(usuario);
			return new ResponseEntity(usuarioG, HttpStatus.OK);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return new ResponseEntity("Ocorreu erro ao registar", HttpStatus.CONFLICT);
		}

	}
	
	// Passando parametros numa requisicao @PostMapping
	
	@PostMapping(value="/{idUsuario}/link/{idOperacao}")
	public ResponseEntity teste(@PathVariable(value="idUsuario") Integer id,
								@PathVariable(value="idOperacao") Integer idO,@RequestBody Usuario usuario) {
		
		
		
		return new ResponseEntity("O id do usuario e "+id+" e o id da operacao e "+idO+" Usuario:"+usuario.toString(),HttpStatus.OK);
	}
	
	@PostMapping(value="/login")
	public ResponseEntity login(@RequestBody Usuario usuario) {
		
		try {
			System.out.println("Usuario recebido: "+usuario.toString());
			Usuario usuarioR=usuarioRepository.buscarUsuario(usuario.getContacto(), usuario.getSenha());
			System.out.print("Usuario apanhado: "+usuarioR.toString());
		
			return new ResponseEntity(usuarioR,HttpStatus.OK);
		
		}catch(Exception ex) {
			return new ResponseEntity("Dados errados !",HttpStatus.CONFLICT);
		}
	}
	
	// @PutMapping
	
	/*
	 * O @PutMapping segue mesma estrutura que Post, usamos o metodo .save(objecto)
	 * para actualizar o objecto, o Jpa ao receber um objecto sem id assume que e novo
	 * objecto e grava, quando tem um id actualiza.
	 * 
	 * O metodo anota com @PutMapping pode ser personalizado como o metodo com a
	 * anotacao @PostMapping acima.
	 * 
	 */
	@PutMapping(value="/", produces="application/json")
	public ResponseEntity actualizar(@RequestBody Usuario usuario) {
		
		try {
			
			Usuario usuarioA=usuarioRepository.save(usuario);
			return new ResponseEntity(usuarioA,HttpStatus.OK);
		
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.print(ex.getMessage());
			return new ResponseEntity("Ocorreu erro!",HttpStatus.CONFLICT);
		}
	}
	
	// @DeleteMapping
	
	@DeleteMapping(value="/{idUsuario}", produces="application/text")
	public ResponseEntity deletar(@PathVariable(value="idUsuario") Integer id) {
		
		try {
			
			usuarioRepository.deleteById(id);
			return new ResponseEntity("Deletado com sucesso !",HttpStatus.OK);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
			return new ResponseEntity("Ocorreu erro !",HttpStatus.CONFLICT);
		}
	}
	
	
	@GetMapping(value="/testeP")
	public void testeQueryPersonalizada() {
		
//		Usuario usuario=usuarioRepository.buscarUsuario("francisco", "0000");
//		System.out.println(usuario.toString());
		
	}
	
}
