package com.dev.domain;

import java.io.Serializable;

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
	
	@Length(min=5, max=30, message="O tamanho deve ser entre 5 e 30 caracteres.")
	@NotEmpty(message="Preenchimento obrigatório.")
	private String curso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "projeto_id")
	private Projeto projeto;

	private String papel;
}