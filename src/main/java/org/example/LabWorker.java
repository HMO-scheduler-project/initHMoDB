package org.example;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.security.NoSuchAlgorithmException;
import java.time.LocalTime;
import java.util.List;

@Entity
public class LabWorker extends Employee{

    @OneToMany(targetEntity = LabApp.class)
    List<LabApp> labApps; // one lab worker has several lab appointments

    public LabWorker() {
        super();
        labApps=null;
    }

    public LabWorker(String username, String password, String first_name, String last_name, String card, String Email,
                     String phone_num,String main_clinic, List<LabApp> labApps, int room_num, LocalTime start,LocalTime end) throws NoSuchAlgorithmException {
        super(username, password, first_name, last_name, "lab worker", card, Email, phone_num,main_clinic,room_num,start,end);
        this.labApps = labApps;
    }

    public List<LabApp> getLabApps() {
        return labApps;
    }

    public void setLabApps(List<LabApp> labApps) {
        this.labApps = labApps;
    }

    public void addLabApp(LabApp new_app){
        this.labApps.add(new_app);
    }

    public void removeLabApp(LabApp app_to_delete){
        this.labApps.remove(app_to_delete);
    }

}
