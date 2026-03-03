package ru.yandex.practicum.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.dto.NewTagRequest;
import ru.yandex.practicum.dto.TagDto;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagsController {

    @PostMapping
    public TagDto createTag(@RequestBody NewTagRequest request) {
        return null;
    }

    @GetMapping
    public List<TagDto> getAllTags() {
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteTag(@PathVariable("id") Long id) {
        return null;
    }
}
