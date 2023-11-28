package br.com.aula.service;

import br.com.aula.model.Aluno;
import br.com.aula.model.Curso;
import br.com.aula.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public Aluno gravaAluno(Aluno aluno) {
        if (aluno.getCursos() != null && !aluno.getCursos().isEmpty()) {
            aluno.getCursos().forEach(curso -> curso.setAluno(aluno));
        }
        return repository.save(aluno);
    }


    public Optional<Aluno> buscaAluno(Long id){
        return repository.findById(id);
    }

    public List<Aluno> listaAlunos(){
        return repository.findAll();
    }

    public void deletaAluno(Optional<Aluno> alunoOptional) {
        alunoOptional.ifPresent(repository::delete);
    }

}


