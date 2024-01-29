package org.chris.myfirstapirest.api.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.chris.myfirstapirest.api.models.dto.UserDto;
import org.chris.myfirstapirest.api.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> userDtoList = userService.listAllUsers();
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDTO){
        UserDto userDto = userService.saveUser(userDTO);
        return new ResponseEntity<>(userDto,HttpStatus.CREATED);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,@RequestBody @Valid UserDto userDTO){
        UserDto userDto = userService.updateUser(id,userDTO);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id){
        UserDto userDto = userService.findUserById(id);
        return new ResponseEntity<>(userDto,HttpStatus.OK);
    }

}
