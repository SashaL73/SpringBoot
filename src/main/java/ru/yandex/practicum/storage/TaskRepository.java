package ru.yandex.practicum.storage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.yandex.practicum.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update Task t set t.assignee = null where t.assignee.id = :userId")
    int clearAssignee(@Param("userId") Long userId);

    boolean existsByAssignee_Id(Long userId);
}
