package br.com.aula.service;

import br.com.aula.model.Aluno;
import br.com.aula.model.Curso;
import br.com.aula.repository.AlunoRepository;
import br.com.aula.repository.CursoRepository;
import br.com.aula.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Curso> listaCursos() {
        return repository.findAll();
    }

    public Curso gravarCurso(Curso curso, Long alunoId) {
        Optional<Aluno> opAluno = alunoRepository.findById(alunoId);

        if (opAluno.isPresent()) {
            Aluno aluno = opAluno.get();
            curso.setAluno(aluno);

            // Salvando o curso antes para obter o ID gerado
            Curso cursoGravado = repository.save(curso);

            // Associando o curso às disciplinas e salvando as disciplinas
            curso.getDisciplinas().forEach(disciplina -> {
                disciplina.setCurso(cursoGravado);
            });
            disciplinaRepository.saveAll(curso.getDisciplinas());

            return cursoGravado;
        } else {
            throw new RuntimeException("Aluno não encontrado pelo ID: " + alunoId);
        }
    }
}
