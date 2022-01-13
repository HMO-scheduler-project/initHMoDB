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
import javax.persistence.criteria.Root;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;


public class App {
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
        configuration.addAnnotatedClass(ClinicServices.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


    private static void initEmployeesTable() throws Exception {
        // create instance of Random class
        Random rand = new Random();
        Clinic clinic;
        String card_num = String.valueOf(Math.abs(rand.nextInt()));
        HMO_Manager employee1 = new HMO_Manager("AGoldstein", "AG1234", "Alex", "Goldstein", card_num, "agoldstein@good_health.com", "054-6329487", "Denia, Neve Shaanan, Hadar, Nesher, Carmel, Romema", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        List<Clinic> clinicList = getAllClinics();
//        employee1.setManaging_clinics(clinicList);
        session.save(employee1);
//        for(Clinic c: clinicList){
//            c.setManager(employee1);
//            session.save(c);
//        }

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee2 = new Manager("RCohen", "RC1234", "Ruth", "Cohen", "clinic manager", card_num, "rcohen@good_health.com", "052-6347812", "Denia", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee2.addManagingClinic(getClinic("Denia"));
        session.save(employee2);
        clinic = getClinic("Denia");
        clinic.setManager(employee2);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee3 = new Manager("MLevi", "ML1234", "Maya", "Levi", "clinic manager", card_num, "mlevi@good_health.com", "050-7481239", "Neve shaanan", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee3.addManagingClinic(getClinic("Neve shaanan"));
        session.save(employee3);
        clinic = getClinic("Neve shaanan");
        clinic.setManager(employee3);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee4 = new SpecialDoctor("DLiberman", "DL1234", "David", "Liberman", "cardiologist", card_num, "dliberman@good_health.com", "050-6374158", "Carmel", null, 15, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"));
//        employee4.addClinic(getClinic("Carmel"));
        session.save(employee4);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee4);
//        session.save(clinic);


        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee5 = new Manager("DAviv", "DA1234", "Dan", "Aviv", "clinic manager", card_num, "daviv@good_health.com", "053-864971", "Nesher", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee5.addManagingClinic(getClinic("Nesher"));
        session.save(employee5);
        clinic = getClinic("Nesher");
        clinic.setManager(employee5);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee6 = new Manager("TShuster", "TS1234", "Tal", "Shuster", "clinic manager", card_num, "tshuster@good_health.com", "053-9641825", "Hadar", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee6.addManagingClinic(getClinic("Hadar"));
        session.save(employee6);
        clinic = getClinic("Hadar");
        clinic.setManager(employee6);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee7 = new Doctor("REldar", "RE1234", "Rachel", "Eldar", "pediatrician", card_num, "reldar@good_health.com", "052-7496152", "Hadar", 3, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee7);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee8 = new Manager("VSilverman", "VS1234", "Valeria", "Silverman", "clinic manager", card_num, "vsilverman@good_health.com", "050-6317859", "Carmel", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee8.addManagingClinic(getClinic("Carmel"));
        session.save(employee8);
        clinic = getClinic("Carmel");
        clinic.setManager(employee8);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee9 = new Doctor("DShitrit", "DS1234", "Dor", "Shitrit", "family_doctor", card_num, "dshitrit@good_health.com", "050-7841528", "Neve shaanan", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee9);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Manager employee10 = new Manager("CSella", "CS1234", "Chen", "Sella", "clinic manager", card_num, "csella@good_health.com", "050-7841256", "Romema", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee10.addManagingClinic(getClinic("Romema"));
        session.save(employee10);
        clinic = getClinic("Romema");
        clinic.setManager(employee10);
        session.update(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee11 = new Doctor("NWeber", "NW1234", "Naama", "Weber", "family_doctor", card_num, "nweber@good_health.com", "052-7841368", "Hadar", 4, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee11);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee12 = new Doctor("ABachar", "AB1234", "Amit", "Bachar", "family_doctor", card_num, "abachar@good_health.com", "052-7481693", "Denia", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee12);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee13 = new Doctor("MPorat", "MP1234", "Moran", "Porat", "family_doctor", card_num, "mporat@good_health.com", "052-7413685", "Nesher", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee13);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee14 = new Doctor("MZeev", "MZ1234", "Maayan", "Zeev", "family_doctor", card_num, "mzeev@good_health.com", "052-8736951", "Romema", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee14);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee15 = new Doctor("RShtein", "RS1234", "Rotem", "Shtein", "family_doctor", card_num, "rshtein@good_health.com", "053-8649571", "Carmel", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee15);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee16 = new Doctor("RBarlev", "RB1234", "Ravit", "Barlev", "pediatrician", card_num, "rbarlev@good_health.com", "053-1259648", "Denia", 3, LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee16);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee17 = new Doctor("GNadler", "GN1234", "Gil", "Nadler", "pediatrician", card_num, "gnadler@good_health.com", "053-4695782", "Neve shaanan", 3, LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee17);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee18 = new Doctor("TRobin", "TR1234", "Tom", "Robin", "pediatrician", card_num, "trobin@good_health.com", "053-1574864", "Nesher", 3, LocalTime.parse("09:00:00"), LocalTime.parse("18:00:00"));
        session.save(employee18);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee19 = new Doctor("EPeretz", "EP1234", "Elinor", "Peretz", "pediatrician", card_num, "eperetz@good_health.com", "053-1497652", "Carmel", 3, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee19);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Doctor employee20 = new Doctor("YHadad", "YH1234", "Yuval", "Hadad", "pediatrician", card_num, "yhadad@good_health.com", "053-1564875", "Romema", 3, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee20);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee21 = new Nurse("SLev", "SL1234", "Shahar", "Lev", card_num, "slev@good_health.com", "053-9576481", "Denia", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee21);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee22 = new Nurse("GShwartz", "GS1234", "Gal", "Shwartz", card_num, "gshwartz@good_health.com", "050-4657821", "Neve shaanan", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
        session.save(employee22);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee23 = new Nurse("SCohen", "SC1234", "Sarit", "Cohen", card_num, "scohen@good_health.com", "050-6854721", "Hadar", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee23);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee24 = new Nurse("IGad", "IG1234", "Ilanit", "Gad", card_num, "igad@good_health.com", "050-9546814", "Nesher", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
        session.save(employee24);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee25 = new Nurse("ALevi", "AL1234", "Adi", "Levi", card_num, "alevi@good_health.com", "050-1142533", "Carmel", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
        session.save(employee25);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        Nurse employee26 = new Nurse("TGrosman", "TG1234", "Tamar", "Grosman", card_num, "tgrosman@good_health.com", "050-4715211", "Romema", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"));
        session.save(employee26);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee27 = new SpecialDoctor("AIsraeli", "AI1234", "Avraham", "Israeli", "ENT doctor", card_num, "aisraeli@good_health.com", "050-8411235", "Neve Shaanan, Hadar, Nesher", null, 7, LocalTime.parse("09:00:00"), LocalTime.parse("19:00:00"));
//        employee27.addClinic(getClinic("Neve Shaanan"));
//        employee27.addClinic(getClinic("Hadar"));
//        employee27.addClinic(getClinic("Nesher"));
        session.save(employee27);
//        clinic = getClinic("Neve Shaanan");
//        clinic.addSpecialist(employee27);
//        session.save(clinic);
//        clinic = getClinic("Hadar");
//        clinic.addSpecialist(employee27);
//        session.save(clinic);
//        clinic = getClinic("Nesher");
//        clinic.addSpecialist(employee27);
//        session.save(clinic);


        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee28 = new SpecialDoctor("MSason", "MS1234", "Miriam", "Sason", "gynecologist", card_num, "msason@good_health.com", "052-3354215", "Carmel, Romema, Denia", null, 9, LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee28.addClinic(getClinic("Carmel"));
//        employee28.addClinic(getClinic("Romema"));
//        employee28.addClinic(getClinic("Denia"));
        session.save(employee28);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee28);
//        session.save(clinic);
//        clinic = getClinic("Romema");
//        clinic.addSpecialist(employee28);
//        session.save(clinic);
//        clinic = getClinic("Denia");
//        clinic.addSpecialist(employee28);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee29 = new SpecialDoctor("SAviram", "SA1234", "Shlomi", "Aviram", "dermatologist", card_num, "saviram@good_health.com", "050-6345587", "Carmel, Nesher", null, 10, LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee29.addClinic(getClinic("Carmel"));
//        employee29.addClinic(getClinic("Nesher"));
        session.save(employee29);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee29);
//        session.save(clinic);
//        clinic = getClinic("Nesher");
//        clinic.addSpecialist(employee29);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee30 = new SpecialDoctor("AMelamed", "AM1234", "Alon", "Melamed", "ophthalmologist", card_num, "amelamed@good_health.com", "050-5148764", "Carmel", null, 11, LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee30.addClinic(getClinic("Carmel"));
        session.save(employee30);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee30);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee31 = new SpecialDoctor("EHadad", "EH1234", "Erez", "Hadad", "ENT doctor", card_num, "ehadad@good_health.com", "050-7461255", "Carmel", null, 12, LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee31.addClinic(getClinic("Carmel"));
        session.save(employee31);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee31);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee32 = new LabWorker("ARodensky", "AR1234", "Anna", "Rodensky", card_num, "arodensky@good_health.com", "050-4788562", "Denia", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee32);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee33 = new LabWorker("AIsraeli", "AI1234", "Alina", "Israeli", card_num, "aisraeli@good_health.com", "050-7544632", "Neve Shaanan", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee33);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee34 = new LabWorker("OAshkenazi", "OA1234", "Oren", "Ashkenazi", card_num, "oashkenazi@good_health.com", "053-8544125", "Hadar", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee34);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee35 = new LabWorker("ABar", "AB1234", "Avital", "Bar", card_num, "abar@good_health.com", "052-1477854", "Nesher", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee35);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee36 = new LabWorker("YShachar", "YS1234", "Yael", "Shachar", card_num, "yshachar@good_health.com", "053-9655321", "Carmel", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee36);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        LabWorker employee37 = new LabWorker("TGil", "TG1234", "Tehila", "Gil", card_num, "tgil@good_health.com", "053-6512447", "Romema", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
        session.save(employee37);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee38 = new SpecialDoctor("NDadon", "ND1234", "Nathan", "Dadon", "neurologist", card_num, "ndadon@good_health.com", "052-6341874", "Carmel", null, 7, LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"));
//        employee38.addClinic(getClinic("Carmel"));
        session.save(employee38);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee38);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee39 = new SpecialDoctor("OTzarfati", "OT1234", "Ofer", "Tzarfati", "gynecologist", card_num, "otzarfati@good_health.com", "053-6547712", "Carmel, Romema", null, 8, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
//        employee39.addClinic(getClinic("Carmel"));
//        employee39.addClinic(getClinic("Romema"));
        session.save(employee39);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee39);
//        session.save(clinic);
//        clinic = getClinic("Romema");
//        clinic.addSpecialist(employee39);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee40 = new SpecialDoctor("DOren", "DO1234", "Dana", "Oren", "ENT doctor", card_num, "doren@good_health.com", "050-3285441", "Carmel", null, 18, LocalTime.parse("14:00:00"), LocalTime.parse("20:00:00"));
//        employee40.addClinic(getClinic("Carmel"));
        session.save(employee40);
//        clinic = getClinic("Carmel");
//        clinic.addSpecialist(employee40);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee41 = new SpecialDoctor("NHadad", "NH1234", "Noa", "Hadad", "neurologist", card_num, "nhadad@good_health.com", "052-6362584", "Nesher", null, 7, LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
//        employee41.addClinic(getClinic("Nesher"));
        session.save(employee41);
//        clinic = getClinic("Nesher");
//        clinic.addSpecialist(employee41);
//        session.save(clinic);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        SpecialDoctor employee42 = new SpecialDoctor("YMoshe", "YM1234", "Yair", "Moshe", "neurologist", card_num, "ymoshe@good_health.com", "052-6384751", "Neve Shaanan, Denia, Romema", null, 7, LocalTime.parse("08:00:00"), LocalTime.parse("16:00:00"));
//        employee42.addClinic(getClinic("Neve Shaanan"));
//        employee42.addClinic(getClinic("Denia"));
//        employee42.addClinic(getClinic("Romema"));
        session.save(employee42);
//        clinic = getClinic("Neve Shaanan");
//        clinic.addSpecialist(employee42);
//        session.save(clinic);
//        clinic = getClinic("Denia");
//        clinic.addSpecialist(employee42);
//        session.save(clinic);
//        clinic = getClinic("Romema");
//        clinic.addSpecialist(employee42);
//        session.save(clinic);
    }

    public static void initServicesTable() {
        ClinicServices service1 = new ClinicServices("covid test", "Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), 2);
        session.save(service1);
        session.flush();
        ClinicServices service2 = new ClinicServices("covid test", "Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 2);
        session.save(service2);
        session.flush();
        ClinicServices service3 = new ClinicServices("covid test", "Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"), 2);
        session.save(service3);
        session.flush();

        ClinicServices service4 = new ClinicServices("covid vaccine", "Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), 5);
        session.save(service4);
        session.flush();
        ClinicServices service5 = new ClinicServices("covid vaccine", "Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 5);
        session.save(service5);
        session.flush();
        ClinicServices service6 = new ClinicServices("covid vaccine", "Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"), 5);
        session.save(service6);
        session.flush();

        ClinicServices service7 = new ClinicServices("influenza vaccine", "Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), 5);
        session.save(service7);
        session.flush();
        ClinicServices service8 = new ClinicServices("influenza vaccine", "Neve shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 5);
        session.save(service8);
        session.flush();
        ClinicServices service9 = new ClinicServices("influenza vaccine", "Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"), 5);
        session.save(service9);
        session.flush();
        ClinicServices service10 = new ClinicServices("influenza vaccine", "Romema", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), 5);
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
        Clinic clinic1 = new Clinic("Denia", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), null, "Libiria 2", "04-8656321");
        clinic1.setSpecialists(true);
        clinic1.setLabServices(true);
        session.save(clinic1);
        session.flush();

        Clinic clinic2 = new Clinic("Neve shaanan", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"), null, "Hagalil 76", "04-8656322");
        clinic2.setSpecialists(true);
        clinic2.setLabServices(true);
        clinic2.setCovidTestService(true);
        clinic2.setCovidVaccine(true);
        clinic2.setInfluenzaVaccine(true);
        session.save(clinic2);
        session.flush();

        Clinic clinic3 = new Clinic("Hadar", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), null, "Herzel 15", "04-8656323");
        clinic3.setSpecialists(true);
        clinic3.setLabServices(true);
        clinic3.setCovidTestService(true);
        clinic3.setCovidVaccine(true);
        clinic3.setInfluenzaVaccine(true);
        session.save(clinic3);
        session.flush();

        Clinic clinic4 = new Clinic("Nesher", "Nesher", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), null, "Haalon 23", "04-8656324");
        clinic4.setSpecialists(true);
        clinic4.setLabServices(true);
        clinic4.setCovidTestService(true);
        clinic4.setCovidVaccine(true);
        clinic4.setInfluenzaVaccine(true);
        session.save(clinic4);
        session.flush();

        Clinic clinic5 = new Clinic("Carmel", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"), null, "Horev 6", "04-8656325");
        clinic5.setSpecialists(true);
        clinic5.setLabServices(true);
        session.save(clinic5);
        session.flush();

        Clinic clinic6 = new Clinic("Romema", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), null, "Levi eshckol 16", "04-8656326");
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
        Doctor doc = getDoctor(9);
        Clinic clinic = getClinic("Neve shaanan");
        Patient pat1 = new Patient("DHolland", "DH1234", "Dana", "Holland", doc
                , LocalDate.parse("1990-12-10"), card_num, "DHolland@life.com", "052-6574123", clinic, null);
        session.save(pat1);
//        clinic.addPatient(pat1);
//        session.save(clinic);
//        doc.addPatient(pat1);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(19);
        clinic = getClinic("Carmel");
        Patient pat2 = new Patient("YChen", "YC1234", "Yonathan", "Chen", doc
                , LocalDate.parse("2012-09-18"), card_num, "YChen@life.com", "050-4875326", clinic, null);
        session.save(pat2);
//        clinic.addPatient(pat2);
//        session.save(clinic);
//        doc.addPatient(pat2);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(7);
        clinic = getClinic("Hadar");
        Patient pat3 = new Patient("CLevi", "CL1234", "Chen", "Levi", doc
                , LocalDate.parse("2020-06-18"), card_num, "CLevi@life.com", "053-6589514", clinic, null);
        session.save(pat3);
//        clinic.addPatient(pat3);
//        session.save(clinic);
//        doc.addPatient(pat3);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(9);
        clinic = getClinic("Neve shaanan");
        Patient pat4 = new Patient("RGil", "RG1234", "Ronna", "Gil", doc
                , LocalDate.parse("1945-06-21"), card_num, "RGil@life.com", "058-8645711", clinic, null);
        session.save(pat4);
//        clinic.addPatient(pat4);
//        session.save(clinic);
//        doc.addPatient(pat4);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(13);
        clinic = getClinic("Nesher");
        Patient pat5 = new Patient("TShitrit", "TS1234", "Tali", "Shitrit", doc
                , LocalDate.parse("1996-05-14"), card_num, "TShitrit@life.com", "053-6487125", clinic, null);
        session.save(pat5);
//        clinic.addPatient(pat5);
//        session.save(clinic);
//        doc.addPatient(pat5);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(14);
        clinic = getClinic("Romema");
        Patient pat6 = new Patient("NSabag", "NS1234", "Noga", "Sabag", doc
                , LocalDate.parse("2001-07-21"), card_num, "NSabag@life.com", "058-9654871", clinic, null);
        session.save(pat6);
//        clinic.addPatient(pat6);
//        session.save(clinic);
//        doc.addPatient(pat6);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(15);
        clinic = getClinic("Carmel");
        Patient pat7 = new Patient("DCohen", "DC1234", "Dor", "Cohen", doc
                , LocalDate.parse("1984-03-08"), card_num, "DCohen@life.com", "058-6574128", clinic, null);
        session.save(pat7);
//        clinic.addPatient(pat7);
//        session.save(clinic);
//        doc.addPatient(pat7);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(16);
        clinic = getClinic("Denia");
        Patient pat8 = new Patient("SGold", "SG1234", "Shon", "Gold", doc
                , LocalDate.parse("2014-09-17"), card_num, "SGold@life.com", "054-9675214", clinic, null);
        session.save(pat8);
//        clinic.addPatient(pat8);
//        session.save(clinic);
//        doc.addPatient(pat8);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(12);
        clinic = getClinic("Denia");
        Patient pat9 = new Patient("IMoskovitz", "IM1234", "Israel", "Moskovitz", doc
                , LocalDate.parse("1974-05-19"), card_num, "IMoskovitz@life.com", "054-9658412", clinic, null);
        session.save(pat9);
//        clinic.addPatient(pat9);
//        session.save(clinic);
//        doc.addPatient(pat9);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(9);
        clinic = getClinic("Neve shaanan");
        Patient pat10 = new Patient("MHadad", "MH1234", "Moshe", "Hadad", doc
                , LocalDate.parse("1964-03-21"), card_num, "MHadad@life.com", "054-7832654", clinic, null);
        session.save(pat10);
//        clinic.addPatient(pat10);
//        session.save(clinic);
//        doc.addPatient(pat10);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(11);
        clinic = getClinic("Hadar");
        Patient pat11 = new Patient("MRosen", "MR1234", "Maayan", "Rosen", doc
                , LocalDate.parse("1999-03-27"), card_num, "MRosen@life.com", "054-5247863", clinic, null);
        session.save(pat11);
//        clinic.addPatient(pat11);
//        session.save(clinic);
//        doc.addPatient(pat11);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(11);
        clinic = getClinic("Hadar");
        Patient pat12 = new Patient("YCohen", "YC1234", "Yosef", "Cohen", doc
                , LocalDate.parse("1952-03-14"), card_num, "YCohen@life.com", "054-5487234", clinic, null);
        session.save(pat12);
//        clinic.addPatient(pat12);
//        session.save(clinic);
//        doc.addPatient(pat12);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(9);
        clinic = getClinic("Neve shaanan");
        Patient pat13 = new Patient("ARaviv", "AR1234", "Alma", "Raviv", doc
                , LocalDate.parse("2013-02-21"), card_num, "ARaviv@life.com", "052-2539861", clinic, null);
        session.save(pat13);
//        clinic.addPatient(pat13);
//        session.save(clinic);
//        doc.addPatient(pat13);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(16);
        clinic = getClinic("Denia");
        Patient pat14 = new Patient("ADanker", "AD1234", "Alon", "Danker", doc
                , LocalDate.parse("2016-12-30"), card_num, "ADanker@life.com", "053-2314597", clinic, null);
        session.save(pat14);
//        clinic.addPatient(pat14);
//        session.save(clinic);
//        doc.addPatient(pat14);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(12);
        clinic = getClinic("Denia");
        Patient pat15 = new Patient("DMesika", "DM1234", "Dor", "Mesika", doc
                , LocalDate.parse("1992-11-24"), card_num, "DMesika@life.com", "053-6952417", clinic, null);
        session.save(pat15);
//        clinic.addPatient(pat15);
//        session.save(clinic);
//        doc.addPatient(pat15);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(11);
        clinic = getClinic("Hadar");
        Patient pat16 = new Patient("GAloni", "GA1234", "Galit", "Aloni", doc
                , LocalDate.parse("1984-08-11"), card_num, "GAloni@life.com", "053-8645971", clinic, null);
        session.save(pat16);
//        clinic.addPatient(pat16);
//        session.save(clinic);
//        doc.addPatient(pat16);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(7);
        clinic = getClinic("Hadar");
        Patient pat17 = new Patient("TAloni", "TA1234", "Talya", "Aloni", doc
                , LocalDate.parse("2021-10-15"), card_num, "GAloni@life.com", "053-8645971", clinic, null);
        session.save(pat17);
//        clinic.addPatient(pat17);
//        session.save(clinic);
//        doc.addPatient(pat17);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(11);
        clinic = getClinic("Hadar");
        Patient pat18 = new Patient("DAloni", "DA1234", "David", "Aloni", doc
                , LocalDate.parse("1980-08-14"), card_num, "DAloni@life.com", "053-5326987", clinic, null);
        session.save(pat18);
//        clinic.addPatient(pat18);
//        session.save(clinic);
//        doc.addPatient(pat18);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(15);
        clinic = getClinic("Carmel");
        Patient pat19 = new Patient("RRosen", "RR1234", "Rivka", "Rosen", doc
                , LocalDate.parse("1974-06-12"), card_num, "RRosen@life.com", "053-3652471", clinic, null);
        session.save(pat19);
//        clinic.addPatient(pat19);
//        session.save(clinic);
//        doc.addPatient(pat19);
//        session.save(doc);

        card_num = String.valueOf(Math.abs(rand.nextInt()));
        doc = getDoctor(15);
        clinic = getClinic("Carmel");
        Patient pat20 = new Patient("AZehavi", "AZ1234", "Avia", "Zehavi", doc
                , LocalDate.parse("1962-05-11"), card_num, "AZehavi@life.com", "053-5148475", clinic, null);
        session.save(pat20);
//        clinic.addPatient(pat20);
//        session.save(clinic);
//        doc.addPatient(pat20);
//        session.save(doc);
    }

    private static Patient getPatient(String username) {
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

    private static SpecialDoctor getSpecialDoctor(int Id) {
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
        Doctor doc = currPat.getDoctor();
        SpecialDoctor sdoc;
        doctorApp app1 = new doctorApp(LocalTime.parse("10:00"), LocalDate.parse("2022-01-18"), currPat.getClinic(), currPat, doc);
        session.save(app1);
//        doc.addAppointment(app1);
//        session.save(doc);
//        currPat.addAppointment(app1);
//        session.save(currPat);
//        app1.getClinic().addAppointment(app1);
//        session.save(app1);

        currPat = getPatient("DHolland");
        LabWorker labWorker = getLabWorkerByUsername("ABar");
        Covid19VaccineApp covid19VaccineApp = new Covid19VaccineApp(LocalTime.parse("08:45"), LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        covid19VaccineApp.setArrived(true);
        session.save(covid19VaccineApp);

        currPat = getPatient("SGold");
        doc = currPat.getDoctor();
        doctorApp app2 = new doctorApp(LocalTime.parse("09:00"), LocalDate.parse("2022-01-19"), currPat.getClinic(), currPat, doc);
        session.save(app2);
//        doc.addAppointment(app2);
//        session.save(doc);
//        currPat.addAppointment(app2);
//        session.save(currPat);
//        app2.getClinic().addAppointment(app2);
//        session.save(app2);

        currPat = getPatient("NSabag");
        doc = currPat.getDoctor();
        doctorApp app3 = new doctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-20"), currPat.getClinic(), currPat, doc);
        session.save(app3);
//        doc.addAppointment(app3);
//        session.save(doc);
//        currPat.addAppointment(app3);
//        session.save(currPat);
//        app3.getClinic().addAppointment(app3);
//        session.save(app3);

        currPat = getPatient("TShitrit");
        doc = currPat.getDoctor();
        doctorApp app4 = new doctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-23"), currPat.getClinic(), currPat, doc);
        session.save(app4);
//        doc.addAppointment(app4);
//        session.save(doc);
//        currPat.addAppointment(app4);
//        session.save(currPat);
//        app4.getClinic().addAppointment(app4);
//        session.save(app4);

        currPat = getPatient("YChen");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app5 = new specialDoctorApp(LocalTime.parse("08:30"), LocalDate.parse("2022-01-23"), getClinic("Carmel"), currPat, sdoc);
        session.save(app5);
//        sdoc.addAppointment(app5);
//        session.save(sdoc);
//        currPat.addAppointment(app5);
//        session.save(currPat);
//        app5.getClinic().addAppointment(app5);
//        session.save(app5);

        currPat = getPatient("CLevi");
        specialDoctorApp app6 = new specialDoctorApp(LocalTime.parse("12:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"), currPat, sdoc);
        session.save(app6);
//        sdoc.addAppointment(app6);
//        session.save(sdoc);
//        currPat.addAppointment(app6);
//        session.save(currPat);
//        app6.getClinic().addAppointment(app6);
//        session.save(app6);

        currPat = getPatient("RGil");
        sdoc = getSpecialDoctor(30);
        specialDoctorApp app7 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-19"), getClinic("Carmel"), currPat, sdoc);
        session.save(app7);
//        sdoc.addAppointment(app7);
//        session.save(sdoc);
//        currPat.addAppointment(app7);
//        session.save(currPat);
//        app7.getClinic().addAppointment(app7);
//        session.save(app7);

        currPat = getPatient("TShitrit");
        specialDoctorApp app8 = new specialDoctorApp(LocalTime.parse("15:00"), LocalDate.parse("2022-01-19"), getClinic("Carmel"), currPat, sdoc);
        session.save(app8);
//        sdoc.addAppointment(app8);
//        session.save(sdoc);
//        currPat.addAppointment(app8);
//        session.save(currPat);
//        app8.getClinic().addAppointment(app8);
//        session.save(app8);

        currPat = getPatient("RGil");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app9 = new specialDoctorApp(LocalTime.parse("15:30"), LocalDate.parse("2022-01-18"), getClinic("Carmel"), currPat, sdoc);
        session.save(app9);
//        sdoc.addAppointment(app9);
//        session.save(sdoc);
//        currPat.addAppointment(app9);
//        session.save(currPat);
//        app9.getClinic().addAppointment(app9);
//        session.save(app9);

        currPat = getPatient("DCohen");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app10 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-20"), getClinic("Carmel"), currPat, sdoc);
        session.save(app10);
//        sdoc.addAppointment(app10);
//        session.save(sdoc);
//        currPat.addAppointment(app10);
//        session.save(currPat);
//        app10.getClinic().addAppointment(app10);
//        session.save(app10);

        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app11 = new specialDoctorApp(LocalTime.parse("19:50"), LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app11);
//        sdoc.addAppointment(app11);
//        session.save(sdoc);
//        currPat.addAppointment(app11);
//        session.save(currPat);
//        app11.getClinic().addAppointment(app11);
//        session.save(app11);

        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app12 = new specialDoctorApp(LocalTime.parse("11:00"), LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app12);
//        sdoc.addAppointment(app12);
//        session.save(sdoc);
//        currPat.addAppointment(app12);
//        session.save(currPat);
//        app12.getClinic().addAppointment(app12);
//        session.save(app12);

        currPat = getPatient("TShitrit");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app13 = new specialDoctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app13);
//        sdoc.addAppointment(app13);
//        session.save(sdoc);
//        currPat.addAppointment(app13);
//        session.save(currPat);
//        app13.getClinic().addAppointment(app13);
//        session.save(app13);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app14 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app14);
//        sdoc.addAppointment(app14);
//        session.save(sdoc);
//        currPat.addAppointment(app14);
//        session.save(currPat);
//        app14.getClinic().addAppointment(app14);
//        session.save(app14);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(39);
        specialDoctorApp app15 = new specialDoctorApp(LocalTime.parse("11:30"), LocalDate.parse("2022-01-12"), getClinic("Romema"), currPat, sdoc);
        session.save(app15);
//        sdoc.addAppointment(app15);
//        session.save(sdoc);
//        currPat.addAppointment(app15);
//        session.save(currPat);
//        app15.getClinic().addAppointment(app15);
//        session.save(app15);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app16 = new specialDoctorApp(LocalTime.parse("15:00"), LocalDate.parse("2022-01-11"), getClinic("Romema"), currPat, sdoc);
        session.save(app16);
//        sdoc.addAppointment(app16);
//        session.save(sdoc);
//        currPat.addAppointment(app16);
//        session.save(currPat);
//        app16.getClinic().addAppointment(app16);
//        session.save(app16);

        currPat = getPatient("SGold");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app17 = new specialDoctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-11"), getClinic("Denia"), currPat, sdoc);
        session.save(app17);
//        sdoc.addAppointment(app17);
//        session.save(sdoc);
//        currPat.addAppointment(app17);
//        session.save(currPat);
//        app17.getClinic().addAppointment(app17);
//        session.save(app17);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app18 = new specialDoctorApp(LocalTime.parse("13:40"), LocalDate.parse("2022-01-12"), getClinic("Denia"), currPat, sdoc);
        session.save(app18);
//        sdoc.addAppointment(app18);
//        session.save(sdoc);
//        currPat.addAppointment(app18);
//        session.save(currPat);
//        app18.getClinic().addAppointment(app18);
//        session.save(app18);

        currPat = getPatient("CLevi");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app19 = new specialDoctorApp(LocalTime.parse("13:00"), LocalDate.parse("2022-01-10"), getClinic("Denia"), currPat, sdoc);
        session.save(app19);
//        sdoc.addAppointment(app19);
//        session.save(sdoc);
//        currPat.addAppointment(app19);
//        session.save(currPat);
//        app19.getClinic().addAppointment(app19);
//        session.save(app19);

        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app20 = new specialDoctorApp(LocalTime.parse("12:00"), LocalDate.parse("2022-01-10"), getClinic("Denia"), currPat, sdoc);
        session.save(app20);
//        sdoc.addAppointment(app20);
//        session.save(sdoc);
//        currPat.addAppointment(app20);
//        session.save(currPat);
//        app20.getClinic().addAppointment(app20);
//        session.save(app20);
        currPat = getPatient("CLevi");
        labWorker = getLabWorkerByUsername("TGil");
        InfluenzaVaccineApp influenzaVaccineApp = new InfluenzaVaccineApp(LocalTime.parse("08:45"), LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(influenzaVaccineApp);
        currPat = getPatient("CLevi");
        labWorker = getLabWorkerByUsername("TGil");
        Covid19Test covid19Test = new Covid19Test(LocalTime.parse("13:10"), LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(covid19Test);
        currPat = getPatient("CLevi");
        labWorker = getLabWorkerByUsername("TGil");
        LabApp labApp = new LabApp(LocalTime.parse("09:00"), LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(labApp);
        currPat = getPatient("CLevi");
        Nurse nurse = getNurseByUsername("SCohen");
        NurseApp nurseApp = new NurseApp(LocalTime.parse("10:10"), LocalDate.parse("2022-01-13"), getClinic(labWorker.main_clinic), currPat, nurse);
        session.save(nurseApp);
    }

    public static LabWorker getLabWorkerByUsername(String username) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LabWorker> query = builder.createQuery(LabWorker.class);
        Root<LabWorker> root = query.from(LabWorker.class);
        query.select(root);
        query.where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
    }
    public static Nurse getNurseByUsername(String username) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Nurse> query = builder.createQuery(Nurse.class);
        Root<Nurse> root = query.from(Nurse.class);
        query.select(root);
        query.where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
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
