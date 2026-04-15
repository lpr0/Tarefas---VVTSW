package br.ifsp.demo.controller;

import br.ifsp.demo.security.auth.AuthenticationInfoService;
import br.ifsp.demo.tarefas.HIDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/tarefas")
@CrossOrigin
@AllArgsConstructor
@Tag(name = "Tarefas")
public class TransactionController {

    private final AuthenticationInfoService authService;

    @GetMapping
    public ResponseEntity<String> HI() {
        final UUID userId = authService.getAuthenticatedUserId();
        return ResponseEntity.ok(userId.toString());
    }
}
