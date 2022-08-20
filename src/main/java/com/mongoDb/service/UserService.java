package com.mongoDb.service;

import com.mongoDb.entity.UserDTO;
import com.mongoDb.model.User;

public interface UserService {
    User createUser(UserDTO userDTO);
}
