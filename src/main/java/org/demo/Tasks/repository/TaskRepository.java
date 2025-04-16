package org.demo.Tasks.repository;


import org.demo.Tasks.model.Task;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Integer> {

    @Query("SELECT * FROM task WHERE user_id = :userId")
    public List<Task> getTasksForUser(Integer userId);

}
