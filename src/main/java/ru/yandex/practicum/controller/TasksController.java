package ru.yandex.practicum.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.NewTaskRequest;
import ru.yandex.practicum.dto.NewTaskUpdate;
import ru.yandex.practicum.dto.TagDto;
import ru.yandex.practicum.dto.TaskDto;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {

    @PostMapping
    public TaskDto createTask(@RequestBody NewTaskRequest request) {
        return null;

    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable("id") Long id) {
        return null;
    }

    @GetMapping
    public List<TaskDto> getTasks() {
        return null;
    }

    @PutMapping("/{id}")
    public String updateTask(@RequestBody NewTaskUpdate request) {
        return null;
    }

    @PatchMapping("/{id}assignee/{userId}")
    public TagDto setAssignee(@PathVariable("id") Long id, @PathVariable("userID") Long userId) {
        return null;

    }
    @PutMapping("/{id}/tags")
    public void replaceTagsTask(@PathVariable("id") Long id) {

    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        return null;
    }
}
