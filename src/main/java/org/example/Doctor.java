package org.example;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor extends Employee {
    @OneToMany(targetEntity = Patient.class)
    protected List<Patient> patientList = new ArrayList<Patient>();

    public Doctor(String username, String password, String first_name, String last_name, String role, String card,
                  String email, String phone_num, String main_clinic, int room_num, LocalTime start,LocalTime end) throws NoSuchAlgorithmException {
        super(username, password,first_name,last_name,role,card,email,phone_num,main_clinic,room_num,start,end);

    }
    public Doctor() {
        super();
        this.patientList = null;
    }

    public void addPatient(Patient patient){
        this.patientList.add(patient);
    }

    public void removePatient(Patient patient){
        this.patientList.remove(patient);
    }

}
