package ru.yandex.practicum.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public UserDto createdUser() {
        userService.createUser();
        return null;
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return null;
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody NewUserUpdate request) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return null;
    }


}
