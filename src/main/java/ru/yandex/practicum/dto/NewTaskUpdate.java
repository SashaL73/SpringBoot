package ru.yandex.practicum.dto;


import lombok.Data;
import ru.yandex.practicum.model.Priority;
import ru.yandex.practicum.model.Status;

import java.time.LocalDate;

@Data
public class NewTaskUpdate {
    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private LocalDate localDate;

    public boolean hasTitle() {
        return !(title == null || title.isBlank());
    }

    public boolean hasDescription() {
        return !(description == null || description.isBlank());
    }

    public boolean hasStatus() {
        return !(status == null);
    }

    public boolean hasPriority() {
        return !(priority == null);
    }

    public boolean hasLocalDate() {
        return !(localDate == null);
    }

}
