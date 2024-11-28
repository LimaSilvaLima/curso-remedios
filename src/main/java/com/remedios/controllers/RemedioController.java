package com.remedios.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.remedios.remedio.DadosCadastroRemedio;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroRemedio dados){
        System.out.println(dados);
    }

}
