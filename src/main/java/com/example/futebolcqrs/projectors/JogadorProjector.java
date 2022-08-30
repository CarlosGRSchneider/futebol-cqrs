package com.example.futebolcqrs.projectors;

import com.example.futebolcqrs.entidadesRead.JogadorRead;
import com.example.futebolcqrs.entidadesWrite.Jogador;
import com.example.futebolcqrs.repositoriosRead.JogadorReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorProjector implements  Projector<Jogador>{

    @Autowired
    private JogadorReadRepository repository;

    @Override
    public void project(Jogador jogador) {

        JogadorRead jogadorRead = new JogadorRead(jogador.getId(), jogador.getNome());

        repository.save(jogadorRead);
    }
}
