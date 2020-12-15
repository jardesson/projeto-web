package com.dev.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "alunos")
public class Aluno extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	@Length(min=4, max=30, message="O tamanho deve ser entre 4 e 30 caracteres.")
	@NotEmpty(message="Preenchimento obrigatório.")
	private String curso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	private String papel;

	public Aluno(Integer id, String matricula, String nome, String email, String password, String curso, Projeto projeto, String papel) {
		super(id, matricula, nome, email, password);
		this.curso = curso;
		this.projeto = projeto;
		this.papel = papel;
	}

	
}