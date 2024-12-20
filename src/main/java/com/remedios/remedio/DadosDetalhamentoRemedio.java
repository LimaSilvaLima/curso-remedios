package com.remedios.remedio;

import java.time.LocalDate;



public record DadosDetalhamentoRemedio(

    Long id, 
    String nome, 
    Via via, 
    Laboratorio laboratorio, 
    LocalDate validade,
    String lote, 
    int quantidade,
    Boolean ativo
	
) {
    
    public DadosDetalhamentoRemedio(Remedio remedio){
        this(remedio.getId(), 
        remedio.getNome(), 
        remedio.getVia(), 
        remedio.getLaboratorio(), 
        remedio.getValidade(),
		remedio.getLote(), 
        remedio.getQuantidade(),
        remedio.getAtivo());
        
    }

}
