package com.dev.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "professores")
public class Professor extends Usuario{
	
	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String atuacao;
	
	private String formacao;

	@JsonIgnore
	@OneToMany(mappedBy = "coordenador")
	private List<Projeto> projetos = new ArrayList<>();

	public void addProjeto(Projeto p){

        projetos.add(p);

	}

	public Professor(Integer id, String matricula, String nome, String email, String password, String atuacao, String formacao, List<Projeto> projetos) {
		super(id, matricula, nome, email, password);
		this.atuacao = atuacao;
		this.formacao = formacao;
		this.projetos = projetos;
	}


	
}