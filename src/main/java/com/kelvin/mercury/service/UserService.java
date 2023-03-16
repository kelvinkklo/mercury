package com.kelvin.mercury.service;

import com.kelvin.mercury.annotation.Info;
import com.kelvin.mercury.dto.UserDTO;

import java.util.List;

public interface UserService {
    @Info
    List<UserDTO> getUsers();

    public UserDTO getUserById(String id);

    public UserDTO addUser(UserDTO newUser);


}
