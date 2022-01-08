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
        configuration.addAnnotatedClass(clinicSpecialService.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


    private static void initEmployeesTable() throws Exception {
        // create instance of Random class
        Random rand = new Random();
        String card_num = String.valueOf(Math.abs(rand.nextInt()));
        HMO_Manager employee1 = new HMO_Manager("Agoldstein", "AG1234", "Alex", "Goldstein", card_num, "agoldstein@good_health.com", "054-6329487","HMO_Managment",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00") );
//        employee1.setManaging_clinics(getAllClinics());
        session.save(employee1);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee2 = new Manager("Rcohen","RC1234","Ruth","Cohen","clinic manager",card_num,"rcohen@good_health.com","052-6347812", "Denia",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee2.addManagingClinic(getClinic("Denia"));
        session.save(employee2);
        session.flush();
        Clinic clinic = getClinic("Denia");
        clinic.setManager(employee2);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee3 = new Manager("Mlevi","ML1234","Maya","Levi","clinic manager",card_num,"mlevi@good_health.com","050-7481239", "Neve shaanan",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee3.addManagingClinic(getClinic("Neve shaanan"));
        session.save(employee3);
        session.flush();
        clinic = getClinic("Neve shaanan");
        clinic.setManager(employee3);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee4 = new SpecialDoctor("Dliberman","DL1234","David","Liberman","cardiologist",card_num,"dliberman@good_health.com","050-6374158", "Carmel",null,15,LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"));
//        employee4.addClinic(getClinic("Carmel"));
        session.save(employee4);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee5 = new Manager("Daviv","DA1234","Dan","Aviv","clinic manager",card_num,"daviv@good_health.com","053-864971", "Nesher",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee5.addManagingClinic(getClinic("Nesher"));
        session.save(employee5);
        session.flush();
        clinic = getClinic("Nesher");
        clinic.setManager(employee5);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee6 = new Manager("TShuster","TS1234","Tal","Shuster","clinic manager",card_num,"tshuster@good_health.com","053-9641825", "Hadar",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee6.addManagingClinic(getClinic("Hadar"));
        session.save(employee6);
        session.flush();
        clinic = getClinic("Hadar");
        clinic.setManager(employee6);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee7 = new Doctor("REldar","RE1234","Rachel","Eldar","pediatrician",card_num,"reldar@good_health.com","052-7496152", "Hadar",3,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee7);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee8 = new Manager("VSilverman","VS1234","Valeria","Silverman","clinic manager",card_num,"vsilverman@good_health.com","050-6317859", "Carmel",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee8.addManagingClinic(getClinic("Carmel"));
        session.save(employee8);
        session.flush();
        clinic = getClinic("Carmel");
        clinic.setManager(employee8);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee9 = new Doctor("DShitrit","DS1234","Dor","Shitrit","family_doctor",card_num,"dshitrit@good_health.com","050-7841528", "Neve shaanan",4,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee9);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee10 = new Manager("CSella","CS1234","Chen","Sella","clinic manager",card_num,"csella@good_health.com","050-7841256", "Tirat Carmel",null,1,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee10.addManagingClinic(getClinic("Tirat Carmel"));
        session.save(employee10);
        session.flush();
        clinic = getClinic("Tirat Carmel");
        clinic.setManager(employee10);
        session.save(clinic);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee11 = new Doctor("NWeber","NW1234","Naama","Weber","family_doctor",card_num,"nweber@good_health.com","052-7841368", "Hadar",4,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee11);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee12 = new Doctor("ABachar","AB1234","Amit","Bachar","family_doctor",card_num,"abachar@good_health.com","052-7481693", "Denia",4,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee12);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee13 = new Doctor("MPorat","MP1234","Moran","Porat","family_doctor",card_num,"mporat@good_health.com","052-7413685", "Nesher",4,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee13);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee14 = new Doctor("MZeev","MZ1234","Maayan","Zeev","family_doctor",card_num,"mzeev@good_health.com","052-8736951", "Tirat Carmel",4,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee14);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee15 = new Doctor("RShtein","RS1234","Rotem","Shtein","family_doctor",card_num,"rshtein@good_health.com","053-8649571", "Carmel",4,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee15);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee16 = new Doctor("RBarlev","RB1234","Ravit","Barlev","pediatrician",card_num,"rbarlev@good_health.com","053-1259648", "Denia",3,LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee16);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee17 = new Doctor("GNadler","GN1234","Gil","Nadler","pediatrician",card_num,"gnadler@good_health.com","053-4695782", "Neve shaanan",3,LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee17);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee18 = new Doctor("TRobin","TR1234","Tom","Robin","pediatrician",card_num,"trobin@good_health.com","053-1574864", "Nesher",3,LocalTime.parse("09:00:00"), LocalTime.parse("18:00:00"));
        session.save(employee18);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee19 = new Doctor("EPeretz","EP1234","Elinor","Peretz","pediatrician",card_num,"eperetz@good_health.com","053-1497652", "Carmel",3,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee19);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee20 = new Doctor("YHadad","YH1234","Yuval","Hadad","pediatrician",card_num,"yhadad@good_health.com","053-1564875", "Tirat Carmel",3,LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee20);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee21 = new Nurse( "SLev","SL1234","Shahar","Lev",card_num,"slev@good_health.com","053-9576481", "Denia",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee21);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
         Nurse employee22 = new Nurse("GShwartz","GS1234","Gal","Shwartz",card_num,"gshwartz@good_health.com","050-4657821", "Neve shaanan",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
        session.save(employee22);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee23 = new Nurse("SCohen","SC1234","Sarit","Cohen",card_num,"scohen@good_health.com","050-6854721", "Hadar",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee23);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee24 = new Nurse( "IGad","IG1234","Ilanit","Gad",card_num,"igad@good_health.com","050-9546814", "Nesher",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee24);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee25 = new Nurse( "ALevi","AL1234","Adi","Levi",card_num,"alevi@good_health.com","050-1142533", "Carmel",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
        session.save(employee25);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee26 = new Nurse( "TGrosman","TG1234","Tamar","Grosman",card_num,"tgrosman@good_health.com","050-4715211", "Tirat Carmel",null,5,LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee26);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee27 = new SpecialDoctor( "AIsraeli","AI1234","Avraham","Israeli","ENT doctor",card_num,"aisraeli@good_health.com","050-8411235", "Neve Shaanan, Hadar, Nesher",null,7,LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"));
//        employee27.addClinic(getClinic("Carmel"));
        session.save(employee27);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee28 = new SpecialDoctor("MSason","MS1234","Miriam","Sason","gynecologist",card_num,"msason@good_health.com","052-3354215", "Carmel",null,9,LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee28.addClinic(getClinic("Carmel"));
        session.save(employee28);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee29 = new SpecialDoctor("SAviram","SA1234","Shlomi","Aviram","dermatologist",card_num,"saviram@good_health.com","050-6345587", "Carmel",null,10,LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee29.addClinic(getClinic("Carmel"));
        session.save(employee29);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee30 = new SpecialDoctor("AMelamed","AM1234","Alon","Melamed","ophthalmologist",card_num,"amelamed@good_health.com","050-5148764", "Carmel",null,11,LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee30.addClinic(getClinic("Carmel"));
        session.save(employee30);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee31 = new SpecialDoctor("EHadad","EH1234","Erez","Hadad","ENT doctor",card_num,"ehadad@good_health.com","050-7461255", "Carmel",null,12,LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee31.addClinic(getClinic("Carmel"));
        session.save(employee31);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee32 = new LabWorker("ARodensky","AR1234","Anna","Rodensky",card_num,"arodensky@good_health.com","050-4788562", "Denia",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee32);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee33 = new LabWorker("AIsraeli","AI1234","Alina","Israeli",card_num,"aisraeli@good_health.com","050-7544632", "Neve Shaanan",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee33);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee34 = new LabWorker("OAshkenazi","OA1234", "Oren","Ashkenazi",card_num,"oashkenazi@good_health.com","053-8544125", "Hadar",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee34);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee35 = new LabWorker("ABar","AB1234","Avital","Bar",card_num,"abar@good_health.com","052-1477854", "Nesher",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee35);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee36 = new LabWorker("YShachar","YS1234","Yael","Shachar",card_num,"yshachar@good_health.com","053-9655321", "Carmel",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee36);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee37 = new LabWorker("TGil","TG1234","Tehila","Gil",card_num,"tgil@good_health.com","053-6512447", "Tirat Carmel",null,2,LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee37);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee38 = new SpecialDoctor("NDadon","ND1234","Nathan","Dadon","neurologist",card_num,"ndadon@good_health.com","052-6341874", "Carmel",null,7,LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee38.addClinic(getClinic("Carmel"));
        session.save(employee38);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee39 = new SpecialDoctor("OTzarfati", "OT1234", "Ofer", "Tzarfati", "gynecologist", card_num, "otzarfati@good_health.com","053-6547712", "Carmel, Tirat Carmel",null,8,LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
//        employee39.addClinic(getClinic("Carmel"));
        session.save(employee39);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee40 = new Nurse("DOren","DO1234","Dana","Oren",card_num,"doren@good_health.com","050-3285441", "Carmel",null,6,LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
        session.save(employee40);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee41 = new SpecialDoctor("NHadad","NH1234","Noa","Hadad","neurologist",card_num,"nhadad@good_health.com","052-6362584", "Nesher",null,7,LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
//        employee41.addClinic(getClinic("Carmel"));
        session.save(employee41);
        session.flush();

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee42 = new SpecialDoctor("YMoshe","YM1234","Yair","Moshe","neurologist",card_num,"ymoshe@good_health.com","052-6384751", "Neve Shaanan, Denia, Tirat Carmel",null,7,LocalTime.parse("08:00:00"), LocalTime.parse("16:00:00"));
//        employee42.addClinic(getClinic("Carmel"));
        session.save(employee42);
        session.flush();
    }

    public static void initServicesTable(){
        clinicSpecialService service1 = new clinicSpecialService("covid test","Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"),2);
        session.save(service1);
        session.flush();
        clinicSpecialService service2 = new clinicSpecialService("covid test","Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"),2);
        session.save(service2);
        session.flush();
        clinicSpecialService service3 = new clinicSpecialService("covid test","Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"),2);
        session.save(service3);
        session.flush();

        clinicSpecialService service4 = new clinicSpecialService("covid vaccine","Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"),5);
        session.save(service4);
        session.flush();
        clinicSpecialService service5 = new clinicSpecialService("covid vaccine","Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"),5);
        session.save(service5);
        session.flush();
        clinicSpecialService service6 = new clinicSpecialService("covid vaccine","Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"),5);
        session.save(service6);
        session.flush();

        clinicSpecialService service7 = new clinicSpecialService("influenza vaccine","Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"),5);
        session.save(service7);
        session.flush();
        clinicSpecialService service8 = new clinicSpecialService("influenza vaccine","Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"),5);
        session.save(service8);
        session.flush();
        clinicSpecialService service9 = new clinicSpecialService("influenza vaccine","Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"),5);
        session.save(service9);
        session.flush();
        clinicSpecialService service10 = new clinicSpecialService("influenza vaccine","Tirat Carmel", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"),5);
        session.save(service10);
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
        Clinic clinic1 = new Clinic("Denia","Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"),null,"Libiria 2","04-8656321");
        clinic1.setSpecialists(true);
        clinic1.setLabServices(true);
        session.save(clinic1);
        session.flush();

        Clinic clinic2 = new Clinic("Neve shaanan","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("20:00:00"),null,"Hagalil 76","04-8656322");
        clinic2.setSpecialists(true);
        clinic2.setLabServices(true);
        clinic2.setCovidTestService(true);
        clinic2.setCovidVaccine(true);
        clinic2.setInfluenzaVaccine(true);
        session.save(clinic2);
        session.flush();

        Clinic clinic3 = new Clinic("Hadar","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("19:00:00"),null,"Herzel 15","04-8656323");
        clinic3.setSpecialists(true);
        clinic3.setLabServices(true);
        clinic3.setCovidTestService(true);
        clinic3.setCovidVaccine(true);
        clinic3.setInfluenzaVaccine(true);
        session.save(clinic3);
        session.flush();

        Clinic clinic4 = new Clinic("Nesher","Nesher",LocalTime.parse("07:00:00"),LocalTime.parse("19:00:00"),null,"Haalon 23","04-8656324");
        clinic4.setSpecialists(true);
        clinic4.setLabServices(true);
        clinic4.setCovidTestService(true);
        clinic4.setCovidVaccine(true);
        clinic4.setInfluenzaVaccine(true);
        session.save(clinic4);
        session.flush();

        Clinic clinic5 = new Clinic("Carmel","Haifa",LocalTime.parse("07:00:00"),LocalTime.parse("20:00:00"),null,"Horev 6","04-8656325");
        clinic5.setSpecialists(true);
        clinic5.setLabServices(true);
        session.save(clinic5);
        session.flush();

        Clinic clinic6 = new Clinic("Tirat Carmel","Tirat Carmel",LocalTime.parse("07:00:00"),LocalTime.parse("17:00:00"),null,"Levi eshckol 16","04-8656326");
        clinic6.setSpecialists(true);
        clinic6.setLabServices(true);
        clinic6.setInfluenzaVaccine(true);
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

    public static List<Clinic> getAllClinics() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clinic> query = builder.createQuery(Clinic.class);
        query.from(Clinic.class);
        return session.createQuery(query).getResultList();
    }

    private static void initPatientsTable() throws NoSuchAlgorithmException {
        // create instance of Random class
        Random rand = new Random();
        String card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat1 = new Patient("DHolland", "DH1234","Dana","Holland",getDoctor(9)
                , LocalDate.parse("1990-12-10"),card_num,"DHolland@life.com","052-6574123",getClinic("Neve shaanan"), null);
        session.save(pat1);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat2 = new Patient("YChen", "YC1234","Yonathan","Chen",getDoctor(19)
                , LocalDate.parse("2012-09-18"),card_num,"YChen@life.com","050-4875326",getClinic("Carmel"), null);
        session.save(pat2);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat3 = new Patient("CLevi", "CL1234","Chen","Levi",getDoctor(7)
                , LocalDate.parse("2020-06-18"),card_num,"CLevi@life.com","053-6589514",getClinic("Hadar"), null);
        session.save(pat3);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat4 = new Patient("RGil", "RG1234","Ronna","Gil",getDoctor(9)
                , LocalDate.parse("1945-06-21"),card_num,"RGil@life.com","058-8645711",getClinic("Neve shaanan"), null);
        session.save(pat4);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat5 = new Patient("TShitrit", "TS1234","Tali","Shitrit",getDoctor(13)
                , LocalDate.parse("1996-05-14"),card_num,"TShitrit@life.com","053-6487125",getClinic("Nesher"), null);
        session.save(pat5);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat6 = new Patient("NSabag", "NS1234","Noga","Sabag",getDoctor(14)
                , LocalDate.parse("2001-07-21"),card_num,"NSabag@life.com","058-9654871",getClinic("Tirat Carmel"), null);
        session.save(pat6);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat7 = new Patient("DCohen", "DC1234","Dor","Cohen",getDoctor(15)
                , LocalDate.parse("1984-03-08"),card_num,"DCohen@life.com","058-6574128",getClinic("Carmel"), null);
        session.save(pat7);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat8 = new Patient("SGold", "SG1234","Shon","Gold",getDoctor(16)
                , LocalDate.parse("2014-09-17"),card_num,"SGold@life.com","054-9675214",getClinic("Denia"), null);
        session.save(pat8);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat9 = new Patient("IMoskovitz", "IM1234","Israel","Moskovitz",getDoctor(12)
                , LocalDate.parse("1974-05-19"),card_num,"IMoskovitz@life.com","054-9658412",getClinic("Denia"), null);
        session.save(pat9);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat10 = new Patient("MHadad", "MH1234","Moshe","Hadad",getDoctor(9)
                , LocalDate.parse("1964-03-21"),card_num,"MHadad@life.com","054-7832654",getClinic("Neve shaanan"), null);
        session.save(pat10);
        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Patient pat11 = new Patient("MRosen", "MR1234","Maayan","Rosen",getDoctor(11)
                , LocalDate.parse("1999-03-27"),card_num,"MRosen@life.com","054-5247863",getClinic("Hadar"), null);
        session.save(pat11);
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
        Doctor doc =  currPat.getDoctor();
        SpecialDoctor sdoc;
        doctorApp app1 = new doctorApp(LocalTime.parse("10:00"), LocalDate.parse("2022-01-18"), currPat.getClinic(), currPat, doc);
        session.save(app1);
//        doc.addAppointment(app1);
        session.save(doc);

        currPat = getPatient("SGold");
        doc = currPat.getDoctor();
        doctorApp app2 = new doctorApp(LocalTime.parse("09:00"), LocalDate.parse("2022-01-19"), currPat.getClinic(), currPat, doc);
        session.save(app2);
//        doc.addAppointment(app2);
        session.save(doc);

        currPat = getPatient("NSabag");
        doc = currPat.getDoctor();
        doctorApp app3 = new doctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-20"), currPat.getClinic(), currPat, doc);
        session.save(app3);
//        doc.addAppointment(app3);
        session.save(doc);

        currPat = getPatient("TShitrit");
        doc = currPat.getDoctor();
        doctorApp app4 = new doctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-23"), currPat.getClinic(), currPat, doc);
        session.save(app4);
//        doc.addAppointment(app4);
        session.save(doc);

        currPat = getPatient("YChen");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app5 = new specialDoctorApp(LocalTime.parse("08:30"), LocalDate.parse("2022-01-23"), getClinic("Carmel"),currPat,sdoc);
        session.save(app5);
//        sdoc.addAppointment(app5);
        session.save(sdoc);

        currPat = getPatient("CLevi");
        specialDoctorApp app6 = new specialDoctorApp(LocalTime.parse("12:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"),currPat, sdoc);
        session.save(app6);
//        sdoc.addAppointment(app6);
        session.save(sdoc);

        currPat = getPatient("RGil");
        sdoc = getSpecialDoctor(30);
        specialDoctorApp app7 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-19"), getClinic("Carmel"),currPat, sdoc);
        session.save(app7);
//        sdoc.addAppointment(app7);
        session.save(sdoc);

        currPat = getPatient("TShitrit");
        specialDoctorApp app8 = new specialDoctorApp(LocalTime.parse("15:00"), LocalDate.parse("2022-01-19"), getClinic("Carmel"),currPat, sdoc);
        session.save(app8);
//        sdoc.addAppointment(app8);
        session.save(sdoc);

        currPat = getPatient("RGil");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app9 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-18"), getClinic("Carmel"),currPat, sdoc);
        session.save(app9);
//        sdoc.addAppointment(app9);
        session.save(sdoc);

        currPat = getPatient("DCohen");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app10 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"),currPat, sdoc);
        session.save(app10);
//        sdoc.addAppointment(app10);
        session.save(sdoc);

        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app11 = new specialDoctorApp(LocalTime.parse("19:50"), LocalDate.parse("2022-01-06"), getClinic("Carmel"),currPat, sdoc);
        session.save(app11);
//        sdoc.addAppointment(app11);
        session.save(sdoc);

        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app12 = new specialDoctorApp(LocalTime.parse("11:00"), LocalDate.parse("2022-01-07"), getClinic("Carmel"),currPat, sdoc);
        session.save(app12);
//        sdoc.addAppointment(app12);
        session.save(sdoc);

        currPat = getPatient("TShitrit");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app13 = new specialDoctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-07"), getClinic("Carmel"),currPat, sdoc);
        session.save(app13);
//        sdoc.addAppointment(app13);
        session.save(sdoc);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app14 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-07"), getClinic("Carmel"),currPat, sdoc);
        session.save(app14);
//        sdoc.addAppointment(app14);
        session.save(sdoc);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(39);
        specialDoctorApp app15 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-10"), getClinic("Tirat Carmel"),currPat, sdoc);
        session.save(app15);
//        sdoc.addAppointment(app15);
        session.save(sdoc);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app16 = new specialDoctorApp(LocalTime.parse("15:00"), LocalDate.parse("2022-01-09"), getClinic("Tirat Carmel"),currPat, sdoc);
        session.save(app16);
//        sdoc.addAppointment(app16);
        session.save(sdoc);

        currPat = getPatient("SGold");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app17 = new specialDoctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-10"), getClinic("Denia"),currPat, sdoc);
        session.save(app17);
//        sdoc.addAppointment(app17);
        session.save(sdoc);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app18 = new specialDoctorApp(LocalTime.parse("13:40"), LocalDate.parse("2022-01-10"), getClinic("Denia"),currPat, sdoc);
        session.save(app18);
//        sdoc.addAppointment(app18);
        session.save(sdoc);

        currPat = getPatient("CLevi");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app19 = new specialDoctorApp(LocalTime.parse("13:00"), LocalDate.parse("2022-01-10"), getClinic("Denia"),currPat, sdoc);
        session.save(app19);
//        sdoc.addAppointment(app19);
        session.save(sdoc);

        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app20 = new specialDoctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-10"), getClinic("Denia"),currPat, sdoc);
        session.save(app20);
//        sdoc.addAppointment(app20);
        session.save(sdoc);

    }


        public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            initClinicsTable();
            initEmployeesTable();
            initPatientsTable();
            initAppointmentsTable();
            initServicesTable();
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
