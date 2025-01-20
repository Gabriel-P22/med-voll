package br.com.projects.medvoll.application.controller;

import br.com.projects.medvoll.application.dto.doctor.DoctorRequest;
import br.com.projects.medvoll.application.dto.doctor.DoctorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @PostMapping
    ResponseEntity<DoctorResponse> createDoctor(
            @RequestHeader String attendantId,
            @RequestBody DoctorRequest dto
    ) {
        return null;
    }
}
