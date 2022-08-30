package com.example.futebolcqrs.queries;

import com.example.futebolcqrs.entidadesRead.PartidaRead;
import com.example.futebolcqrs.repositoriosRead.PartidaReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidas/read")
public class PartidaQuery {

    @Autowired
    private PartidaReadRepository repository;

    @GetMapping
    public ResponseEntity<List<PartidaRead>> getAllPartidas() {
        List<PartidaRead> partidas = repository.findAll();

        return ResponseEntity.ok().body(partidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidaRead> getPartidaPorId(@PathVariable Long id) {

        Optional<PartidaRead> partida = repository.findById(id);

        if (partida.isPresent()) {
            return ResponseEntity.ok().body(partida.get());
        }

        return ResponseEntity.notFound().build();
    }
}
