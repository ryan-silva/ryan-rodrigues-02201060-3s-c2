package br.com.bandtec.ac02.controller;

import br.com.bandtec.ac02.entity.Lutador;
import br.com.bandtec.ac02.repository.LutadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;


    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador(){
        return ResponseEntity.status(200).body(repository.findByOrderByForcaGolpeDesc());
    }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getVivos(){
        return ResponseEntity.status(200).body(repository.findAllVivos());
    }

    @GetMapping("/mortos")
    public ResponseEntity getMortos(){
        return ResponseEntity.status(200).body(repository.findByVidaEquals(0.0));
    }

}
