package com.kelvin.mercury.service;
import com.kelvin.mercury.annotation.Info;
import com.kelvin.mercury.dto.UserDTO;
import com.kelvin.mercury.exception.ResourcesExistException;
import com.kelvin.mercury.mapper.UserMapper;
import com.kelvin.mercury.repository.UserRepository;
import com.kelvin.mercury.exception.ResourcesNotFoundException;
import com.kelvin.mercury.exception.UserError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
     UserMapper userMapper;

    @Autowired
    UserRepository repository;

    @Override
    @Info
    public List<UserDTO> getUsers() {
        return repository.findAll()
                .stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Info
    public UserDTO getUserById(String id) {
        return repository.findById(Long.parseLong(id))
                .map(userMapper::userToUserDTO)
                .orElseThrow(() -> new ResourcesNotFoundException(UserError.USER_NOT_FOUND));
    }

    @Override
    @Info
    public UserDTO addUser(UserDTO newUser) {
        if(this.isUserExists(newUser.getMobileNumber())) throw new ResourcesExistException(UserError.USER_EXIST);
        repository.save(userMapper.userDTOToUser(newUser));
        return newUser;
    }

    private boolean isUserExists(String mobilePhone) {
        return repository.findByMobileNumber(mobilePhone).isPresent();
    }
}
