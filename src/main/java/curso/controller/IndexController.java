package curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Usuario;

@RestController // Arquitetura REST
//@RequestMapping(value="/usuario")
public class IndexController {
	
	// Vai dar reposta para nossa requisicao;
	// Servico RESTFULL
	
//	@GetMapping(value="/", produces="application/json")
//	public ResponseEntity init() {
//		return new ResponseEntity("Primeira reposta a requisicao !",HttpStatus.OK);
//	}

//	@GetMapping(value="/users",produces="application/json")
//	public ResponseEntity<Usuario> inits() {
//		
//		List<Usuario> list=new ArrayList();
//		
//		return new ResponseEntity(list,HttpStatus.OK);
//	}
	
	
	// Passando parametros para requisicao
	
	/*
	 * A anotacao @RequestParam contem varios atributos
	 * value="nome" - nome da variavel passado pela url.
	 * Ex:http://localhost:8080/?nome=Francisco
	 * 
	 * defaultValue="" - define o valor que sera atribuido a variavel 
	 * 					 nome caso o usuario nao passe o valor
	 * 
	 * required=true/false - Define a obrigatoriedade de atribuir o valor
	 */
	
	
	@GetMapping(value="/",produces="application/json")	
	
//	Um parametro	
//	public ResponseEntity init(@RequestParam(value="nome",defaultValue="Joao" ) String nome){
	
	
//  Mais de um parametro
	public ResponseEntity init(@RequestParam(value="nome",defaultValue="Joao" ) String nome,@RequestParam(value="idade") short idade){
		return new ResponseEntity("Nome inserido e :"+nome+" com idade de "+idade+" anos" ,HttpStatus.OK);
	}
}
