package ru.yandex.practicum.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
