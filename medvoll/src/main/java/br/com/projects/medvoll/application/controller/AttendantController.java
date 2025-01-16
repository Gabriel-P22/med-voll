package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.dto.attendant.AttendantRequest;
import br.com.projects.medvoll.application.dto.attendant.AttendantResponse;
import br.com.projects.medvoll.application.gateway.attendant.AttendantManager;
import br.com.projects.medvoll.domain.mapper.AttendantMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
    private final AttendantMapper mapper;

    public AttendantController(AttendantManager attendantManager, AttendantMapper mapper) {
        this.attendantManager = attendantManager;
        this.mapper = mapper;
    }

    @PostMapping
    ResponseEntity<AttendantResponse> create(@RequestBody AttendantRequest body) {
        var attendant = attendantManager.create(mapper.toDomain(body));

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

    @PatchMapping("/{cpf}")
    ResponseEntity<AttendantResponse> update(
            @PathVariable String cpf,
            @RequestBody AttendantRequest body) {

        var attendant = attendantManager.update(cpf, mapper.toDomain(body));

        return ResponseEntity.ok().body(
                new AttendantResponse(
                        attendant.getName(),
                        attendant.getEmail(),
                        attendant.getId()
                )
        );
    }

}
