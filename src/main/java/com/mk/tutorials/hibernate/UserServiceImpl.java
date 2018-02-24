package com.mk.tutorials.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UserServiceImpl implements UserService {
    private ServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
    public UserServiceImpl(ServiceRegistry serviceRegistry){
        this.sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);;
    }

    public void create(User user) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.persist(user);
        t.commit();
        session.close();
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User").list();
        session.close();
        return users;
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        session.update(user);
        t.commit();
        session.close();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        sessionFactory.close();
    }
}
