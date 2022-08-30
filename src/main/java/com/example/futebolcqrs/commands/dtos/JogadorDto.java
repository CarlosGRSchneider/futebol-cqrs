package com.example.futebolcqrs.commands.dtos;


import com.example.futebolcqrs.entidadesWrite.Jogador;

public class JogadorDto {

    private String nome;

    public String getNome() {
        return nome;
    }

    public Jogador toModel() {
        return new Jogador(nome);
    }
}
