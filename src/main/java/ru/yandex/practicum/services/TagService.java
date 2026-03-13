package ru.yandex.practicum.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.storage.TagRepository;
import ru.yandex.practicum.storage.TaskRepository;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;
    private final TaskRepository taskRepository;
}
