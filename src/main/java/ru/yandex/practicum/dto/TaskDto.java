package ru.yandex.practicum.dto;

import lombok.Data;
import ru.yandex.practicum.model.Priority;
import ru.yandex.practicum.model.Status;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate localDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long assigneeID;
    private Set<String> tags = new HashSet<>();
}
