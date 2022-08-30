package com.example.futebolcqrs.commands;

import com.example.futebolcqrs.commands.dtos.PartidaDto;
import com.example.futebolcqrs.entidadesWrite.Partida;
import com.example.futebolcqrs.projectors.PartidaProjector;
import com.example.futebolcqrs.repositoriosWrite.JogadorRepository;
import com.example.futebolcqrs.repositoriosWrite.PartidaRepository;
import com.example.futebolcqrs.repositoriosWrite.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/partidas/write")
public class PartidaCommand {

    @Autowired
    private PartidaRepository repository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PartidaProjector projector;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraPartida(@RequestBody PartidaDto partidaDto) {
        Partida partida = partidaDto.toModel(timeRepository);

        repository.save(partida);
        projector.project(partida);

    }
}
