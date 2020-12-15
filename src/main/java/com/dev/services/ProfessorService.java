package com.dev.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.domain.Professor;
import com.dev.domain.dto.ProfessorNewDTO;
import com.dev.domain.dto.ProfessorUpdateDTO;
import com.dev.repository.ProfessorRepository;
import com.dev.services.exceptions.ObjectNotFoundException;

@Service
public class ProfessorService{
	
	@Autowired
	private ProfessorRepository repo;
	
	public Professor find(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Professor.class.getName()));
	}
	
	public List<Professor> findAll(){
		return repo.findAll();
	}
	
	public Professor insert(Professor obj) {
		obj.setId(null);
		obj.setProjetos(null);
		return repo.save(obj);
	}
	
	public Professor update(Professor obj) {
		Professor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);
	}
	
	private void updateData(Professor newObj, Professor obj) {
		newObj.setNome(obj.getNome());
		newObj.setMatricula(obj.getMatricula());
		newObj.setEmail(obj.getEmail());
		newObj.setPassword(obj.getPassword());
		newObj.setAtuacao(obj.getAtuacao());
		newObj.setFormacao(obj.getFormacao());
		newObj.setProjetos(obj.getProjetos());
		//newObj.addProjeto(obj.getProjetos().get(0));

	}

	public Professor fromDTO(ProfessorUpdateDTO objDTO) {
		return new Professor(objDTO.getId(), objDTO.getMatricula() ,objDTO.getNome(), objDTO.getEmail(), 
							objDTO.getPassword(), objDTO.getAtuacao(),  objDTO.getFormacao(), objDTO.getProjetos());
	}

	public Professor fromDTO2(ProfessorNewDTO objDTO) {
		return new Professor(objDTO.getId(), objDTO.getMatricula() ,objDTO.getNome(), objDTO.getEmail(), 
							objDTO.getPassword(), objDTO.getAtuacao(),  objDTO.getFormacao(), objDTO.getProjetos());
	}
}