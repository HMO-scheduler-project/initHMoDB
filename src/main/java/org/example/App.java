package org.example;
import org.example.Reports.AwaitingTimeRep;
import org.example.Reports.MissedAppRep;
import org.example.Reports.ServicesTypeRep;
import org.example.Reports.WeeklyReport;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;


public class App
{
    private static Session session;
    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(AwaitingTimeRep.class);
        configuration.addAnnotatedClass(MissedAppRep.class);
        configuration.addAnnotatedClass(ServicesTypeRep.class);
        configuration.addAnnotatedClass(WeeklyReport.class);
        configuration.addAnnotatedClass(Appointment.class);
        configuration.addAnnotatedClass(childrenDoctorApp.class);
        configuration.addAnnotatedClass(Clinic.class);
        configuration.addAnnotatedClass(Covid19Test.class);
        configuration.addAnnotatedClass(Covid19VaccineApp.class);
        configuration.addAnnotatedClass(CovidQuestionnaire.class);
        configuration.addAnnotatedClass(Doctor.class);
        configuration.addAnnotatedClass(doctorApp.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(familyDoctorApp.class);
        configuration.addAnnotatedClass(GreenPass.class);
        configuration.addAnnotatedClass(HMO_Manager.class);
        configuration.addAnnotatedClass(InfluenzaVaccineApp.class);
        configuration.addAnnotatedClass(LabApp.class);
        configuration.addAnnotatedClass(LabWorker.class);
        configuration.addAnnotatedClass(Manager.class);
        configuration.addAnnotatedClass(Nurse.class);
        configuration.addAnnotatedClass(NurseApp.class);
        configuration.addAnnotatedClass(Patient.class);
        configuration.addAnnotatedClass(SpecialDoctor.class);
        configuration.addAnnotatedClass(specialDoctorApp.class);
        configuration.addAnnotatedClass(User.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


    private static void initEmployeesTable() throws Exception {
        // create instance of Random class
        Random rand = new Random();
        int card_num = rand.nextInt(100000);
        HMO_Manager employee1 = new HMO_Manager("Agoldstein","AG1234","Alex","Goldstein",card_num,"agoldstein@good_health.com", "HMO_Managment",null);
        session.save(employee1);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee2 = new Manager("Rcohen","RC1234","Ruth","Cohen","clinic manager",card_num,"rcohen@good_health.com", "Denia",null);
        session.save(employee2);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee3 = new Manager("Mlevi","ML1234","Maya","Levi","clinic manager",card_num,"mlevi@good_health.com", "Neve shaanan",null);
        session.save(employee3);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee4 = new SpecialDoctor("Dliberman","DL1234","David","Liberman","cardiologist",card_num,"dliberman@good_health.com", "Carmel",null);
        session.save(employee4);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee5 = new Manager("Daviv","DA1234","Dan","Aviv","clinic manager",card_num,"daviv@good_health.com", "Nesher",null);
        session.save(employee5);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee6 = new Manager("TShuster","TS1234","Tal","Shuster","clinic manager",card_num,"tshuster@good_health.com", "Hadar",null);
        session.save(employee6);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee7 = new Doctor("REldar","RE1234","Rachel","Eldar","pediatrician",card_num,"reldar@good_health.com", "Hadar");
        session.save(employee7);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee8 = new Manager("VSilverman","VS1234","Valeria","Silverman","clinic manager",card_num,"vsilverman@good_health.com", "Carmel",null);
        session.save(employee8);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee9 = new Doctor("DShitrit","DS1234","Dor","Shitrit","family_doctor",card_num,"dshitrit@good_health.com", "Neve shaanan");
        session.save(employee9);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee10 = new Manager("CSella","CS1234","Chen","Sella","clinic manager",card_num,"csella@good_health.com", "Tirat Carmel",null);
        session.save(employee10);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee11 = new Doctor("NWeber","NW1234","Naama","Weber","family_doctor",card_num,"nweber@good_health.com", "Hadar");
        session.save(employee11);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee12 = new Doctor("ABachar","AB1234","Amit","Bachar","family_doctor",card_num,"abachar@good_health.com", "Denia");
        session.save(employee12);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee13 = new Doctor("MPorat","MP1234","Moran","Porat","family_doctor",card_num,"mporat@good_health.com", "Nesher");
        session.save(employee13);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee14 = new Doctor("MZeev","MZ1234","Maayan","Zeev","family_doctor",card_num,"mzeev@good_health.com", "Tirat Carmel");
        session.save(employee14);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee15 = new Doctor("RShtein","RS1234","Rotem","Shtein","family_doctor",card_num,"rshtein@good_health.com", "Carmel");
        session.save(employee15);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee16 = new Doctor("RBarlev","RB1234","Ravit","Barlev","pediatrician",card_num,"rbarlev@good_health.com", "Denia");
        session.save(employee16);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee17 = new Doctor("GNadler","GN1234","Gil","Nadler","pediatrician",card_num,"gnadler@good_health.com", "Neve shaanan");
        session.save(employee17);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee18 = new Doctor("TRobin","TR1234","Tom","Robin","pediatrician",card_num,"trobin@good_health.com", "Nesher");
        session.save(employee18);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee19 = new Doctor("EPeretz","EP1234","Elinor","Peretz","pediatrician",card_num,"eperetz@good_health.com", "Carmel");
        session.save(employee19);
        session.flush();
        card_num = rand.nextInt(100000);
        Doctor employee20 = new Doctor("YHadad","YH1234","Yuval","Hadad","pediatrician",card_num,"yhadad@good_health.com", "Tirat Carmel");
        session.save(employee20);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee21 = new Nurse( "SLev","SL1234","Shahar","Lev",card_num,"slev@good_health.com", "Denia",null);
        session.save(employee21);
        session.flush();
        card_num = rand.nextInt(100000);
         Nurse employee22 = new Nurse("GShwartz","GS1234","Gal","Shwartz",card_num,"gshwartz@good_health.com", "Neve shaanan",null);
        session.save(employee22);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee23 = new Nurse("SCohen","SC1234","Sarit","Cohen",card_num,"scohen@good_health.com", "Hadar",null);
        session.save(employee23);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee24 = new Nurse( "IGad","IG1234","Ilanit","Gad",card_num,"igad@good_health.com", "Nesher",null);
        session.save(employee24);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee25 = new Nurse( "ALevi","AL1234","Adi","Levi",card_num,"alevi@good_health.com", "Carmel",null);
        session.save(employee25);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee26 = new Nurse( "TGrosman","TG1234","Tamar","Grosman",card_num,"tgrosman@good_health.com", "Tirat Carmel",null);
        session.save(employee26);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee27 = new SpecialDoctor( "AIsraeli","AI1234","Avraham","Israeli","ENT doctor",card_num,"aisraeli@good_health.com", "Carmel",null);
        session.save(employee27);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee28 = new SpecialDoctor("MSason","MS1234","Miriam","Sason","gynecologist",card_num,"msason@good_health.com", "Carmel",null);
        session.save(employee28);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee29 = new SpecialDoctor("SAviram","SA1234","Shlomi","Aviram","dermatologist",card_num,"saviram@good_health.com", "Carmel",null);
        session.save(employee29);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee30 = new SpecialDoctor("AMelamed","AM1234","Alon","Melamed","ophthalmologist",card_num,"amelamed@good_health.com", "Carmel",null);
        session.save(employee30);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee31 = new SpecialDoctor("EHadad","EH1234","Erez","Hadad","ENT doctor",card_num,"ehadad@good_health.com", "Carmel",null);
        session.save(employee31);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee32 = new LabWorker("ARodensky","AR1234","Anna","Rodensky",card_num,"arodensky@good_health.com", "Denia",null);
        session.save(employee32);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee33 = new LabWorker("AIsraeli","AI1234","Alina","Israeli",card_num,"aisraeli@good_health.com", "Neve Shaanan",null);
        session.save(employee33);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee34 = new LabWorker("OAshkenazi","OA1234", "Oren","Ashkenazi",card_num,"oashkenazi@good_health.com", "Hadar",null);
        session.save(employee34);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee35 = new LabWorker("ABar","AB1234","Avital","Bar",card_num,"abar@good_health.com", "Nesher",null);
        session.save(employee35);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee36 = new LabWorker("YShachar","YS1234","Yael","Shachar",card_num,"yshachar@good_health.com", "Carmel",null);
        session.save(employee36);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker employee37 = new LabWorker("TGil","TG1234","Tehila","Gil",card_num,"tgil@good_health.com", "Tirat Carmel",null);
        session.save(employee37);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee38 = new SpecialDoctor("NDadon","ND1234","Nathan","Dadon","neurologist",card_num,"ndadon@good_health.com", "Carmel",null);
        session.save(employee38);
        session.flush();
        card_num = rand.nextInt(100000);
        SpecialDoctor employee39 = new SpecialDoctor("OTzarfati", "OT1234", "Ofer", "Tzarfati", "gynecologist", card_num, "otzarfati@good_health.com", "Carmel",null);
        session.save(employee39);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse employee40 = new Nurse("DOren","DO1234","Dana","Oren",card_num,"doren@good_health.com", "Carmel",null);
        session.save(employee40);
        session.flush();
    }

    public static Manager getManager(int Id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
        query.from(Manager.class);
        List<Manager> managers = session.createQuery(query).getResultList();
        for (Manager manager : managers) {
            if (manager.getUserId() == Id) {
                return manager;
            }
        }
        return null;
    }

    private static void initClinicsTable() throws Exception {
        Clinic clinic1 = new Clinic("Denia","Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"),getManager(2),"Libiria 2","04-8656321");
        session.save(clinic1);
        session.flush();
        Clinic clinic2 = new Clinic("Neve shaanan","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("20:00:00"),getManager(3),"Hagalil 76","04-8656322");
        session.save(clinic2);
        session.flush();
        Clinic clinic3 = new Clinic("Hadar","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("19:00:00"),getManager(6),"Herzel 15","04-8656323");
        session.save(clinic3);
        session.flush();
        Clinic clinic4 = new Clinic("Nesher","Nesher",LocalTime.parse("07:00:00"),LocalTime.parse("19:00:00"),getManager(5),"Haalon 23","04-8656324");
        session.save(clinic4);
        session.flush();
        Clinic clinic5 = new Clinic("Carmel","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("20:00:00"),getManager(8),"Horev 6","04-8656325");
        session.save(clinic5);
        session.flush();
        Clinic clinic6 = new Clinic("Tirat Carmel","Tirat Carmel",LocalTime.parse("07:00:00"),LocalTime.parse("17:00:00"),getManager(10),"Levi eshckol 16","04-8656326");
        session.save(clinic6);
        session.flush();
    }

    public static Doctor getDoctor(int Id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Doctor> query = builder.createQuery(Doctor.class);
        query.from(Doctor.class);
        List<Doctor> doctors = session.createQuery(query).getResultList();
        for (Doctor doctor : doctors) {
            if (doctor.getUserId() == Id) {
                return doctor;
            }
        }
        return null;
    }

    public static Clinic getClinic(String name) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clinic> query = builder.createQuery(Clinic.class);
        query.from(Clinic.class);
        List<Clinic> clinics = session.createQuery(query).getResultList();
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(name)) {
                return clinic;
            }
        }
        return null;
    }

    private static void initPatientsTable() throws NoSuchAlgorithmException {
        // create instance of Random class
        Random rand = new Random();
        int card_num = rand.nextInt(100000);
        Patient pat1 = new Patient("DHolland", "DH1234","Dana","Holland",getDoctor(9)
                , LocalDate.parse("1990-12-10"),card_num,"DHolland@life.com",getClinic("Neve shaanan"), null);
        session.save(pat1);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat2 = new Patient("YChen", "YC1234","Yonathan","Chen",getDoctor(19)
                , LocalDate.parse("2012-09-18"),card_num,"YChen@life.com",getClinic("Carmel"), null);
        session.save(pat2);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat3 = new Patient("CLevi", "CL1234","Chen","Levi",getDoctor(7)
                , LocalDate.parse("2020-06-18"),card_num,"CLevi@life.com",getClinic("Hadar"), null);
        session.save(pat3);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat4 = new Patient("RGil", "RG1234","Ronna","Gil",getDoctor(9)
                , LocalDate.parse("1945-06-21"),card_num,"RGil@life.com",getClinic("Neve shaanan"), null);
        session.save(pat4);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat5 = new Patient("TShitrit", "TS1234","Tali","Shitrit",getDoctor(13)
                , LocalDate.parse("1996-05-14"),card_num,"TShitrit@life.com",getClinic("Nesher"), null);
        session.save(pat5);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat6 = new Patient("NSabag", "NS1234","Noga","Sabag",getDoctor(14)
                , LocalDate.parse("2001-07-21"),card_num,"NSabag@life.com",getClinic("Tirat Carmel"), null);
        session.save(pat6);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat7 = new Patient("DCohen", "DC1234","Dor","Cohen",getDoctor(15)
                , LocalDate.parse("1984-03-08"),card_num,"DCohen@life.com",getClinic("Carmel"), null);
        session.save(pat7);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat8 = new Patient("SGold", "SG1234","Shon","Gold",getDoctor(16)
                , LocalDate.parse("2014-09-17"),card_num,"SGold@life.com",getClinic("Denia"), null);
        session.save(pat8);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat9 = new Patient("IMoskovitz", "IM1234","Israel","Moskovitz",getDoctor(12)
                , LocalDate.parse("1974-05-19"),card_num,"IMoskovitz@life.com",getClinic("Denia"), null);
        session.save(pat9);
        session.flush();
        card_num = rand.nextInt(100000);
        Patient pat10 = new Patient("MHadad", "MH1234","Moshe","Hadad",getDoctor(9)
                , LocalDate.parse("1964-03-21"),card_num,"MHadad@life.com",getClinic("Neve shaanan"), null);
        session.save(pat10);
        session.flush();
    }

    private static Patient getPatient(String username){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Patient> query = builder.createQuery(Patient.class);
        query.from(Patient.class);
        List<Patient> patientList = session.createQuery(query).getResultList();
        for (Patient patient : patientList) {
            if (patient.getUsername().equals(username)) {
                return patient;
            }
        }
        return null;
    }

    private static SpecialDoctor getSpecialDoctor(int Id){
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<SpecialDoctor> query = builder.createQuery(SpecialDoctor.class);
        query.from(SpecialDoctor.class);
        List<SpecialDoctor> doctorsList = session.createQuery(query).getResultList();
        for (SpecialDoctor doctor : doctorsList) {
            if (doctor.getUserId() == Id) {
                return doctor;
            }
        }
        return null;
    }

    private static void initAppointmentsTable() throws Exception {
        Patient currPat = getPatient("DHolland");
        SpecialDoctor doc;
        doctorApp app1 = new doctorApp(LocalTime.parse("10:00"), LocalDate.parse("2022-01-18"), currPat.getClinic(), currPat, currPat.getDoctor());
        session.save(app1);
        session.flush();
        currPat = getPatient("SGold");
        doctorApp app2 = new doctorApp(LocalTime.parse("09:00"), LocalDate.parse("2022-01-19"), currPat.getClinic(), currPat, currPat.getDoctor());
        session.save(app2);
        session.flush();
        currPat = getPatient("NSabag");
        doctorApp app3 = new doctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-20"), currPat.getClinic(), currPat, currPat.getDoctor());
        session.save(app3);
        session.flush();
        currPat = getPatient("TShitrit");
        doctorApp app4 = new doctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-23"), currPat.getClinic(), currPat, currPat.getDoctor());
        session.save(app4);
        session.flush();
        currPat = getPatient("YChen");
        doc = getSpecialDoctor(38);
        specialDoctorApp app5 = new specialDoctorApp(LocalTime.parse("08:30"), LocalDate.parse("2022-01-23"), getClinic("Carmel"),currPat,doc);
        session.save(app5);
        session.flush();
        currPat = getPatient("CLevi");
        specialDoctorApp app6 = new specialDoctorApp(LocalTime.parse("12:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"),currPat, doc);
        session.save(app6);
        session.flush();
        currPat = getPatient("RGil");
        doc = getSpecialDoctor(30);
        specialDoctorApp app7 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-19"), getClinic("Carmel"),currPat, doc);
        session.save(app7);
        session.flush();
        currPat = getPatient("TShitrit");
        specialDoctorApp app8 = new specialDoctorApp(LocalTime.parse("15:00"), LocalDate.parse("2022-01-19"), getClinic("Carmel"),currPat, doc);
        session.save(app8);
        session.flush();
        currPat = getPatient("RGil");
        doc = getSpecialDoctor(27);
        specialDoctorApp app9 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-18"), getClinic("Carmel"),currPat, doc);
        session.save(app9);
        session.flush();
        currPat = getPatient("DCohen");
        doc = getSpecialDoctor(27);
        specialDoctorApp app10 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"),currPat, doc);
        session.save(app10);
        session.flush();

    }


        public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            initEmployeesTable();
            initClinicsTable();
            initPatientsTable();
            initAppointmentsTable();
            session.getTransaction().commit(); // Save everything.
        } catch (Exception exception) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            System.err.println("An error occurred, changes have been rolled back.");
            exception.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
