package com.kelvin.mercury.mapper;

import com.kelvin.mercury.model.User;
import com.kelvin.mercury.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // To access the implementation
    // UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User userDTOToUser(UserDTO userDTO);

    UserDTO userToUserDTO(User user);
}
