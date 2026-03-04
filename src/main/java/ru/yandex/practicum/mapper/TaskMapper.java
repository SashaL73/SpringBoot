package ru.yandex.practicum.mapper;


import ru.yandex.practicum.dto.NewTaskRequest;
import ru.yandex.practicum.dto.NewTaskUpdate;
import ru.yandex.practicum.dto.TaskDto;
import ru.yandex.practicum.model.Status;
import ru.yandex.practicum.model.Tag;
import ru.yandex.practicum.model.Task;
import ru.yandex.practicum.model.User;

import java.util.Set;
import java.util.stream.Collectors;

public class TaskMapper {

    public static Task mapToTask(NewTaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setLocalDate(request.getLocalDate());
        User user = new User();
        user.setId(request.getAssigneeId());
        task.setAssignee(user);
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
        taskDto.setAssigneeId(task.getAssignee() == null ? null : task.getAssignee().getId());
        taskDto.setTags(task.getTags() == null
                    ? Set.of()
                    : task.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toSet()));
        return taskDto;
    }

    public static Task taskUpdate(Task task, NewTaskUpdate request) {
        if (request.hasStatus() && task.getStatus().equals(Status.DONE)) {
            task.setStatus(request.getStatus());
        } else {
            if (request.hasTitle()) {
                task.setTitle(request.getTitle());
            }
            if (request.hasDescription()) {
                task.setDescription(request.getDescription());
            }

            if (request.hasPriority()) {
                task.setPriority(request.getPriority());
            }

            if (request.hasStatus()) {
                task.setStatus(request.getStatus());
            }

            if(request.hasLocalDate()) {
                task.setLocalDate(request.getLocalDate());
            }
         }
        return task;
    }
}
