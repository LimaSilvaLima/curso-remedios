package com.remedios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.remedios.remedio.DadosCadastroRemedio;
import com.remedios.remedio.Remedio;
import com.remedios.remedio.RemedioRepository;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    RemedioRepository repository;

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados){
        repository.save(new Remedio (dados));
        //System.out.println(dados);
    }

}
