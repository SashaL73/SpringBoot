package ru.yandex.practicum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.NewTaskRequest;
import ru.yandex.practicum.dto.NewTaskUpdate;
import ru.yandex.practicum.dto.TaskDto;
import ru.yandex.practicum.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TasksController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public TaskDto createTask(@RequestBody NewTaskRequest request) {
        return taskService.createTask(request);

    }

    @GetMapping("/{id}")
    public TaskDto getTaskById(@PathVariable("id") Long id) {
        return taskService.findTaskById(id);
    }

    @GetMapping
    public List<TaskDto> getTasks() {
        return null;
    }

    @PutMapping("/{id}")
    public String updateTask(@RequestBody NewTaskUpdate request) {
        return null;
    }

    @PatchMapping("/{taskId}/assignee/{userId}")
    public TaskDto setAssignee(@PathVariable("taskId") Long taskId, @PathVariable("userId") Long userId) {
        return taskService.assignUser(taskId,userId);

    }
    @PutMapping("/{id}/tags")
    public TaskDto replaceTagsTask(@PathVariable("id") Long id, @RequestBody List<String> tagNames) {
        
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        return null;
    }
}
