package org.example;

import org.example.model.Cart;
import org.example.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Arrays;
import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        SessionFactory factory = configuration.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Cart cart1 = new Cart(1, "Cart1");
        session.persist(cart1);

        Cart cart2 = new Cart(2, "Cart2");
        session.persist(cart2);

        Cart cart3 = new Cart(3, "Cart3");
        session.persist(cart3);

        Cart cart4 = new Cart(4, "Cart4");
        session.persist(cart4);


        Item item1 = new Item(1);
        session.persist(item1);

        Item item2 = new Item(2);
        session.persist(item2);

        Item item3 = new Item(3);
        session.persist(item3);

        Item item4 = new Item(4);
        session.persist(item4);

        Item item5 = new Item(5);
        session.persist(item5);


        cart1.setItems(new HashSet<>(Arrays.asList(item1, item2, item3)));
        session.persist(cart1);

        cart2.setItems(new HashSet<>(Arrays.asList(item5, item1, item2)));
        session.persist(cart2);

        cart3.setItems(new HashSet<>(Arrays.asList(item1, item2, item3, item4)));
        session.persist(cart3);

        cart4.setItems(new HashSet<>(Arrays.asList(item3, item4, item5, item1)));
        session.persist(cart4);

        transaction.commit();
        session.close();
    }
}
