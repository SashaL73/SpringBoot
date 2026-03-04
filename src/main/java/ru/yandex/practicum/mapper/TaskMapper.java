package ru.yandex.practicum.mapper;


import ru.yandex.practicum.dto.NewTaskRequest;
import ru.yandex.practicum.dto.TaskDto;
import ru.yandex.practicum.model.Tag;
import ru.yandex.practicum.model.Task;

import java.util.Set;
import java.util.stream.Collectors;

public class TaskMapper {

    public static Task mapToTask(NewTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setLocalDate(request.getLocalDate());
        return task;
    }

    public static TaskDto mapToTaskDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setStatus(task.getStatus());
        taskDto.setPriority(task.getPriority());
        taskDto.setLocalDate(task.getLocalDate());
        taskDto.setCreatedAt(task.getCreatedAt());
        taskDto.setUpdatedAt(task.getUpdatedAt());
        taskDto.setAssigneeID(task.getAssignee() == null ? null : task.getAssignee().getId());
        taskDto.setTags(task.getTags() == null
                    ? Set.of()
                    : task.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet()));
        return taskDto;
    }
}
