package br.ifsp.demo.controller;

import br.ifsp.demo.tarefas.Estado;

import java.time.LocalDate;
import java.util.UUID;

public record CriarTarefaDTO (
        String titulo,
        String descricao,
        LocalDate dataLimite,
        int categoriaID
){
}
