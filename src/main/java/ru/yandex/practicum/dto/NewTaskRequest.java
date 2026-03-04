package ru.yandex.practicum.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewTaskRequest {
    @NotNull
    private String title;
    @Size(max = 200, message = "Максимальная длинна описания 200")
    private String description;
    @Past(message = "Дата не может быть в прошлом")
    private LocalDate localDate;
}
