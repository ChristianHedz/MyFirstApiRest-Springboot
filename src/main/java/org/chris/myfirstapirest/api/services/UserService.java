package org.chris.myfirstapirest.api.services;

import org.chris.myfirstapirest.api.models.dto.UserDto;
import java.util.List;

public interface UserService {

    List<UserDto> listAllUsers();
    UserDto saveUser(UserDto userDto);
    UserDto updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);
    UserDto findUserById(Long id);

}
