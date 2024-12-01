package com.remedios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.remedio.DadosAtualizarRemedio;
import com.remedios.remedio.DadosCadastroRemedio;
import com.remedios.remedio.DadosListagemRemedio;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){
        repository.save(new Remedio (dados));
        
    }
    
    @GetMapping
    public List<DadosListagemRemedio> listar(){
        return repository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar (@RequestBody  @Valid DadosAtualizarRemedio dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
        
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.inativar();
        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public void reativar(@PathVariable Long id){
        var remedio = repository.getReferenceById(id);
        remedio.reativar();
    }


 
    


}
