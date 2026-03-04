package ru.yandex.practicum.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import ru.yandex.practicum.model.Priority;
import ru.yandex.practicum.model.Status;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class NewTaskRequest {
    @NotNull
    private String title;
    @Size(max = 200, message = "Максимальная длинна описания 200")
    private String description;
    private Status status;
    private Priority priority;
    @Past(message = "Дата не может быть в прошлом")
    private LocalDate localDate;
    private Long assigneeId;
    private Set<String> tags = new HashSet<>();
}
