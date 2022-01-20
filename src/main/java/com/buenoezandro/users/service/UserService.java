package com.buenoezandro.users.service;

import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;

import java.util.List;

public interface UserService {
    List<UserModelDTO> findAllUsers();

    UserModelDTO findById(Integer id);

    UserModelDTO create(UserModel userModel);

    void update(Integer id, UserModel userModel);

    void delete(Integer id);
}
