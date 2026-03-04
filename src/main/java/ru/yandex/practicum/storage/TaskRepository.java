package ru.yandex.practicum.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
