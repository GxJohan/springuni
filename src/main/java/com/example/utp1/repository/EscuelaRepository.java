package com.example.utp1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.utp1.model.Escuela;

@Repository
public interface EscuelaRepository extends JpaRepository<Escuela, Long> {
}
