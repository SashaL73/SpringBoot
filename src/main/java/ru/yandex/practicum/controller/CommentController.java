package ru.yandex.practicum.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.CommentDto;
import ru.yandex.practicum.dto.NewCommentRequest;

import java.util.List;

@RestController
@RequestMapping("/api/tasks/{taskId}/comments")
public class CommentController {

    @PostMapping
    public CommentDto createComment(@PathVariable("taskId") Long taskId,
            @Valid @RequestBody NewCommentRequest request) {
        return null;
    }

    @GetMapping
    public List<CommentDto> getListComments(@PathVariable("taskId") Long taskId) {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteComment(@PathVariable("taskId") Long taskId,
            @PathVariable("id") Long id) {
        return null;
    }
}
