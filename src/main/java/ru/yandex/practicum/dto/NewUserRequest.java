package ru.yandex.practicum.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NewUserRequest {
    @NotNull
    private String name;
    @NotNull
    @Email
    private String email;
}
