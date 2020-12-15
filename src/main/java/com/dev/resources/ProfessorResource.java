package com.dev.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dev.domain.Professor;
import com.dev.domain.dto.ProfessorUpdateDTO;
import com.dev.services.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Professor")
@CrossOrigin
@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {
	
	@Autowired
	public ProfessorService service;
	
	@ApiOperation(value = "Buscar todos os professores cadastrados")
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		List<Professor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Buscar um professor pelo seu identificador")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> find(@PathVariable Integer id){
		Professor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value = "Cadastrar um novo professor no sistema")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody Professor obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualizar as informações de um professor específico")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ProfessorUpdateDTO objDTO, @PathVariable Integer id){
		Professor obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remover o cadastro de um professor do sistema")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}