package br.ifsp.demo;

import br.ifsp.demo.tarefas.categorias.Categoria;
import br.ifsp.demo.tarefas.categorias.CategoriaDAO;
import br.ifsp.demo.tarefas.categorias.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class Tarefas {

    public static void main(String[] args) {
        SpringApplication.run(Tarefas.class, args);
    }

    public Tarefas(CategoriaRepository categoriaRepository) {
        categoriaRepository.save(new CategoriaDAO
                (0, "Domestica", "Limpeza e cuidados com a casa"));
        categoriaRepository.save(new CategoriaDAO
                (1, "Estudos", "Relacionadas à faculdade, escola, curso etc"));
        categoriaRepository.save(new CategoriaDAO
                (2, "Trabalho", "Coisas do trabalho que deveriam ficar no trabalho"));
    }

}
