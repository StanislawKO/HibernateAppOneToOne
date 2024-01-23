package org.example;

import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )    {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person = new Person("Test person", 50);
//            Passport passport = new Passport(123456);
//
//            person.setPassport(passport);
//
//            session.save(person);
//            ------------------------------------

//            Passport passport = session.get(Passport.class, 2);
//            System.out.println(passport.getPerson().getName());
//            ------------------------------------

//            Person person = session.get(Person.class, 2);
//            person.getPassport().setPassportNumber(77777);
//            ------------------------------------

            Person person = session.get(Person.class, 2);
            session.remove(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
