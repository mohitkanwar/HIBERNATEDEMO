package com.mk.tutorials.hibernate;

import java.util.List;

public interface UserController {
    public void createOrUpdate(User user);
    public List<User> getAllUsers();
}
