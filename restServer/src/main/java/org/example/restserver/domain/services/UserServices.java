package org.example.restserver.domain.services;

import org.example.restserver.dao.UserDao;
import org.springframework.stereotype.Service;

@Service

public class UserServices {
    private final UserDao dao;

    public UserServices(UserDao dao) {
        this.dao = dao;
    }

}
