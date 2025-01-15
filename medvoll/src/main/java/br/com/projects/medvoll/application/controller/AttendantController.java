package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.exchange.attendant.AttendantRequest;
import br.com.projects.medvoll.application.exchange.attendant.AttendantResponse;
import br.com.projects.medvoll.application.usecases.attendant.AttendantManager;
import br.com.projects.medvoll.domain.entities.Attendant;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendant")
public class AttendantController {

    private final AttendantManager attendantManager;

    public AttendantController(AttendantManager attendantManager) {
        this.attendantManager = attendantManager;
    }

    @PostMapping
    ResponseEntity<AttendantResponse> create(@RequestBody AttendantRequest body) {
        var attendant = attendantManager.create(
                new Attendant(body.name(), body.cpf(), body.email(), body.password()));

        return ResponseEntity.ok(
                new AttendantResponse(
                        attendant.getName(),
                        attendant.getEmail(),
                        attendant.getId()
                )
        );
    }

    @GetMapping("/{cpf}")
    ResponseEntity<AttendantResponse> findByCpf(@PathVariable String cpf) {

        var attendant = attendantManager.findByCpf(cpf);

        return ResponseEntity.ok(
                new AttendantResponse(
                        attendant.getName(),
                        attendant.getEmail(),
                        attendant.getId()
                )
        );
    }

    @DeleteMapping
    ResponseEntity<Void> delete(@RequestParam String cpf) {
        attendantManager.delete(cpf);
        return ResponseEntity.noContent().build();
    }

}
