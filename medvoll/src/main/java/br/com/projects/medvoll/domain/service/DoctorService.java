package br.com.projects.medvoll.domain.service;

import br.com.projects.medvoll.application.gateway.attendant.AttendantManager;
import br.com.projects.medvoll.application.gateway.doctor.DoctorManager;
import br.com.projects.medvoll.domain.entities.Doctor;
import br.com.projects.medvoll.enums.DoctorStatus;

public class DoctorService {

    private final AttendantManager attendantManager;

    private final DoctorManager doctorManager;

    public DoctorService(AttendantManager attendantManager, DoctorManager doctorManager) {
        this.attendantManager = attendantManager;
        this.doctorManager = doctorManager;
    }

    public Doctor createDoctor(Doctor doctor, Long attendantId) {
        attendantManager.findById(
                attendantId
        );

        doctor.setStatus(DoctorStatus.INACTIVE);

        return doctorManager.create(doctor);
    }


}
