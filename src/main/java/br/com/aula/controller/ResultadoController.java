package br.com.aula.controller;

import br.com.aula.dto.BoletimDTO;
import br.com.aula.service.BoletimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resultados")
public class ResultadoController {
    @Autowired
    private BoletimService boletimService;

    @GetMapping("/{alunoId}/boletim")
    public ResponseEntity<List<BoletimDTO>> obterBoletim(@PathVariable Long alunoId) {
        List<BoletimDTO> boletim = boletimService.gerarBoletim(alunoId);
        return ResponseEntity.ok().body(boletim);
    }
    @GetMapping("/")
    public ResponseEntity<String> endpointNaoEncontrado() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Endpoint não encontrado");
    }

}
