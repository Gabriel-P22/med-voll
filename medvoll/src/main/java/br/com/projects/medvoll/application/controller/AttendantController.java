package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.exchange.attendant.Attendant;
import br.com.projects.medvoll.application.exchange.attendant.AttendantResponse;
import br.com.projects.medvoll.application.usecases.attendant.CreateAttendant;
import br.com.projects.medvoll.domain.builder.AttendantBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendant")
public class AttendantController {

    private final CreateAttendant createAttendant;

    public AttendantController(CreateAttendant createAttendant) {
        this.createAttendant = createAttendant;
    }

    @PostMapping
    ResponseEntity<AttendantResponse> create(@RequestBody Attendant body) {
        var attendant = createAttendant.create(
                new AttendantBuilder().create(
                        body.name(),
                        body.cpf(),
                        body.email(),
                        body.password()
                )
        );

        return ResponseEntity.ok(
                new AttendantResponse(
                        attendant.getName(),
                        attendant.getEmail(),
                        attendant.getName() // We need to replace to ID
                )
        );
    }

}
