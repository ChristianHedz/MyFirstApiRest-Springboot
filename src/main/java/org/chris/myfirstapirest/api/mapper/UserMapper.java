package org.chris.myfirstapirest.api.mapper;

import org.chris.myfirstapirest.api.models.User;
import org.chris.myfirstapirest.api.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);

}
