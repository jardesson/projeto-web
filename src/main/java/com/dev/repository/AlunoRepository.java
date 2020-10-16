package com.dev.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.dev.domain.Aluno;

@Repository
public class AlunoRepository {

	private static HashMap<Integer, Aluno> alunos = new HashMap<>();
    private static Integer nextID = 0;

    public List<Aluno> getAll(){
        return new ArrayList<Aluno>(alunos.values());
    }

    public Aluno getById(Integer id){
        return alunos.get(id);
    }

    public Aluno create(Aluno aluno){
        aluno.setId(generateId());
        alunos.put(aluno.getId(), aluno);
        return aluno;
    }

    public Aluno update(Aluno aluno){
    	Aluno obj = getById(aluno.getId());
    	if(obj != null) {
    		alunos.remove(aluno.getId());
            alunos.put(aluno.getId(), aluno);
            obj = aluno;
    	}
        return obj;
    }

    public Aluno delete(Integer id){
    	Aluno obj = getById(id);
    	if(obj != null) {
    		alunos.remove(id);
    	}
    	return obj;
    }
    
    private Integer generateId(){
        return nextID++;
    }
}