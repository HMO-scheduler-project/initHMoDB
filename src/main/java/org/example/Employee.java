package org.example;

import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee extends User {
    protected String role;
    protected String main_clinic;
    protected int room_num;
    protected LocalTime start_working_hour;
    protected LocalTime finish_working_hour;
    @OneToMany(targetEntity = Appointment.class)
    protected List<Appointment> appointments = new ArrayList<>();
    protected boolean covid_vaccinated;
    protected boolean Influenza_vaccinated;
    protected LocalDate covidVaccine_date;

    public Employee(String username, String password,String first_name,String last_name,String role,String card,String Email,String phone_num,String main_clinic,int room_num,LocalTime start,LocalTime finish) throws NoSuchAlgorithmException {
        super(username, password,card,first_name,last_name,Email,phone_num);
        this.role = role;
        this.main_clinic = main_clinic;
        this.room_num = room_num;
        this.start_working_hour = start;
        this.finish_working_hour = finish;
        this.covid_vaccinated = true;
        this.Influenza_vaccinated = true;
        this.covidVaccine_date = LocalDate.parse("2021-09-01");
    }

    public Employee() {
        super();
        this.Email = null;
        this.main_clinic = null;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMain_clinic() {
        return main_clinic;
    }

    public void setMain_clinic(String main_clinic) {
        this.main_clinic = main_clinic;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment appointment){
        this.appointments.add(appointment);
    }

    public void removeAppointment(Appointment appointment){
        this.appointments.remove(appointment);
    }

    public int getRoom_num() {
        return room_num;
    }

    public void setRoom_num(int room_num) {
        this.room_num = room_num;
    }

    public LocalTime getStart_working_hour() {
        return start_working_hour;
    }

    public void setStart_working_hour(LocalTime start_working_hour) {
        this.start_working_hour = start_working_hour;
    }

    public LocalTime getFinish_working_hour() {
        return finish_working_hour;
    }

    public void setFinish_working_hour(LocalTime finish_working_hour) {
        this.finish_working_hour = finish_working_hour;
    }

    public boolean isCovid_vaccinated() {
        return covid_vaccinated;
    }

    public void setCovid_vaccinated(boolean covid_vaccinated) {
        this.covid_vaccinated = covid_vaccinated;
    }

    public boolean isInfluenza_vaccinated() {
        return Influenza_vaccinated;
    }

    public void setInfluenza_vaccinated(boolean influenza_vaccinated) {
        Influenza_vaccinated = influenza_vaccinated;
    }

    public LocalDate getCovidVaccine_date() {
        return covidVaccine_date;
    }

    public void setCovidVaccine_date(LocalDate covidVaccine_date) {
        this.covidVaccine_date = covidVaccine_date;
    }

    @Override
    public String toString() {
        return "employee[ "+super.toString() + "Email: "+Email+"main clinic: "+main_clinic+" ]";
    }

}