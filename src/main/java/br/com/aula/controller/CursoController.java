package br.com.aula.controller;

import br.com.aula.model.Curso;
import br.com.aula.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService service;

    public CursoController(CursoService service) {
        this.service = service;
    }

//    @GetMapping()
//    public ResponseEntity<List<Produto>> listaCursos(){
//        return ResponseEntity.status(HttpStatus.OK).body(service.listaCursos());
//    }

    @PostMapping()
    public void cadastrarCursoParaAluno(@RequestBody Curso curso, @RequestParam("aluno_id") Long alunoId) {
        service.gravarCurso(curso, alunoId);
    }

}
