package com.hw.repository;

import com.hw.model.Temporizador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemporizadorRepository extends JpaRepository<Temporizador, Long> {
}

