package com.example.api_cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api_cursos.model.Curso;
import com.example.api_cursos.model.StatusCurso;
import com.example.api_cursos.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    public Curso criar(Curso curso) {
        return repository.save(curso);
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public Curso atualizar(Long id, Curso curso) {
        curso.setId(id);
        return repository.save(curso);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Curso toggleStatus(Long id) {
        Curso curso = repository.findById(id).orElseThrow();
        curso.setActive(
            curso.getActive() == StatusCurso.ATIVO ? StatusCurso.INATIVO : StatusCurso.ATIVO
        );
        return repository.save(curso);
    }
}