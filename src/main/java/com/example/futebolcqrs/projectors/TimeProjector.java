package com.example.futebolcqrs.projectors;

import com.example.futebolcqrs.entidadesRead.JogadorRead;
import com.example.futebolcqrs.entidadesRead.TimeRead;
import com.example.futebolcqrs.entidadesWrite.Time;
import com.example.futebolcqrs.repositoriosRead.JogadorReadRepository;
import com.example.futebolcqrs.repositoriosRead.TimeReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeProjector implements Projector<Time> {

    @Autowired
    private TimeReadRepository repository;

    @Autowired
    private JogadorReadRepository jogadorRepository;

    @Override
    public void project(Time time) {

        List<JogadorRead> jogadores = time.getJogadores().stream()
                .map(jogador -> jogadorRepository.findById(jogador.getId()).get())
                .collect(Collectors.toList());

        TimeRead timeRead = new TimeRead(time.getId(), time.getNome(), jogadores);
        repository.save(timeRead);

    }
}
