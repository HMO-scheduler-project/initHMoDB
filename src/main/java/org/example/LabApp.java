package org.example;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class LabApp extends Appointment {

    @ManyToOne(targetEntity = LabWorker.class)
    protected LabWorker labworker;

    public LabApp()
    {
        super();
    }

    public LabApp(LocalTime time, LocalDate date, Clinic clinic, Patient patient, LabWorker worker){
        super(time, date, clinic, patient,worker);
        this.labworker = worker;
    }

    public LabWorker getLabworker() {
        return labworker;
    }

    public void setLabworker(LabWorker labworker) {
        this.labworker = labworker;
    }
}
