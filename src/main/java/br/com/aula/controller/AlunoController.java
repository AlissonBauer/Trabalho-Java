package br.com.aula.controller;

import br.com.aula.model.Aluno;
import br.com.aula.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping
    public ResponseEntity<Object> salvaAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(HttpStatus.OK).body(service.gravaAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> allAlunos(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listaAlunos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> alunosCodigo(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscaAluno(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizaAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> alunoOptional = service.buscaAluno(id);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Aluno alunoExistente = alunoOptional.get();
        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setNotas(alunoAtualizado.getNotas());

        service.gravaAluno(alunoExistente);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaAluno(@PathVariable(value = "id") Long id) {
        Optional<Aluno> alunoOptional = service.buscaAluno(id);

        if (alunoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        service.deletaAluno(Optional.of(alunoOptional.get()));

        return ResponseEntity.ok().body("Aluno deletado com sucesso!");
    }

}

