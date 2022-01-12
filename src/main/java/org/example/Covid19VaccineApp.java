package org.example;

import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Covid19VaccineApp extends LabApp implements Serializable {

    public Covid19VaccineApp(){ super(); }

    public Covid19VaccineApp(LocalTime time, LocalDate date, Clinic clinic, Patient patient, LabWorker worker) {
        super(time, date, clinic, patient, worker);
        this.type = "Covid 19 vaccine appointment";
    }

    public int getDuration(){
        return 10;
    }
}
