package com.example.futebolcqrs.entidadesRead;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JogadorRead {

    @Id
    private Long id;

    private String nome;

    private int golsMarcados = 0;

    @Deprecated
    public JogadorRead(){}

    public JogadorRead(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public JogadorRead(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public void adicionaGols(int gols) {
        this.golsMarcados += gols;
    }
}
