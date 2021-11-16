package com.codegym.service;

import com.codegym.model.User;

public interface IUserService extends IGeneralService<User> {
    User findByUsername(String username);
    void insertUserRole(Long user_id, Long role_id);

    void insertUserRoleMultiple(Long user_id, Long role_id_1, Long role_id_2);
}
