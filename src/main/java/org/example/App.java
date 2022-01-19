package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.time.temporal.TemporalAdjusters.previous;

public class App {
    private static Session session;

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(AwaitingTimeRep.class);
        configuration.addAnnotatedClass(MissedAppRep.class);
        configuration.addAnnotatedClass(ServicesTypeRep.class);

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
        configuration.addAnnotatedClass(MessageToManager.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static void initEmployeesTable() throws Exception {
        // create instance of Random class
        Random rand = new Random();
        Clinic clinic;
        String card_num = "111000";
//        HMO_Manager employee1122 = new HMO_Manager("username", "password", "name", "lastname", card_num, "email@good_health.com", "054-1234567", "Denia, Neve Shaanan, Hadar, Nesher, Carmel, Romema", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
////        List<Clinic> clinicList = getAllClinics();
////        employee1.setManaging_clinics(clinicList);
//        session.save(employee1122);
////        for(Clinic c: clinicList){
////            c.setManager(employee1);
////            session.save(c);
////        }


        // create instance of Random class
         card_num = String.valueOf(Math.abs(rand.nextInt()));
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
        Manager employee3 = new Manager("MLevi", "ML1234", "Maya", "Levi", "clinic manager", card_num, "mlevi@good_health.com", "050-7481239", "Neve Shaanan", null, 1, LocalTime.parse("09:00:00"), LocalTime.parse("17:00:00"));
//        employee3.addManagingClinic(getClinic("Neve shaanan"));
        session.save(employee3);
        clinic = getClinic("Neve Shaanan");
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
        Doctor employee9 = new Doctor("DShitrit", "DS1234", "Dor", "Shitrit", "family_doctor", card_num, "dshitrit@good_health.com", "050-7841528", "Neve Shaanan", 4, LocalTime.parse("08:00:00"), LocalTime.parse("17:00:00"));
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
        Doctor employee17 = new Doctor("GNadler", "GN1234", "Gil", "Nadler", "pediatrician", card_num, "gnadler@good_health.com", "053-4695782", "Neve Shaanan", 3, LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"));
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
        Nurse employee22 = new Nurse("GShwartz", "GS1234", "Gal", "Shwartz", card_num, "gshwartz@good_health.com", "050-4657821", "Neve Shaanan", null, 5, LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"));
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
        LabWorker employee33 = new LabWorker("MIsraeli", "AI1234", "Marina", "Israeli", card_num, "misraeli@good_health.com", "050-7544632", "Neve Shaanan", null, 2, LocalTime.parse("08:00:00"), LocalTime.parse("10:00:00"));
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
        ClinicServices service2 = new ClinicServices("covid test", "Neve Shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 2);
        session.save(service2);
        session.flush();
        ClinicServices service3 = new ClinicServices("covid test", "Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"), 2);
        session.save(service3);
        session.flush();

        ClinicServices service4 = new ClinicServices("covid vaccine", "Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), 5);
        session.save(service4);
        session.flush();
        ClinicServices service5 = new ClinicServices("covid vaccine", "Neve Shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 5);
        session.save(service5);
        session.flush();
        ClinicServices service6 = new ClinicServices("covid vaccine", "Nesher", LocalTime.parse("08:00:00"), LocalTime.parse("18:00:00"), 5);
        session.save(service6);
        session.flush();

        ClinicServices service7 = new ClinicServices("influenza vaccine", "Hadar", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), 5);
        session.save(service7);
        session.flush();
        ClinicServices service8 = new ClinicServices("influenza vaccine", "Neve Shaanan", LocalTime.parse("08:00:00"), LocalTime.parse("20:00:00"), 5);
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

        Clinic clinic2 = new Clinic("Neve Shaanan", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"), null, "Hagalil 76", "04-8656322");
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
        Clinic clinic = getClinic("Neve Shaanan");
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
        clinic = getClinic("Neve Shaanan");
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
        clinic = getClinic("Neve Shaanan");
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
        clinic = getClinic("Neve Shaanan");
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
        Covid19VaccineApp covid19VaccineApp = new Covid19VaccineApp(LocalTime.parse("10:00"),  LocalTime.parse("00:00"),false, LocalDate.parse("2022-01-09"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(covid19VaccineApp);
        covid19VaccineApp = new Covid19VaccineApp(LocalTime.parse("08:45"),LocalTime.parse("09:00"),true, LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        currPat = getPatient("SGold");
        covid19VaccineApp = new Covid19VaccineApp(LocalTime.parse("09:00"), LocalTime.parse("00:00"),false, LocalDate.parse("2022-01-09"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(covid19VaccineApp);
        covid19VaccineApp = new Covid19VaccineApp(LocalTime.parse("08:45"),LocalTime.parse("09:00"),true, LocalDate.parse("2022-01-11"), getClinic(labWorker.main_clinic), currPat, labWorker);
        session.save(covid19VaccineApp);

        currPat = getPatient("SGold");
        doc = currPat.getDoctor();
        doctorApp app2 = new doctorApp (LocalTime.parse("08:45"),LocalTime.parse("09:00"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        session.save(app2);
//        doc.addAppointment(app2);
//        session.save(doc);
//        currPat.addAppointment(app2);
//        session.save(currPat);
//        app2.getClinic().addAppointment(app2);
//        session.save(app2);

        currPat = getPatient("NSabag");
        doc = currPat.getDoctor();
        doctorApp app3 = new doctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:30"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app3);
        currPat = getPatient("NSabag");
        doc = currPat.getDoctor();
        doctorApp app33 = new doctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:07"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        session.save(app33);

        currPat = getPatient("TShitrit");
        doc = currPat.getDoctor();
        doctorApp app4 = new doctorApp(LocalTime.parse("14:00"), LocalTime.parse("00:00"),false, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app44 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:12"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app44);
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
        currPat = getPatient("TShitrit");
        doc = currPat.getDoctor();
        doctorApp app = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:00"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app);
        app = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:15"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        session.save(app);
        app = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:12"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app);
        currPat = getPatient("DCohen");
        sdoc = getSpecialDoctor(27);
        app = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:00"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app);
        app = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:30"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        session.save(app);
        app = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:27"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app);


        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(27);
        specialDoctorApp app11 = new specialDoctorApp(LocalTime.parse("19:50"),LocalTime.parse("19:53"), true,LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app11);
//        sdoc.addAppointment(app11);
//        session.save(sdoc);
//        currPat.addAppointment(app11);
//        session.save(currPat);
//        app11.getClinic().addAppointment(app11);
//        session.save(app11);

        currPat = getPatient("DHolland");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app12 = new specialDoctorApp(LocalTime.parse("11:00"), LocalTime.parse("11:09"),true,LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app12);
//        sdoc.addAppointment(app12);
//        session.save(sdoc);
//        currPat.addAppointment(app12);
//        session.save(currPat);
//        app12.getClinic().addAppointment(app12);
//        session.save(app12);

        currPat = getPatient("TShitrit");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app13 = new specialDoctorApp(LocalTime.parse("12:00"), LocalTime.parse("00:00"),false, LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app13);
//        sdoc.addAppointment(app13);
//        session.save(sdoc);
//        currPat.addAppointment(app13);
//        session.save(currPat);
//        app13.getClinic().addAppointment(app13);
//        session.save(app13);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(38);
        specialDoctorApp app14 = new specialDoctorApp(LocalTime.parse("11:30"),LocalTime.parse("11:42"),true, LocalDate.parse("2022-01-12"), getClinic("Carmel"), currPat, sdoc);
        session.save(app14);
//        sdoc.addAppointment(app14);
//        session.save(sdoc);
//        currPat.addAppointment(app14);
//        session.save(currPat);
//        app14.getClinic().addAppointment(app14);
//        session.save(app14);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(39);
        specialDoctorApp app15 = new specialDoctorApp(LocalTime.parse("11:30"),LocalTime.parse("11:47"),true, LocalDate.parse("2022-01-12"), getClinic("Romema"), currPat, sdoc);
        session.save(app15);
//        sdoc.addAppointment(app15);
//        session.save(sdoc);
//        currPat.addAppointment(app15);
//        session.save(currPat);
//        app15.getClinic().addAppointment(app15);
//        session.save(app15);

        currPat = getPatient("NSabag");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app16 = new specialDoctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:07"),true, LocalDate.parse("2022-01-11"), getClinic("Romema"), currPat, sdoc);
        session.save(app16);
//        sdoc.addAppointment(app16);
//        session.save(sdoc);
//        currPat.addAppointment(app16);
//        session.save(currPat);
//        app16.getClinic().addAppointment(app16);
//        session.save(app16);

        currPat = getPatient("SGold");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app17 = new specialDoctorApp(LocalTime.parse("14:00"), LocalDate.parse("2022-01-20"), getClinic("Denia"), currPat, sdoc);
        session.save(app17);
//        sdoc.addAppointment(app17);
//        session.save(sdoc);
//        currPat.addAppointment(app17);
//        session.save(currPat);
//        app17.getClinic().addAppointment(app17);
//        session.save(app17);

        currPat = getPatient("IMoskovitz");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app18 = new specialDoctorApp(LocalTime.parse("13:40"),LocalTime.parse("13:46"),true, LocalDate.parse("2022-01-12"), getClinic("Denia"), currPat, sdoc);
        session.save(app18);
//        sdoc.addAppointment(app18);
//        session.save(sdoc);
//        currPat.addAppointment(app18);
//        session.save(currPat);
//        app18.getClinic().addAppointment(app18);
//        session.save(app18);

        currPat = getPatient("CLevi");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app19 = new specialDoctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:12"),true, LocalDate.parse("2022-01-10"), getClinic("Denia"), currPat, sdoc);
        session.save(app19);
//        sdoc.addAppointment(app19);
//        session.save(sdoc);
//        currPat.addAppointment(app19);
//        session.save(currPat);
//        app19.getClinic().addAppointment(app19);
//        session.save(app19);

        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        specialDoctorApp app20 = new specialDoctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:06"),true, LocalDate.parse("2022-01-10"), getClinic("Denia"), currPat, sdoc);
        session.save(app20);
//        sdoc.addAppointment(app20);
//        session.save(sdoc);
//        currPat.addAppointment(app20);
//        session.save(currPat);
//        app20.getClinic().addAppointment(app20);
//        session.save(app20);

        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        app20 = new specialDoctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:10"),true, LocalDate.parse("2022-01-10"), getClinic("Denia"), currPat, sdoc);
        session.save(app20);
        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        app20 = new specialDoctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:10"),true, LocalDate.parse("2022-01-11"), getClinic("Neve Shaanan"), currPat, sdoc);
        session.save(app20);
        currPat = getPatient("MRosen");
        sdoc = getSpecialDoctor(42);
        app20 = new specialDoctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:10"),true, LocalDate.parse("2022-01-12"), getClinic("Hadar"), currPat, sdoc);
        session.save(app20);
        app20 = new specialDoctorApp(LocalTime.parse("13:50"),LocalTime.parse("14:10"),true, LocalDate.parse("2022-01-12"), getClinic("Hadar"), currPat, sdoc);
        session.save(app20);
        app20 = new specialDoctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:10"),true, LocalDate.parse("2022-01-13"), getClinic("Hadar"), currPat, sdoc);
        session.save(app20);
        app20 = new specialDoctorApp(LocalTime.parse("13:50"),LocalTime.parse("14:10"),true, LocalDate.parse("2022-01-13"), getClinic("Hadar"), currPat, sdoc);
        session.save(app20);

        currPat = getPatient("DHolland");
        LabWorker worker = getLabWorkerByUsername("MIsraeli");
        Covid19VaccineApp app30 = new Covid19VaccineApp(LocalTime.parse("14:30"), LocalDate.parse("2022-01-12"), getClinic("Neve Shaanan"), currPat, worker);
        app30.setActual_time(LocalTime.parse("14:31"));
        app30.setArrived(true);
        session.save(app30);

        //data for presentation-----------------------------------------------------------

        doc = getDoctor(16);        //first doc
        currPat = getPatient("TShitrit");
        doctorApp app100 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:12"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        doctorApp app101 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:12"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app102 = new doctorApp(LocalTime.parse("16:00"),LocalTime.parse("16:12"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app100);
        session.save(app101);
        session.save(app102);
        currPat = getPatient("MRosen");
        doctorApp app103 = new doctorApp(LocalTime.parse("11:00"),LocalTime.parse("11:07"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        doctorApp app104 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:07"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        doctorApp app105 = new doctorApp(LocalTime.parse("09:00"),LocalTime.parse("09:07"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        session.save(app103);
        session.save(app104);
        session.save(app105);
        currPat = getPatient("CLevi");
        doctorApp app106 = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:16"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        doctorApp app107 = new doctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:16"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app108 = new doctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:16"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        session.save(app106);
        session.save(app107);
        session.save(app108);
        currPat = getPatient("IMoskovitz");
        doctorApp app109 = new doctorApp(LocalTime.parse("09:00"),LocalTime.parse("09:12"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        doctorApp app110 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:12"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        doctorApp app111 = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:12"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        session.save(app109);
        session.save(app110);
        session.save(app111);
        currPat = getPatient("SGold");
        doctorApp app112 = new doctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:05"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        doctorApp app113 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:05"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app114 = new doctorApp(LocalTime.parse("11:00"),LocalTime.parse("11:05"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        session.save(app112);
        session.save(app113);
        session.save(app114);

        doc = getDoctor(12);        //second doc
        currPat = getPatient("TShitrit");
        doctorApp app115 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:12"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        doctorApp app116 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:12"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        doctorApp app117 = new doctorApp(LocalTime.parse("16:00"),LocalTime.parse("16:12"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        session.save(app115);
        session.save(app116);
        session.save(app117);
        currPat = getPatient("MRosen");
        doctorApp app118 = new doctorApp(LocalTime.parse("11:00"),LocalTime.parse("11:07"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app119 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:07"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        doctorApp app120 = new doctorApp(LocalTime.parse("09:00"),LocalTime.parse("09:07"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app118);
        session.save(app119);
        session.save(app120);
        currPat = getPatient("CLevi");
        doctorApp app121 = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:16"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        doctorApp app122 = new doctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:16"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        doctorApp app123 = new doctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:16"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        session.save(app121);
        session.save(app122);
        session.save(app123);
        currPat = getPatient("IMoskovitz");
        doctorApp app124 = new doctorApp(LocalTime.parse("09:00"),LocalTime.parse("09:12"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app125 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:12"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        doctorApp app126 = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:12"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app124);
        session.save(app125);
        session.save(app126);
        currPat = getPatient("SGold");
        doctorApp app127 = new doctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:05"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        doctorApp app128 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:05"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        doctorApp app129 = new doctorApp(LocalTime.parse("11:00"),LocalTime.parse("11:05"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        session.save(app127);
        session.save(app128);
        session.save(app129);

        doc = getDoctor(21);        //third nurse
        currPat = getPatient("TShitrit");
        doctorApp app130 = new doctorApp(LocalTime.parse("14:00"),LocalTime.parse("14:12"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app131 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:12"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        doctorApp app132 = new doctorApp(LocalTime.parse("16:00"),LocalTime.parse("16:12"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app130);
        session.save(app131);
        session.save(app132);
        currPat = getPatient("MRosen");
        doctorApp app133 = new doctorApp(LocalTime.parse("11:00"),LocalTime.parse("11:07"),true, LocalDate.parse("2022-01-12"), currPat.getClinic(), currPat, doc);
        doctorApp app134 = new doctorApp(LocalTime.parse("15:00"),LocalTime.parse("15:07"),true, LocalDate.parse("2022-01-14"), currPat.getClinic(), currPat, doc);
        doctorApp app135 = new doctorApp(LocalTime.parse("09:00"),LocalTime.parse("09:07"),true, LocalDate.parse("2022-01-10"), currPat.getClinic(), currPat, doc);
        session.save(app133);
        session.save(app134);
        session.save(app135);
        currPat = getPatient("CLevi");
        doctorApp app136 = new doctorApp(LocalTime.parse("10:00"),LocalTime.parse("10:16"),true, LocalDate.parse("2022-01-11"), currPat.getClinic(), currPat, doc);
        doctorApp app137 = new doctorApp(LocalTime.parse("13:00"),LocalTime.parse("13:16"),true, LocalDate.parse("2022-01-13"), currPat.getClinic(), currPat, doc);
        doctorApp app138 = new doctorApp(LocalTime.parse("12:00"),LocalTime.parse("12:16"),true, LocalDate.parse("2022-01-09"), currPat.getClinic(), currPat, doc);
        session.save(app136);
        session.save(app137);
        session.save(app138);




    }
    public static void initMessagesToManager(){
        String body = "Hi Valeria"+"\nI need to go on vacation on 24.2.22."+"\nThanks in advance"+"\nNathan Dadon";
        MessageToManager msg = new MessageToManager("Nathan Dadon","Valeria Silverman","vacation request",body);
        session.save(msg);
        body = "Hi Valeria\n"+"I need to go on vacation between 13.2 till 14.2.\n"+"Thanks in advance and have a nice day\n"+"Adi Levi";
//        msg = new MessageToManager("Adi Levi","Valeria Silverman","vacation request",body);
//        session.save(msg);
//        msg = new MessageToManager("Elinor Peretz","Valeria Silverman","Leaving early on next Wednesday","Hi Valeria\nI need to leave early on next wednesday 26.2.2022 due to PTA meeting.\nThanks in advance and have a nice day\nElinor Peretz");
//        session.save(msg);
//        msg = new MessageToManager("Amit Bachar","Ruth Cohen","Sick days","Hi Ruth\nI was out sick from 12-14.2.2022.I left the sickness confirmation at the office.\nPlease report those days in the system.\nThanks in advance\nAmit Bachar");
//        session.save(msg);
//        msg = new MessageToManager("Shahar Lev","Ruth Cohen","Vacation request","Hi Ruth\nI need to go on vacation between 13-15.2.22.\nPlease approve my request.\nThanks in advance and have a nice day\nShahar Lev");
//        session.save(msg);
//        msg = new MessageToManager("Anna Rodensky","Ruth Cohen","Inventory","Dear Ruth\nAs you are well aware we had an inventory yesterday.\nWe need to order more gloves,test tubes and septol.\nThanks in advance\nAnna Rodensky");
//        session.save(msg);
    }

    public static LabWorker getLabWorkerByUsername(String username) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LabWorker> query = builder.createQuery(LabWorker.class);
        Root<LabWorker> root = query.from(LabWorker.class);
        query.select(root);
        query.where(builder.equal(root.get("username"), username));
        return session.createQuery(query).getSingleResult();
    }
    private static void initReports() {
        List<Clinic> ClinicList = getAllClinicsFromDB();
        LocalDate Saturday = GetLastSaturday();
        LocalDate Sunday = GetLastSunday(Saturday);
        // List<Clinic> ClinicList = Main.session.createQuery(query).getResultList();
        ClearAwaitingTimeReport();
        ClearMissedAppReport();
        ClearServicesTypeReport();
        System.out.println("Getting Report Between the dates:" + Sunday + "And" + Saturday);
        for (Clinic clinic : ClinicList) {
            CreateMissedAppRepForClinic(clinic, Sunday, Saturday);
            CreateServicesTypeReportForClinic(clinic, Sunday, Saturday);
            CreateAwaitingTimeRepForClinic(clinic, Sunday, Saturday);
        }
//            Main.session.getTransaction().commit(); // Save everything.
//        } catch (Exception exception) {
//            if (Main.session != null) {
//                Main.session.getTransaction().rollback();
//            }
//            System.err.println("An error occurred, changes have been rolled back.");
//            exception.printStackTrace();
//        } finally {
//            if (Main.session != null) {
//                Main.session.close();
//            }
//        }



    }
    public static List<Clinic> getAllClinicsFromDB() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Clinic> query = builder.createQuery(Clinic.class);
        query.from(Clinic.class);
        return session.createQuery(query).getResultList();
    }
    public static void ClearServicesTypeReport() {
        //clear the report table
// session.createQuery("delete from ServicesTypeRep").executeUpdate();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<ServicesTypeRep> query = builder.createQuery(ServicesTypeRep.class);
        query.from(ServicesTypeRep.class);
        int i=1;
        List<ServicesTypeRep> servicesTypeRep= session.createQuery(query).getResultList();
        for( ServicesTypeRep item : servicesTypeRep){
            ;
            session.delete(item);
        }
        session.flush();
    }

    public static void ClearMissedAppReport() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<MissedAppRep> query = builder.createQuery(MissedAppRep.class);
        query.from(MissedAppRep.class);
        int i=1;
        List<MissedAppRep> missedAppReps= session.createQuery(query).getResultList();
        for( MissedAppRep item : missedAppReps){
            session.delete(item);
        }
        session.flush();
    }

    public static void ClearAwaitingTimeReport() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<AwaitingTimeRep> query = builder.createQuery(AwaitingTimeRep.class);
        query.from(AwaitingTimeRep.class);
        int i=1;
        List<AwaitingTimeRep> awaitingTimeRep= session.createQuery(query).getResultList();
        for( AwaitingTimeRep item : awaitingTimeRep){
            session.delete(item);
        }
        session.flush();
    }
    public static LocalDate GetLastSaturday(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate today = LocalDate.now();
        Calendar c = Calendar.getInstance();
        ///first get today's date
        // if todays date isn't saturday we need to get the saturday that's before today
        c.setTime(Date.from(today.atStartOfDay(defaultZoneId).toInstant()));
        int dayOfWeek8 = c.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek8<7)
            return today.with(previous(SATURDAY));
        return today;


    }
    public static LocalDate GetLastSunday(LocalDate Saturday){
        return Saturday.with(previous(SUNDAY));
    }
    public static void CreateServicesTypeReportForClinic(Clinic clinic,LocalDate Sunday,LocalDate Saturday) {


//gets the query with the needed data
        CriteriaBuilder builder1 = session.getCriteriaBuilder();
        CriteriaQuery<Appointment> query1 = builder1.createQuery(Appointment.class);
        Root<Appointment> root1 = query1.from(Appointment.class);
        query1.multiselect(root1.get("clinic"), root1.get("appointment_id"), root1.get("time"), root1.get("arrived"), root1.get("date"), root1.get("employee"), root1.get("type"));
        query1.where(builder1.equal(root1.get("clinic"), clinic), builder1.equal(root1.get("arrived"), true), builder1.between(root1.<LocalDate>get("date"), Sunday,Saturday ));
        query1.orderBy(builder1.asc(root1.get("date")));
        List<Appointment> appointments = session.createQuery(query1).getResultList();

//            for (Appointment appointment : appointments) {
//                System.out.println("counter:  " + appointment.getClinic().getCounter());
//                System.out.println(appointment.getType());
//                System.out.println(appointment.getEmployee().getRole());
//
//            }

//1. initialise every field to zero
//        2. for every absence ++
        int[] covid_Test = {0, 0, 0, 0, 0, 0};
        int[] familyDoctor = {0, 0, 0, 0, 0, 0};
        int[] lab_Test_Appointments = {0, 0, 0, 0, 0, 0};
        int[] nurse_Care = {0, 0, 0, 0, 0, 0};
        int[] pediatrician = {0, 0, 0, 0, 0, 0};
        int[] vaccine_Appointments = {0, 0, 0, 0, 0, 0};
        int[] Special_doctor = {0, 0, 0, 0, 0, 0};
        ZoneId defaultZoneId = ZoneId.systemDefault();
        for (Appointment appointment : appointments) {
            LocalDate localDate = appointment.getDate();
            Calendar c = Calendar.getInstance();
            c.setTime(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));

//                if(appointment.getType().equals("Doctor appointment")) {
//                    System.out.println("asddddddddd");
//                    System.out.println(appointment.getEmployee().getRole());
//                    System.out.println(appointment.getDate());
//
//                }
//                if(!(appointment.getType().equals("Doctor appointment"))) {
//                    System.out.println("aaaaaaaaaaaaaa");
//                    System.out.println(appointment.getEmployee().getRole());
//                    System.out.println(appointment.getDate());
//
//
//                }


            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//            if(dayOfWeek==7) dayOfWeek=2;
//            if(dayOfWeek==6) dayOfWeek=1;
//            if(dayOfWeek==5) dayOfWeek=7;
//            if(dayOfWeek==4) dayOfWeek=6;
//            if(dayOfWeek==3) dayOfWeek=5;
//            if(dayOfWeek==2) dayOfWeek=6;
//            if(dayOfWeek==1) dayOfWeek=3;
            if ((appointment.getType().equals("Doctor appointment")) && (appointment.getEmployee().getRole() == "pediatrician"))
                pediatrician[dayOfWeek - 1]++;
            if ((appointment.getType().equals("Doctor appointment")) && (appointment.getEmployee().getRole() == "family_doctor"))
                familyDoctor[dayOfWeek - 1]++;
            if ((appointment.getType().equals("Lab appointment")))
                lab_Test_Appointments[dayOfWeek - 1]++;
            if ((appointment.getType().equals("Nurse appointment")))
                nurse_Care[dayOfWeek - 1]++;
            if ((appointment.getType().equals("Covid test appointment")))
                covid_Test[dayOfWeek - 1]++;
            if (appointment.getEmployee().getRole().equals("Covid 19 vaccine appointment"))
                vaccine_Appointments[dayOfWeek - 1]++;
            if (appointment.getEmployee() instanceof SpecialDoctor) {
                Special_doctor[dayOfWeek - 1]++;
            }
        }


        ServicesTypeRep[] ReadyReport = new ServicesTypeRep[6];
        ReadyReport[0] = new ServicesTypeRep("Sunday", familyDoctor[0], pediatrician[0], vaccine_Appointments[0], lab_Test_Appointments[0], covid_Test[0], nurse_Care[0], Special_doctor[0], clinic);
        ReadyReport[1] = new ServicesTypeRep("Monday", familyDoctor[1], pediatrician[1], vaccine_Appointments[1], lab_Test_Appointments[1], covid_Test[1], nurse_Care[1], Special_doctor[1], clinic);
        ReadyReport[2] = new ServicesTypeRep("Tuesday", familyDoctor[2], pediatrician[2], vaccine_Appointments[2], lab_Test_Appointments[2], covid_Test[2], nurse_Care[2], Special_doctor[2], clinic);
        ReadyReport[3] = new ServicesTypeRep("Wednesday", familyDoctor[3], pediatrician[3], vaccine_Appointments[3], lab_Test_Appointments[3], covid_Test[3], nurse_Care[3], Special_doctor[3], clinic);
        ReadyReport[4] = new ServicesTypeRep("Thursday", familyDoctor[4], pediatrician[4], vaccine_Appointments[4], lab_Test_Appointments[4], covid_Test[4], nurse_Care[4], Special_doctor[4], clinic);
        ReadyReport[5] = new ServicesTypeRep("Friday", familyDoctor[5], pediatrician[5], vaccine_Appointments[5], lab_Test_Appointments[5], covid_Test[5], nurse_Care[5], Special_doctor[5], clinic);


        //= new []ServicesTypeRep("Sunday", familyDoctor, pediatrician, vaccine_Appointments, lab_Test_Appointments, covid_Test, nurse_Care);
        session.save(ReadyReport[0]);
        session.save(ReadyReport[1]);
        session.save(ReadyReport[2]);
        session.save(ReadyReport[3]);
        session.save(ReadyReport[4]);
        session.save(ReadyReport[5]);
        session.flush();
    }

    public static void CreateMissedAppRepForClinic(Clinic clinic,LocalDate Sunday,LocalDate Saturday) {

        //gets the query with the needed data
        CriteriaBuilder builder1 = session.getCriteriaBuilder();
        CriteriaQuery<Appointment> query1 = builder1.createQuery(Appointment.class);
        Root<Appointment> root1 = query1.from(Appointment.class);
        query1.multiselect(root1.get("clinic"), root1.get("appointment_id"), root1.get("time"), root1.get("arrived"), root1.get("date"), root1.get("employee"), root1.get("type"));
        query1.where(builder1.equal(root1.get("clinic"), clinic), builder1.equal(root1.get("arrived"), false), builder1.between(root1.<LocalDate>get("date"), Sunday,Saturday ));
        //builder1.equal(root1.get("clinic_Num"), clinic.getNum())
        //employee_user_id

        query1.orderBy(builder1.asc(root1.get("employee")));
        List<Appointment> appointments = session.createQuery(query1).getResultList();
        //1. initialise every field to zero
//        2. for every absence ++
        int covid_Test = 0;
        int familyDoctor = 0;
        int lab_Test_Appointments = 0;
        int nurse_Care = 0;
        int pediatrician = 0;
        int vaccine_Appointments = 0;
        int Special_doctor = 0;
//            if(user instanceof HMO_Manager)
//            {
//                msg.setUserType("HMO_Manager");
//                user.setLoggedIn(true);
//                msg.setStatus("logged in");
//                msg.setUser(user);
//            }else if (user instanceof Manager) {
//                msg.setUserType("Manager");
//                user.setLoggedIn(true);
//                msg.setStatus("logged in");
//                msg.setUser(user);

        for (Appointment appointment : appointments) {
//                System.out.println(appointment.getType()+"1");
//                System.out.println(appointment.getEmployee()+"1");

            // System.out.println(getUserByUsername(appointment.getEmployee().getUsername()+"adsssss"));
            // System.out.println((getUserByUsername(String.valueOf(getUserByUsername(appointment.getEmployee().getUsername()) instanceof SpecialDoctor))));
            if ((appointment.getType().equals("Doctor appointment")) && (appointment.getEmployee().getRole() == "pediatrician"))
                pediatrician++;
            else if ((appointment.getType().equals("Doctor appointment")) && (appointment.getEmployee().getRole() == "family_doctor"))
                familyDoctor++;
            else if ((appointment.getType().equals("Lab appointment")))
                lab_Test_Appointments++;
            else if ((appointment.getType().equals("Nurse appointment")))
                nurse_Care++;
            else if ((appointment.getType().equals("Covid test appointment")))
                covid_Test++;
            else if (appointment.getEmployee().getRole().equals("Covid 19 vaccine appointment"))
                vaccine_Appointments++;
            if (appointment.getEmployee() instanceof SpecialDoctor) {
                Special_doctor++;
            }
//                else if (getUserByUsername(appointment.getEmployee().getUsername()) instanceof SpecialDoctor)
//                    Special_doctor++;
        }
        MissedAppRep ReadyReport = new MissedAppRep(clinic, familyDoctor, pediatrician, vaccine_Appointments, lab_Test_Appointments, covid_Test, nurse_Care, Special_doctor);
        session.save(ReadyReport);
        session.flush();

    }

    public static void CreateAwaitingTimeRepForClinic(Clinic clinic,LocalDate Sunday,LocalDate Saturday) {

//gets the query with the needed data
        CriteriaBuilder builder1 = session.getCriteriaBuilder();
        CriteriaQuery<Appointment> query1 = builder1.createQuery(Appointment.class);
        Root<Appointment> root1 = query1.from(Appointment.class);

        query1.multiselect(root1.get("time"), root1.get("actual_time"), root1.get("arrived"), root1.get("date"), root1.get("clinic"), root1.get("employee"));
        query1.where(builder1.equal(root1.get("clinic"), clinic), builder1.equal(root1.get("arrived"), true), builder1.between(root1.<LocalDate>get("date"),Sunday,Saturday ));
        query1.orderBy(builder1.asc(root1.get("employee")));
        List<Appointment> appointments = session.createQuery(query1).getResultList();

        int doctorId = -1;
        double[] averageOfTime = {0, 0, 0, 0, 0, 0};
        int[] counttheAppointments = {0, 0, 0, 0, 0, 0};
        ZoneId defaultZoneId = ZoneId.systemDefault();
        String CurUsername = null;

        for (Appointment appointment : appointments) {
            LocalDate localDate = appointment.getDate();
            Calendar c = Calendar.getInstance();
            c.setTime(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//            if(dayOfWeek==7) dayOfWeek=2;
//            if(dayOfWeek==6) dayOfWeek=1;
//            if(dayOfWeek==5) dayOfWeek=7;
//            if(dayOfWeek==4) dayOfWeek=6;
//            if(dayOfWeek==3) dayOfWeek=5;
//            if(dayOfWeek==2) dayOfWeek=6;
//            if(dayOfWeek==1) dayOfWeek=3;

            int CurrentWaitingTime = (int) MINUTES.between(appointment.getTime(), appointment.getActual_time());
            //first time and not last time
            if ((doctorId == -1) && (appointments.indexOf(appointment) != (appointments.size() - 1))) {
                doctorId = appointment.getEmployee().getUserId();
                averageOfTime[dayOfWeek - 1] = CurrentWaitingTime;
                counttheAppointments[dayOfWeek - 1] = 1;
                CurUsername = (appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName());
//
//                        System.out.println("doctor1:"+appointment.getEmployee().getUsername());
//                        System.out.println("index1:"+appointments.indexOf(appointment));
//                        System.out.println("size1"+appointments.size());
            }
            //last time and first time
            else if ((appointments.indexOf(appointment) == (appointments.size() - 1)) && (CurUsername == null)) {

                averageOfTime[dayOfWeek - 1] += CurrentWaitingTime;
                counttheAppointments[dayOfWeek - 1]++;
                CurUsername = (appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName());
                doctorId = appointment.getEmployee().getUserId();
                AwaitingTimeRep ReadyReport = new AwaitingTimeRep(CurUsername, clinic, averageOfTime[0], averageOfTime[1], averageOfTime[2], averageOfTime[3], averageOfTime[4], averageOfTime[5], counttheAppointments[0], counttheAppointments[1], counttheAppointments[2], counttheAppointments[3], counttheAppointments[4], counttheAppointments[5]);
                session.save(ReadyReport);
                session.flush();
//
//                        System.out.println("doctor13:" + appointment.getEmployee().getUsername());
//                        System.out.println("index13:" + appointments.indexOf(appointment));
//                        System.out.println("size13" + appointments.size());
            }//while we are on the same doctor and not at the end
            else if ((doctorId == appointment.getEmployee().getUserId()) && (appointments.indexOf(appointment) != (appointments.size() - 1))) {
                averageOfTime[dayOfWeek - 1] += CurrentWaitingTime;
                counttheAppointments[dayOfWeek - 1]++;

                CurUsername = (appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName());
                doctorId = appointment.getEmployee().getUserId();
//
//                        System.out.println("doctor2:"+appointment.getEmployee().getUsername());
//                        System.out.println("index2:"+appointments.indexOf(appointment));
//                        System.out.println("size2"+appointments.size());
            }//middle moveing between doctors (not the end)
            else if ((appointments.indexOf(appointment) != (appointments.size() - 1)) && (doctorId != appointment.getEmployee().getUserId())) {
                for (int j = 0; j < 6; j++) {
                    if (counttheAppointments[j] != 0)
                        averageOfTime[j] = averageOfTime[j] / counttheAppointments[j];
                }
                AwaitingTimeRep ReadyReport = new AwaitingTimeRep(CurUsername, clinic, averageOfTime[0], averageOfTime[1], averageOfTime[2], averageOfTime[3], averageOfTime[4], averageOfTime[5], counttheAppointments[0], counttheAppointments[1], counttheAppointments[2], counttheAppointments[3], counttheAppointments[4], counttheAppointments[5]);
                session.save(ReadyReport);
                session.flush();
                doctorId = appointment.getEmployee().getUserId();
                CurUsername = (appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName());
                //restart & do first time for new doctor
                for (int j = 0; j < 6; j++) {
                    if (j == (dayOfWeek - 1)) {
                        averageOfTime[dayOfWeek - 1] = CurrentWaitingTime;
                        counttheAppointments[dayOfWeek - 1] = 1;
                    } else {
                        averageOfTime[dayOfWeek - 1] = 0;
                        counttheAppointments[dayOfWeek - 1] = 0;
                    }
                }

//                        System.out.println("doctor22:"+appointment.getEmployee().getUsername());
//                        System.out.println("index22:"+appointments.indexOf(appointment));
//                        System.out.println("size22"+appointments.size());
            }//last time and changeing doctors
            else if (((appointments.indexOf(appointment) == (appointments.size() - 1)) && (doctorId != appointment.getEmployee().getUserId()))) {
//                        System.out.println("changeing username:"+CurUsername);
//                        System.out.println("changeing username to:"+(appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName()));

                for (int j = 0; j < 6; j++) {
                    if (counttheAppointments[j] != 0)
                        averageOfTime[j] = averageOfTime[j] / counttheAppointments[j];
                }
                AwaitingTimeRep ReadyReport = new AwaitingTimeRep(CurUsername, clinic, averageOfTime[0], averageOfTime[1], averageOfTime[2], averageOfTime[3], averageOfTime[4], averageOfTime[5], counttheAppointments[0], counttheAppointments[1], counttheAppointments[2], counttheAppointments[3], counttheAppointments[4], counttheAppointments[5]);
                session.save(ReadyReport);
                session.flush();
                //save last doctor
                doctorId = appointment.getEmployee().getUserId();
                CurUsername = (appointment.getEmployee().getFirstName() + " " + appointment.getEmployee().getLastName());
                //restart & do first time for new doctor
                for (int j = 0; j < 6; j++) {
                    if (j == (dayOfWeek - 1)) {
                        averageOfTime[dayOfWeek - 1] = CurrentWaitingTime;
                        counttheAppointments[dayOfWeek - 1] = 1;
                    } else {
                        averageOfTime[dayOfWeek - 1] = 0;
                        counttheAppointments[dayOfWeek - 1] = 0;
                    }
                }
                ReadyReport = new AwaitingTimeRep(CurUsername, clinic, averageOfTime[0], averageOfTime[1], averageOfTime[2], averageOfTime[3], averageOfTime[4], averageOfTime[5], counttheAppointments[0], counttheAppointments[1], counttheAppointments[2], counttheAppointments[3], counttheAppointments[4], counttheAppointments[5]);
                session.save(ReadyReport);
                session.flush();

//                        System.out.println("doctor32:"+appointment.getEmployee().getUsername());
//                        System.out.println("index32:"+appointments.indexOf(appointment));
//                        System.out.println("size32"+appointments.size());
            }
            //last time and same doctor
            else if ((appointments.indexOf(appointment) == (appointments.size() - 1)) && (doctorId == appointment.getEmployee().getUserId())) {
                averageOfTime[dayOfWeek - 1] += CurrentWaitingTime;
                counttheAppointments[dayOfWeek - 1]++;

                for (int j = 0; j < 6; j++) {
                    if (counttheAppointments[j] != 0)
                        averageOfTime[j] = averageOfTime[j] / counttheAppointments[j];
                }
                AwaitingTimeRep ReadyReport = new AwaitingTimeRep(CurUsername, clinic, averageOfTime[0], averageOfTime[1], averageOfTime[2], averageOfTime[3], averageOfTime[4], averageOfTime[5], counttheAppointments[0], counttheAppointments[1], counttheAppointments[2], counttheAppointments[3], counttheAppointments[4], counttheAppointments[5]);
                session.save(ReadyReport);
                session.flush();


//                        System.out.println("doctor3:"+appointment.getEmployee().getUsername());
//                        System.out.println("index3:"+appointments.indexOf(appointment));
//                        System.out.println("size3"+appointments.size());
            }

            doctorId = appointment.getEmployee().getUserId();
        }

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
            initReports();
//            initMessagesToManager();
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
