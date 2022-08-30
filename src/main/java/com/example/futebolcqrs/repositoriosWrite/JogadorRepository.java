package com.example.futebolcqrs.repositoriosWrite;

import com.example.futebolcqrs.entidadesWrite.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {

}
