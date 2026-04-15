package br.ifsp.demo.controller;

import br.ifsp.demo.security.auth.AuthenticationInfoService;
import br.ifsp.demo.tarefas.Estado;
import br.ifsp.demo.tarefas.TarefaDAO;
import br.ifsp.demo.tarefas.TarefaRepository;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionControllerTest {

    @Nested
    class ListarTarefastest {

        @Test
        @Tag("UnitTest")
        @Tag("Functional")
        public void seNaoHouverTarefasSalvasDeveRetornarUmaListaVazia() {
            TarefaRepository rep = mock();
            when(rep.findAll()).thenReturn(List.of());

            TransactionController sut = new TransactionController(null, null, rep);

            assertThat(sut.listarTarefas()).isEqualTo(ResponseEntity.ok(List.of()));
        }

        @Test
        @Tag("UnitTest")
        @Tag("Functional")
        public void seHouverApenasUmatarefaSalvasDeveRetornarSomenteEla() {
            List<TarefaDAO> list = List.of(new TarefaDAO(
                            UUID.randomUUID(), "teste", "testando", LocalDate.now(),
                            LocalDate.of(2026, 10, 6), 1, Estado.PENDENTE
                    ));

            TarefaRepository rep = mock();
            when(rep.findAll()).thenReturn(list);

            TransactionController sut = new TransactionController(null, null, rep);

            assertThat(sut.listarTarefas()).isEqualTo(ResponseEntity.ok(list.stream().map(TarefaDAO::toDTO).toList()));
        }

        @Test
        @Tag("UnitTest")
        @Tag("Functional")
        public void seHouverMultiplasatarefasSalvasDeveRetornarTodas() {
            List<TarefaDAO> list = List.of(new TarefaDAO(
                    UUID.randomUUID(), "teste", "testando", LocalDate.now(),
                    LocalDate.of(2026, 10, 6), 1, Estado.PENDENTE
            ), new TarefaDAO(
                    UUID.randomUUID(), "teste2", "testando2", LocalDate.now(),
                    LocalDate.of(2026, 11, 6), 2, Estado.PENDENTE
            ), new TarefaDAO(
                    UUID.randomUUID(), "teste3", "testando3", LocalDate.now(),
                    LocalDate.now(), 0, Estado.ATRASADA)
            );

            TarefaRepository rep = mock();
            when(rep.findAll()).thenReturn(list);

            TransactionController sut = new TransactionController(null, null, rep);

            assertThat(sut.listarTarefas()).isEqualTo(ResponseEntity.ok(list.stream().map(TarefaDAO::toDTO).toList()));
        }
    }

    @Nested
    class CriarTarefa {
            
    }
}
