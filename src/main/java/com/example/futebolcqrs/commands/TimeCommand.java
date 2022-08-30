package com.example.futebolcqrs.commands;

import com.example.futebolcqrs.commands.dtos.TimeDto;
import com.example.futebolcqrs.entidadesWrite.Time;
import com.example.futebolcqrs.projectors.TimeProjector;
import com.example.futebolcqrs.repositoriosWrite.JogadorRepository;
import com.example.futebolcqrs.repositoriosWrite.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/times/write")
public class TimeCommand {

    @Autowired
    private TimeRepository repository;

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private TimeProjector projector;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastraTime(@RequestBody TimeDto timeDto) {

        Time time = timeDto.toModel(jogadorRepository);

        repository.save(time);
        projector.project(time);

    }
}
