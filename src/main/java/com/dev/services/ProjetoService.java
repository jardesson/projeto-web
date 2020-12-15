package com.dev.services;

import java.util.List;
import java.util.Optional;

import com.dev.domain.Aluno;
import com.dev.domain.Projeto;
import com.dev.domain.dto.ProjetoUpdateDTO;
import com.dev.repository.AlunoRepository;
import com.dev.repository.ProjetoRepository;
import com.dev.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

    @Autowired
	private ProjetoRepository repo;

	@Autowired
	private AlunoService alunoService;

	@Autowired
	private AlunoRepository alunoRepository;
	
	public Projeto find(Integer id) {
		Optional<Projeto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "+id+", Tipo: "+Projeto.class.getName()));
	}
	
	public List<Projeto> findAll(){
		return repo.findAll();
	}
	
	public Projeto insert(Projeto obj) {
		Aluno aluno = alunoService.find(obj.getAlunos().get(0).getId());
		obj.setId(null);
		obj = repo.save(obj);
		aluno.setProjeto(obj);
		alunoRepository.save(aluno);
		return obj;
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
		//newObj.setAlunos(obj.getAlunos());
		newObj.addAluno(obj.getAlunos().get(0));
	}

	public Projeto fromDTO(ProjetoUpdateDTO objDTO) {
		return new Projeto(objDTO.getId(), objDTO.getNome(), objDTO.getDescricao(), objDTO.getCoordenador(), objDTO.getAlunos());
	}
}