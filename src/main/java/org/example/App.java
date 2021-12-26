package org.example;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;


public class App {
    private static Session session;

    private static SessionFactory getSessionFactory() throws HibernateException {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Manager.class);
        configuration.addAnnotatedClass(HMO_Manager.class);
        configuration.addAnnotatedClass(Clinic.class);
        configuration.addAnnotatedClass(Nurse.class);
        configuration.addAnnotatedClass(LabWorker.class);
        configuration.addAnnotatedClass(Appointment.class);
        configuration.addAnnotatedClass(LabApp.class);
        configuration.addAnnotatedClass(NurseApp.class);
        configuration.addAnnotatedClass(Patient.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
                .build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


    private static void initEmployeesTable() throws Exception {
        // create instance of Random class
        Random rand = new Random();
        int card_num = rand.nextInt(100000);
        HMO_Manager employee1 = new HMO_Manager("Agoldstein", "AG5449@", "Alex", "Goldstein", card_num, "agoldstein@good_health.com", "HMO_Managment", null);
        session.save(employee1);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee2 = new Manager("Rcohen", "RC9681%", "Ruth", "Cohen", "clinic manager", card_num, "rcohen@good_health.com", "Denia", null);
        session.save(employee2);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee3 = new Manager("Mlevi", "ML8192$", "Maya", "Levi", "clinic manager", card_num, "mlevi@good_health.com", "Neve shaanan", null);
        session.save(employee3);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee4 = new Employee("Dliberman", "DL9788#", "David", "Liberman", "cardiologist", card_num, "dliberman@good_health.com", "Carmel");
        session.save(employee4);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee5 = new Manager("Daviv", "DA6872&", "Dan", "Aviv", "clinic manager", card_num, "daviv@good_health.com", "Nesher", null);
        session.save(employee5);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee6 = new Manager("TShuster", "TS7383%", "Tal", "Shuster", "clinic manager", card_num, "tshuster@good_health.com", "Hadar", null);
        session.save(employee6);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee7 = new Employee("REldar", "RE7462%", "Rachel", "Eldar", "pediatrician", card_num, "reldar@good_health.com", "Hadar");
        session.save(employee7);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee8 = new Manager("VSilverman", "VS8510$", "Valeria", "Silverman", "clinic manager", card_num, "vsilverman@good_health.com", "Carmel", null);
        session.save(employee8);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee9 = new Employee("DShitrit", "DS6743*", "Dor", "Shitrit", "family_doctor", card_num, "dshitrit@good_health.com", "Neve shaanan");
        session.save(employee9);
        session.flush();
        card_num = rand.nextInt(100000);
        Manager employee10 = new Manager("CSella", "CS7336%", "Chen", "Sella", "clinic manager", card_num, "csella@good_health.com", "Tirat Carmel", null);
        session.save(employee10);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee11 = new Employee("NWeber", "NW6108!", "Naama", "Weber", "family_doctor", card_num, "nweber@good_health.com", "Hadar");
        session.save(employee11);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee12 = new Employee("ABachar", "AB6109&", "Amit", "Bachar", "family_doctor", card_num, "abachar@good_health.com", "Denia");
        session.save(employee12);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee13 = new Employee("MPorat", "MP%6199", "Moran", "Porat", "family_doctor", card_num, "mporat@good_health.com", "Nesher");
        session.save(employee13);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee14 = new Employee("MZeev", "MZ!2797", "Maayan", "Zeev", "family_doctor", card_num, "mzeev@good_health.com", "Tirat Carmel");
        session.save(employee14);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee15 = new Employee("RShtein", "RS5971#", "Rotem", "Shtein", "family_doctor", card_num, "rshtein@good_health.com", "Carmel");
        session.save(employee15);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee16 = new Employee("RBarlev", "RB5327^", "Ravit", "Barlev", "pediatrician", card_num, "rbarlev@good_health.com", "Denia");
        session.save(employee16);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee17 = new Employee("GNadler", "GN4398@", "Gil", "Nadler", "pediatrician", card_num, "gnadler@good_health.com", "Neve shaanan");
        session.save(employee17);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee18 = new Employee("TRobin", "TR78290=", "Tom", "Robin", "pediatrician", card_num, "trobin@good_health.com", "Nesher");
        session.save(employee18);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee19 = new Employee("EPeretz", "EP7819&", "Elinor", "Peretz", "pediatrician", card_num, "eperetz@good_health.com", "Carmel");
        session.save(employee19);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee20 = new Employee("YHadad", "YH7629%", "Yuval", "Hadad", "pediatrician", card_num, "yhadad@good_health.com", "Tirat Carmel");
        session.save(employee20);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse1 = new Nurse("SLev", "SL5491&", "Shahar", "Lev", card_num, "slev@good_health.com", "Denia", null);
        session.save(nurse1);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse2 = new Nurse("GShwartz", "GS6892@", "Gal", "Shwartz", card_num, "gshwartz@good_health.com", "Neve shaanan", null);
        session.save(nurse2);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse3 = new Nurse("SCohen", "SC8298*", "Sarit", "Cohen", card_num, "scohen@good_health.com", "Hadar", null);
        session.save(nurse3);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse4 = new Nurse("IGad", "IG7992#", "Ilanit", "Gad", card_num, "igad@good_health.com", "Nesher", null);
        session.save(nurse4);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse5 = new Nurse("ALevi", "AL4298$", "Adi", "Levi", card_num, "alevi@good_health.com", "Carmel", null);
        session.save(nurse5);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse6 = new Nurse("TGrosman", "TG9596!", "Tamar", "Grosman", card_num, "tgrosman@good_health.com", "Tirat Carmel", null);
        session.save(nurse6);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee27 = new Employee("AIsraeli", "AI8995%", "Avraham", "Israeli", "ENT doctor", card_num, "aisraeli@good_health.com", "Carmel");
        session.save(employee27);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee28 = new Employee("MSason", "MS9087&", "Miriam", "Sason", "gynecologist", card_num, "msason@good_health.com", "Carmel");
        session.save(employee28);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee29 = new Employee("SAviram", "SA8769#", "Shlomi", "Aviram", "dermatologist", card_num, "saviram@good_health.com", "Carmel");
        session.save(employee29);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee30 = new Employee("AMelamed", "AM6589$", "Alon", "Melamed", "ophthalmologist", card_num, "amelamed@good_health.com", "Carmel");
        session.save(employee30);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee31 = new Employee("EHadad", "EH7891@", "Erez", "Hadad", "ENT doctor", card_num, "ehadad@good_health.com", "Carmel");
        session.save(employee31);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker1 = new LabWorker("ARodensky", "AR9123#", "Anna", "Rodensky", card_num, "arodensky@good_health.com", "Denia", null);
        session.save(labWorker1);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker2 = new LabWorker("AIsraeli", "AI6712%", "Alina", "Israeli", card_num, "aisraeli@good_health.com", "Neve Shaanan", null);
        session.save(labWorker2);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker3 = new LabWorker("OAshkenazi", "OA7815&", "Oren", "Ashkenazi", card_num, "oashkenazi@good_health.com", "Hadar", null);
        session.save(labWorker3);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee35 = new Employee("ABar", "AB8127%", "Avital", "Bar", "lab worker", card_num, "abar@good_health.com", "Nesher");
        session.save(employee35);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee36 = new Employee("YShachar", "YS9034&", "Yael", "Shachar", "lab worker", card_num, "yshachar@good_health.com", "Carmel");
        session.save(employee36);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker4 = new LabWorker("TGil", "TG9236#", "Tehila", "Gil", card_num, "tgil@good_health.com", "Tirat Carmel", null);
        session.save(labWorker4);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee38 = new Employee("NDadon", "ND7137%", "Nathan", "Dadon", "neurologist", card_num, "ndadon@good_health.com", "Carmel");
        session.save(employee38);
        session.flush();
        card_num = rand.nextInt(100000);
        Employee employee39 = new Employee("OTzarfati", "OT6328$", "Ofer", "Tzarfati", "gynecologist", card_num, "otzarfati@good_health.com", "Carmel");
        session.save(employee39);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker7 = new LabWorker("JGraham", "JG3518@", "John", "Graham", card_num, "jgraham@good_health.com", "Carmel", null);
        session.save(labWorker7);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker5 = new LabWorker("ASmith", "AS0817$", "Allen", "Smith", card_num, "asmith@good_health.com", "Hadar", null);
        session.save(labWorker5);
        session.flush();
        card_num = rand.nextInt(100000);
        LabWorker labWorker6 = new LabWorker("KMiller", "KM6113#", "Karen", "Miller", card_num, "kmiller@good_health.com", "Nesher", null);
        session.save(labWorker6);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse7 = new Nurse("TCohen", "TC8751*", "Tal", "Cohen", card_num, "tcohen@good_health.com", "Hadar", null);
        session.save(nurse7);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse8 = new Nurse("DOren", "DO4058@", "Dana", "Oren", card_num, "doren@good_health.com", "Carmel", null);
        session.save(nurse8);
        session.flush();
        card_num = rand.nextInt(100000);
        Nurse nurse9 = new Nurse("DLevi", "DL9061!", "David", "Levi", card_num, "dlevi@good_health.com", "Nesher", null);
        session.save(nurse9);
        session.flush();
    }

    public static Manager getManager(int Id) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
        query.from(Manager.class);
        List<Manager> managers = session.createQuery(query).getResultList();
        for (Manager manager : managers) {
            if (manager.getId() == Id) {
                return manager;
            }
        }
        return null;
    }

    private static void initClinicsTable() throws Exception {
        Clinic clinic1 = new Clinic("Denia", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), getManager(2), "Libiria 2", "04-8656321");
        session.save(clinic1);
        session.flush();
        Clinic clinic2 = new Clinic("Neve shaanan", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"), getManager(3), "Hagalil 76", "04-8656322");
        session.save(clinic2);
        session.flush();
        Clinic clinic3 = new Clinic("Hadar", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), getManager(6), "Herzel 15", "04-8656323");
        session.save(clinic3);
        session.flush();
        Clinic clinic4 = new Clinic("Nesher", "Nesher", LocalTime.parse("07:00:00"), LocalTime.parse("19:00:00"), getManager(5), "Haalon 23", "04-8656324");
        session.save(clinic4);
        session.flush();
        Clinic clinic5 = new Clinic("Carmel", "Haifa", LocalTime.parse("07:00:00"), LocalTime.parse("20:00:00"), getManager(8), "Horev 6", "04-8656325");
        session.save(clinic5);
        session.flush();
        Clinic clinic6 = new Clinic("Tirat Carmel", "Tirat Carmel", LocalTime.parse("07:00:00"), LocalTime.parse("17:00:00"), getManager(10), "Levi eshckol 16", "04-8656326");
        session.save(clinic6);
        session.flush();
    }


    private static void initAppointmentsTable() throws Exception {
        //Need Patient entity to fill
    }


    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = getSessionFactory();
            session = sessionFactory.openSession();
            session.beginTransaction();
            initEmployeesTable();
            initClinicsTable();
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
