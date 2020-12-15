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

import com.dev.domain.Projeto;
import com.dev.domain.dto.ProjetoNewDTO;
import com.dev.domain.dto.ProjetoUpdateDTO;
import com.dev.services.ProjetoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Projeto")
@CrossOrigin
@RestController
@RequestMapping(value = "/projetos")
public class ProjetoResource {
	
	@Autowired
	public ProjetoService service;
	
	@ApiOperation(value = "Buscar todos os Projetoes cadastrados")
	@GetMapping
	public ResponseEntity<List<Projeto>> findAll(){
		List<Projeto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@ApiOperation(value = "Buscar um Projeto pelo seu identificador")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Projeto> find(@PathVariable Integer id){
		Projeto obj = service.find(id);
		return ResponseEntity.ok().body(obj);
    }
    
	
	@ApiOperation(value = "Cadastrar um novo Projeto no sistema")
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody ProjetoNewDTO objDTO){
		Projeto obj = service.fromDTO2(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value = "Atualizar as informações de um Projeto específico")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Void> update(@Valid @RequestBody ProjetoUpdateDTO objDTO, @PathVariable Integer id){
		Projeto obj = service.fromDTO(objDTO);
		obj.setId(id);
		service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Remover o cadastro de um Projeto do sistema")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}