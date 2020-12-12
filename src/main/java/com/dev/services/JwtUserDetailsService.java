package com.dev.services;

import java.util.ArrayList;

import com.dev.domain.Aluno;
import com.dev.repository.AlunoRepository;
import com.dev.repository.ProfessorRepository;
import com.dev.domain.Professor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ProfessorRepository profRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Aluno aluno = alunoRepository.findByEmail(email);
		Professor prof = profRepository.findByEmail(email);
		
		if (aluno != null && aluno.getEmail().equals(email)) {
			return new User(email, aluno.getPassword(), new ArrayList<>());
		}
		if (prof != null && prof.getEmail().equals(email)) {
			return new User(email, prof.getPassword(), new ArrayList<>());
		}
		
		throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
	}

}