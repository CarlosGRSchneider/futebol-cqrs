package com.example.futebolcqrs.repositoriosRead;

import com.example.futebolcqrs.entidadesRead.TimeRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeReadRepository extends JpaRepository<TimeRead, Long> {
}
