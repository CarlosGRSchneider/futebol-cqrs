package com.example.futebolcqrs.repositoriosWrite;

import com.example.futebolcqrs.entidadesWrite.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
