package com.remedios.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.remedios.remedio.DadosCadastroRemedio;
import com.remedios.remedio.DadosListagemRemedio;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroRemedio dados){
        repository.save(new Remedio (dados));
        //System.out.println(dados);
    }
    
    @GetMapping
    public List<DadosListagemRemedio> listar(){
        return repository.findAll().stream().map(DadosListagemRemedio::new).toList();
    }


}
