package ru.yandex.practicum.dto;


import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class TagDto {
    private Long id;
    private String name;
    private Set<String> tasks = new HashSet<>();
}
