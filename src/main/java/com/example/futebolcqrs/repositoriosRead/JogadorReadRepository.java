package com.example.futebolcqrs.repositoriosRead;

import com.example.futebolcqrs.entidadesRead.JogadorRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JogadorReadRepository extends JpaRepository<JogadorRead, Long> {

    @Query(value = "select * from jogador_read where gols_marcados <> 0 order by gols_marcados desc", nativeQuery = true)
    List<JogadorRead> findByGolsMarcadosDesc();

    Optional<JogadorRead> findByNome(String nome);
}
