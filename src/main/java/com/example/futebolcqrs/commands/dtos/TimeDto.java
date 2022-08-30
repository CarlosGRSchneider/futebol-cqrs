package com.example.futebolcqrs.commands.dtos;

import com.example.futebolcqrs.entidadesWrite.Jogador;
import com.example.futebolcqrs.entidadesWrite.Time;
import com.example.futebolcqrs.repositoriosWrite.JogadorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeDto {

    private String nome;
    private List<Long> idJogadores = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public List<Long> getIdJogadores() {
        return idJogadores;
    }

    public Time toModel(JogadorRepository repository) {

        List<Jogador> jogadores = idJogadores.stream().map(jogador -> repository.findById(jogador).orElseThrow()).collect(Collectors.toList());

        return new Time(nome, jogadores);
    }
}
