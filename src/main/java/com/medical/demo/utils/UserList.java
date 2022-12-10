package com.medical.demo.utils;
import com.medical.demo.models.User;
import java.util.ArrayList;
import java.util.List;


public class UserList {
    final List<User> users = new ArrayList<>();
    public List<User> getUsers(){

        return users;
    }

    public User addUser(User user){
        user.setId(users.size() + 1);
        users.add(user);
        return user;
    }
}
