package ru.yandex.practicum.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.storage.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser() {
        User user = new User();
        user.setName("Aleksander");
        user.setEmail("test@test.com");

        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
