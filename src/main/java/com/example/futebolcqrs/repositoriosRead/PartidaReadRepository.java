package com.example.futebolcqrs.repositoriosRead;

import com.example.futebolcqrs.entidadesRead.PartidaRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaReadRepository extends JpaRepository<PartidaRead, Long> {
}
