package org.example;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class HMO_Manager extends Manager {
    @OneToMany(targetEntity = AwaitingTimeRep.class)
    protected List<AwaitingTimeRep> awaitingTimeRep = new ArrayList<AwaitingTimeRep>();
    @OneToMany(targetEntity = MissedAppRep.class)
    protected List<MissedAppRep> missedAppRep = new ArrayList<MissedAppRep>();
    @OneToMany(targetEntity = ServicesTypeRep.class)
    protected List<ServicesTypeRep> servicesTypeRep = new ArrayList<ServicesTypeRep>();


    public HMO_Manager(String username, String password, String first_name, String last_name, String card, String Email, String phone_num, String main_clinic, List<Clinic> managing_clinics, int room_num, LocalTime start,LocalTime end) throws NoSuchAlgorithmException {
        super(username, password,first_name,last_name,"HMO_Manager",card,Email,phone_num,main_clinic,managing_clinics,room_num,start,end);
    }

    public HMO_Manager() {
        super();
    }

    public String getFullName(){
        return getFirstName()+getLastName();
    }

    public List<Clinic> getManaging_clinics() {
        return managing_clinics;
    }

    public void setManaging_clinics(List<Clinic> managing_clinics) {
        this.managing_clinics = managing_clinics;
    }

    public void addClinic(Clinic clinic){
        managing_clinics.add(clinic);
    }

    public List<AwaitingTimeRep> getAwaitingTimeRep() {
        return awaitingTimeRep;
    }

    public void setAwaitingTimeRep(List<AwaitingTimeRep> awaitingTimeRep) {
        this.awaitingTimeRep = awaitingTimeRep;
    }

    public List<MissedAppRep> getMissedAppRep() {
        return missedAppRep;
    }

    public void setMissedAppRep(List<MissedAppRep> missedAppRep) {
        this.missedAppRep = missedAppRep;
    }

    public List<ServicesTypeRep> getServicesTypeRep() {
        return servicesTypeRep;
    }

    public void setServicesTypeRep(List<ServicesTypeRep> servicesTypeRep) {
        this.servicesTypeRep = servicesTypeRep;
    }

    @Override
    public String toString() {
        return "HMO manager[ "+super.toString() + " ]";
    }

}


