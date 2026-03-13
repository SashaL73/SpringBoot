package ru.yandex.practicum.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.practicum.model.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
