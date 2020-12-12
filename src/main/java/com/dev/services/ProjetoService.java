package com.dev.services;

import java.util.List;
import java.util.Optional;

import com.dev.domain.Projeto;
import com.dev.repository.ProjetoRepository;
import com.dev.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
	private ProjetoRepository repo;
	
	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Projeto.class.getName()));
	}
	
	public List<Projeto> findAll(){
		return repo.findAll();
	}
	
	public Projeto insert(Projeto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Projeto update(Projeto obj) {
		Projeto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Projeto newObj, Projeto obj) {
        newObj.setNome(obj.getNome());
        newObj.setDescricao(obj.getDescricao());
        newObj.setCoordenador(obj.getCoordenador());
        newObj.setAlunos(obj.getAlunos());
	}
}