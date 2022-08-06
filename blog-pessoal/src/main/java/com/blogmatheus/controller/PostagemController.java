package com.blogmatheus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogmatheus.model.Postagem;
import com.blogmatheus.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens") // solicita o acesso à página de postagens
@CrossOrigin(origins = "*", allowedHeaders = "*")

	public class PostagemController {
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){ // busca a informação
		return ResponseEntity.ok(postagemRepository.findAll()); // retorna a informação
		
}
	@GetMapping ("/{id}") // solicita o acesso à página de postagens de maneira filtrada (id)
	public ResponseEntity<Postagem> getById(@PathVariable Long id){
		return postagemRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
		
	}
				

}
