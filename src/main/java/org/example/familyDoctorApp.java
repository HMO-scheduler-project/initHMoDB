package org.example;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class familyDoctorApp extends doctorApp{

    public familyDoctorApp() {
        super();
    }

    public familyDoctorApp(LocalTime time, LocalDate date, Clinic clinic, Patient patient, Doctor doctor) {
        super(time, date, clinic, patient, doctor);
    }


    public int getDuration(){
        return 15;
    }
}