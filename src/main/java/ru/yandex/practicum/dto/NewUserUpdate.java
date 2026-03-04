package ru.yandex.practicum.dto;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class NewUserUpdate {
    private String name;
    @Email
    private String email;


    public boolean hasName() {
        return !(name == null || name.isBlank());
    }

    public boolean hasEmail() {
        return !(email == null || email.isBlank());
    }
}
