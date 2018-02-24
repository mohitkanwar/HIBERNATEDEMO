package com.mk.tutorials.hibernate;

import java.util.List;

public interface UserService {
    public void create(User user);
    public List<User> getAllUsers();

    public void update(User user);
}
