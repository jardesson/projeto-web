package com.dev.services;

import java.util.List;

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
		Aluno obj = repo.getById(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Aluno.class.getName());
		}
		return obj;
	}
	
	public List<Aluno> findAll(){
		return repo.getAll();
	}
	
	public Aluno insert(Aluno obj) {
		return repo.create(obj);
	}
	
	public Aluno update(Aluno obj) {
		Aluno aluno = repo.update(obj);
		if(aluno == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+obj.getId()+", Tipo: "+Aluno.class.getName());
		}
		return obj;
	}
	
	public void delete(Integer id) {
		Aluno obj = repo.delete(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Aluno.class.getName());
		}
	}
}