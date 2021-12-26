package org.example;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Entity
public class Nurse extends Employee {
    @OneToMany(targetEntity = NurseApp.class)
    protected List<NurseApp> nurseApps;

    public Nurse(String username, String password,String first_name,String last_name,int card,String Email,String main_clinic,List<NurseApp> nurseApps) throws NoSuchAlgorithmException {
        super(username, password,first_name,last_name,"nurse",card,Email,main_clinic);
        this.nurseApps = nurseApps;
    }
    public Nurse() {
        super();
        nurseApps=null;
    }
    public List<NurseApp> getNurseApps() {
        return nurseApps;
    }

    public void setNurseApps(List<NurseApp> nurseApps) {
        this.nurseApps = nurseApps;
    }

    @Override
    public String toString() {
        return "Nurse[ "+super.toString() + " ]";
    }
}
