package ru.yandex.practicum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exception.NotFoundException;
import ru.yandex.practicum.mapper.UserMapper;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.storage.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(NewUserRequest request) {
        User user = UserMapper.mapToUser(request);
        return UserMapper.mapToUserDto(userRepository.save(user));
    }

    public UserDto findUserById(Long id) {
        return  UserMapper.mapToUserDto(Objects.requireNonNull(userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User not found")
        )));
    }

    public List<UserDto> findAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::mapToUserDto)
                .toList();
    }


}
