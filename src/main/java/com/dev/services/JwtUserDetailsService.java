package com.dev.services;

import java.util.ArrayList;

import com.dev.domain.Aluno;
import com.dev.repository.AlunoRepository;

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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Aluno user = alunoRepository.findByEmail(email);

		if (user.getEmail().equals(email)) {
			return new User(email, user.getPassword(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Aluno não encontrado com o email: " + email);
		}
	}
}