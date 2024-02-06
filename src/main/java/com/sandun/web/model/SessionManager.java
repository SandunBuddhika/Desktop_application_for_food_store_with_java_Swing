package com.sandun.web.model;

import com.sandun.web.entities.User;
import com.sandun.web.service.UserService;

public class SessionManager {

    private static final User USER = getUser();

    private static User getUser() {
        UserService us = new UserService();
        return us.getUserById(2);
    }

    public static User getUSER() {
        return USER;
    }

}
