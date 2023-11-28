package br.com.aula.service;

import br.com.aula.dto.BoletimDTO;
import br.com.aula.model.Aluno;
import br.com.aula.model.Curso;
import br.com.aula.model.Disciplina;
import br.com.aula.repository.AlunoRepository;
import br.com.aula.repository.CursoRepository;
import br.com.aula.repository.DisciplinaRepository;
import br.com.aula.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoletimService {
    @Autowired
    private NotaRepository notaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<BoletimDTO> gerarBoletim(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        List<Curso> cursos = cursoRepository.findByAlunoId(aluno.getId());

        return cursos.stream()
                .flatMap(curso -> curso.getDisciplinas().stream()
                        .map(disciplina -> criarBoletimDTO(aluno, curso, disciplina)))
                .collect(Collectors.toList());
    }

    private BoletimDTO criarBoletimDTO(Aluno aluno, Curso curso, Disciplina disciplina) {
        String status = disciplina.getNota() >= 7 ? "APROVADO" : "REPROVADO";

        return new BoletimDTO(
                aluno.getNome(),
                curso.getNome(),
                disciplina.getNome(),
                disciplina.getNota(),
                status
        );
    }
}


