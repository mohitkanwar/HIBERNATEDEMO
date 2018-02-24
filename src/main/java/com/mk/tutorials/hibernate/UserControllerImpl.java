package com.mk.tutorials.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UserControllerImpl implements UserController {

    private UserService service ;

    public UserControllerImpl(ServiceRegistry serviceRegistry) {

        this.service = new UserServiceImpl(serviceRegistry);
    }

    public void createOrUpdate(User user) {
        if(getAllUsers().contains(user)){
            service.update(user);
        }
        else {
            service.create(user);
        }

    }

    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

}
