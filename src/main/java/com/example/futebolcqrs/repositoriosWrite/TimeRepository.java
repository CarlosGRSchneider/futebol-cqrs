package com.example.futebolcqrs.repositoriosWrite;

import com.example.futebolcqrs.entidadesWrite.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
