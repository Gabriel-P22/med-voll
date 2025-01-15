package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.exchange.attendant.AttendantRequest;
import br.com.projects.medvoll.application.exchange.attendant.AttendantResponse;
import br.com.projects.medvoll.application.usecases.attendant.AttendantManager;
import br.com.projects.medvoll.domain.entities.Attendant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
