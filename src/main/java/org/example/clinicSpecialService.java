package org.example;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
public class clinicSpecialService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int service_id;
    protected String service;
    protected String clinic;
    protected LocalTime start;
    protected LocalTime end;

    public clinicSpecialService(String service, String clinic, LocalTime start, LocalTime end) {
        this.service = service;
        this.clinic = clinic;
        this.start = start;
        this.end = end;
    }

    public clinicSpecialService() {

    }

    public int getService_id() {
        return service_id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getClinic() {
        return clinic;
    }

    public void setClinic(String clinic) {
        this.clinic = clinic;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }
}
