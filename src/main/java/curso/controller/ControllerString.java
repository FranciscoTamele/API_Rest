package curso.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/string")
public class ControllerString {
	
	
	@GetMapping("/teste1")
	public ResponseEntity<String> teste() {
		return new ResponseEntity("Resposta da minha requisicao !",HttpStatus.OK);
	}

}
