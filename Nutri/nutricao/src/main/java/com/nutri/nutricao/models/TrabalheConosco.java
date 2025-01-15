package com.nutri.nutricao.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "trabalhe_conosco")
public class TrabalheConosco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome completo é obrigatório.")
    @Size(max = 100)
    private String nome;

    @NotEmpty(message = "O CPF é obrigatório.")
    @Size(min = 1, max = 14)
    private String cpf;

    @NotNull(message = "A idade é obrigatória.")
    private Integer idade;

    @NotEmpty(message = "A nacionalidade é obrigatória.")
    @Size(max = 50)
    private String nacionalidade;

    @NotEmpty(message = "O telefone é obrigatório.")
    @Size(max = 15)
    private String telefone;

    @NotEmpty(message = "O email é obrigatório.")
    @Email(message = "Por favor, insira um email válido.")
    @Size(max = 100)
    private String email;

    @NotEmpty(message = "A experiência é obrigatória.")
    private String experiencia;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    
}
