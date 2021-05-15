package com.tatiana.restful.utilizador;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Utilizador {

    @Id
    @SequenceGenerator(
            name = "utilizador_sequence",
            sequenceName = "utilizador_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utilizador_sequence"
    )
    private Long identificador;
    private String email;
    private String nome;
    private LocalDate dataNascimento;

    public Utilizador(Long identificador, String email, String nome, LocalDate dataNascimento) {
        this.identificador = identificador;
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "identificador='" + identificador + '\'' +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }

    public Long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Utilizador() {
    }

    public Utilizador(String email, String nome, LocalDate dataNascimento) {
        this.email = email;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
}
