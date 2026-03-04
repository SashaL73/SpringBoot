package ru.yandex.practicum.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.yandex.practicum.dto.NewTaskRequest;
import ru.yandex.practicum.dto.TaskDto;
import ru.yandex.practicum.exception.NotFoundException;
import ru.yandex.practicum.mapper.TaskMapper;
import ru.yandex.practicum.model.Task;
import ru.yandex.practicum.model.User;
import ru.yandex.practicum.storage.TaskRepository;
import ru.yandex.practicum.storage.UserRepository;



@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskDto createTask(NewTaskRequest request) {
        Task task = TaskMapper.mapToTask(request);
        return TaskMapper.mapToTaskDto(taskRepository.save(task));
    }

    public TaskDto findTaskById(Long id) {
        return TaskMapper.mapToTaskDto(taskRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not Found")
        ));
    }

    @Transactional
    public TaskDto assignUser(Long idTask, Long idUser) {
        Task task = taskRepository.findById(idTask)
                .orElseThrow(() -> new NotFoundException("Not Found"));

        User user = userRepository.findById(idUser)
                .orElseThrow(() -> new NotFoundException("Not Found"));

        task.setAssignee(user);
        Task saved = taskRepository.save(task);

        return TaskMapper.mapToTaskDto(saved);
    }


}
