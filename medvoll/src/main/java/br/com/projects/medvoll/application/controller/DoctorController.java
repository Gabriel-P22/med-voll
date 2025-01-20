package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.dto.doctor.DoctorRequest;
import br.com.projects.medvoll.application.dto.doctor.DoctorResponse;
import br.com.projects.medvoll.domain.mapper.DoctorMapper;
import br.com.projects.medvoll.domain.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService service;

    private final DoctorMapper mapper;

    public DoctorController(DoctorService service, DoctorMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    ResponseEntity<DoctorResponse> createDoctor(
            @RequestHeader Long attendantId,
            @RequestBody DoctorRequest dto
    ) {
        DoctorResponse response = mapper.toResponse(
                service.createDoctor(
                        mapper.toDomain(dto),
                        attendantId
                )
        );

        var uri = UriComponentsBuilder
                .fromUriString("")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
