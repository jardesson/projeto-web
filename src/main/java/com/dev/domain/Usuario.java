package com.dev.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuarios")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min=5, max=30, message="O tamanho deve ser entre 5 e 30 caracteres.")
	@NotEmpty(message="Preenchimento obrigatório.")
	private String matricula;
    
    @NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=3, max=50, message="O tamanho deve ser entre 3 e 50 caracteres.")
    private String nome;
    
    @Column(unique = true)
	@NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 50 caracteres.")
    private String email;
    
    @NotEmpty(message="Preenchimento obrigatório.")
	@Length(min=5, max=50, message="O tamanho deve ser entre 5 e 20 caracteres.")
	private String password;
}