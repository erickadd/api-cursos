package com.example.api_cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api_cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}