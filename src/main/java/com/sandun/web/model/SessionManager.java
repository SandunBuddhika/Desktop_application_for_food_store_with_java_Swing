package com.sandun.web.model;

import com.sandun.web.entities.User;
import com.sandun.web.service.UserService;

public class SessionManager {

    private static User user;

    public static User logIn(String username, String password) {
        UserService us = new UserService();
        user = us.logIn(username, password);
        return user;
    }

    public static User getUSER() {
        return user;
    }

}
