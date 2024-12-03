package com.remedios.usuarios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;

   
    
    private int ativo;
    //@NotBlank
    private String nome;
    //@NotBlank
    private String email;
    //@NotBlank
    private String cpf;
    //@NotBlank
    private String cep;
    private String uf;
    private String cidade;
    private String bairro;
    private String complemento;
    private String numero;



}
