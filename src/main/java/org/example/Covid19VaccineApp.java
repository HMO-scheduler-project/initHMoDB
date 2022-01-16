package org.example;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class
Covid19VaccineApp extends LabApp implements Serializable {

    public Covid19VaccineApp() {
        super();
    }

    public Covid19VaccineApp(LocalTime time, LocalDate date, Clinic clinic, Patient patient, LabWorker worker) {
        super(time, date, clinic, patient, worker);
        this.type = "Covid 19 vaccine appointment";
    }

    public int getDuration() {
        return 10;
    }


    public Covid19VaccineApp(java.time.LocalTime time, java.time.LocalTime actual_time, boolean arrived, java.time.LocalDate date, Clinic clinic, org.example.Patient patient, LabWorker worker) {
        super(time, actual_time, arrived, date, clinic, "Covid 19 vaccine appointment", patient, worker);
    }
}
