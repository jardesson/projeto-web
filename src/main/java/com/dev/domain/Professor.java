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
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres.")
	private String atuacao;
	
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 20 caracteres.")
	private String formacao;

	@JsonIgnore
	@OneToMany(mappedBy = "coordenador")
	private List<Projeto> projetos = new ArrayList<>();

	public void addProjeto(Projeto p){

        projetos.add(p);

    }
}