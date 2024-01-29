package org.chris.myfirstapirest.api.services;

import lombok.AllArgsConstructor;
import org.chris.myfirstapirest.api.exceptions.ResourceNotFoundException;
import org.chris.myfirstapirest.api.mapper.UserMapper;
import org.chris.myfirstapirest.api.models.User;
import org.chris.myfirstapirest.api.models.dto.UserDto;
import org.chris.myfirstapirest.api.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private UserMapper userMapper;
    private final String usuario = "Usuario";

    @Transactional(readOnly = true)
    @Override
    public List<UserDto> listAllUsers() {
        List<UserDto> userDtoList = StreamSupport.stream(userRepository.findAll()
                .spliterator(),false).map(user -> userMapper.userToUserDto(user)).toList();
        if (userDtoList.isEmpty()){
            throw new ResourceNotFoundException("Usuarios");
        }
        return userDtoList;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userRepository.save(userMapper.userDtoToUser(userDto));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(usuario,"id",id));
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        return userMapper.userToUserDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(usuario,"id",id));
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(usuario,"id",id));
        return userMapper.userToUserDto(user);
    }

}
