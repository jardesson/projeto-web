package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Aluno;
import com.dev.repository.AlunoRepository;
import com.dev.services.exceptions.ObjectNotFoundException;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository repo;
	
	public Aluno find(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Aluno.class.getName()));
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setCurso(obj.getCurso());
	}
}