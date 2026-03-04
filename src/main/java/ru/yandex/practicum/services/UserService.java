package ru.yandex.practicum.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.practicum.dto.NewUserRequest;
import ru.yandex.practicum.dto.NewUserUpdate;
import ru.yandex.practicum.dto.UserDto;
import ru.yandex.practicum.exception.NotFoundException;
import ru.yandex.practicum.mapper.UserMapper;
import ru.yandex.practicum.model.Task;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.storage.TaskRepository;
import ru.yandex.practicum.storage.UserRepository;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

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

    @Transactional
    public UserDto updateUser(Long id, NewUserUpdate request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new NotFoundException("User c id " + id + " не найден")
        );
        User updatedUser = UserMapper.updateUser(user,request);
        userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUser);
    }

    @Transactional
    public void deleteUser(Long id) {
        taskRepository.clearAssignee(id);
        userRepository.deleteById(id);
    }


}
