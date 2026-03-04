package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.NewUserUpdate;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public UserDto createdUser(@Valid @RequestBody NewUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody NewUserUpdate request) {
        return userService.updateUser(id,request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }


}
