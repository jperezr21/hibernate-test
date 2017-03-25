package uy.edu.um.dbd2.hibernatetest;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 */
public class Runner {

  public static void main(String[] args) {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
        .configure()
        .build();

    SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata()
        .buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List result2 = session.createQuery("from Ubicacion").list();
    for (Ubicacion ubicacion : (List<Ubicacion>) result2) {
      System.out.println(ubicacion.getLocal().getNombre() + " | " + ubicacion.getDescripcion());
    }
    session.getTransaction().commit();
    session.close();

    sessionFactory.close();
  }

}
