package br.ifsp.demo.categorias;

import br.ifsp.demo.tarefas.categorias.Categoria;
import br.ifsp.demo.tarefas.categorias.CategoriaDAO;
import br.ifsp.demo.tarefas.categorias.Categorias;
import br.ifsp.demo.tarefas.categorias.CategoriaRepository;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CategoriasTest {

    @ParameterizedTest
    @Tag("UnitTest")
    @Tag("TDD")
    @CsvSource({
            "0", "1", "2"
    })
    public void deveRetornarAInstanciaDaCategoria(Integer id) {
        CategoriaRepository rep = mock();
        when(rep.findById(id)).thenReturn(Optional.of(
                new CategoriaDAO(id, "teste" + id.toString(), "Testando " + id.toString())));

        Categorias cats = new Categorias(rep);

        assertThat(cats.getCategoria(id))
                .isNotNull()
                .isInstanceOf(Categoria.class);
    }


    @ParameterizedTest
    @Tag("UnitTest")
    @Tag("TDD")
    @CsvSource({
            "0, 2", "1, 1", "2, 3"
    })
    public void deveRetornarSempreAMesmaInstanciaDaCadaCategoria(Integer id, int repet) {

        CategoriaRepository rep = mock();
        when(rep.findById(id)).thenReturn(Optional.of(
                new CategoriaDAO(id, "teste" + id.toString(), "Testando " + id.toString())));

        Categorias cats = new Categorias(rep);

        Categoria categoria = cats.getCategoria(id);

        for (int I = 0; I < repet; I++) {
            assertThat(cats.getCategoria(id)).isSameAs(categoria);
        }
    }

}
