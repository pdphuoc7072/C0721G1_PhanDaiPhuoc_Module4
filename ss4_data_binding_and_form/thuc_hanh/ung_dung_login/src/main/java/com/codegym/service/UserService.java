package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;

public class UserService {
    public static User checkLogin (Login login) {
        return UserRepository.checkLogin(login);
    }
}
