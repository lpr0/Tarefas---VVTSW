package br.ifsp.demo.tarefas;

import java.time.LocalDate;
import java.util.UUID;

public record TarefaDTO (
        UUID id,
        String titulo,
        String descricao,
        LocalDate dataInsercao,
        LocalDate dataLimite,
        int categoriaID,
        Estado estado
){}
