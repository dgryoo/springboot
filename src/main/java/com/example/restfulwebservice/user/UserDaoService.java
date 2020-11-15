package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

//스테레오 타입
@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    // Database의 유저 수
    private static int usersCount = 3;

    // Database라고 가정
    static {
        users.add(new User(1, "Ryoo", new Date()));
        users.add(new User(2, "Shin", new Date()));
        users.add(new User(3, "Lim", new Date()));

    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }

    public User findOne(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    // users.remove를 해야하는게 아닌지??
    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

    public User updateById(User user, int id) {
        User updateUser = findOne(id);
        if(updateUser != null ) {
            updateUser.setName(user.getName());
            return updateUser;
        }

        return null;

    }
}