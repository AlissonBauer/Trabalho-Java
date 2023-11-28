package br.com.aula.repository;

import br.com.aula.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    public List<Curso> findByAlunoId(Long alunoId);



}
