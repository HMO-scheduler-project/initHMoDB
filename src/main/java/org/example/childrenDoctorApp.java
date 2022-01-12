package org.example;


import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class childrenDoctorApp extends doctorApp{


    public childrenDoctorApp() {
        super();
    }

    public childrenDoctorApp(LocalTime time, LocalDate date, Clinic clinic, Patient patient, Doctor doctor) {
        super(time, date, clinic, patient, doctor);
        setType("Children doctor appointment");
    }


    public int getDuration(){
        return 15;
    }
}