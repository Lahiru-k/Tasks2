package org.demo.Tasks.service;

import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.demo.Tasks.model.Task;
import org.demo.Tasks.model.User;
import org.demo.Tasks.repository.TaskRepository;
import org.demo.Tasks.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> getALlTasksForUser(Integer userId) {
        if(userId != null) {
            return taskRepository.getTasksForUser(userId);
        }else {
            return new ArrayList<>();
        }
    }

    public User getUserTasks(Integer userId) {
        if(userId != null) {
            User user = userRepository.findById(userId).orElse(new User());
            user.setTasks(getALlTasksForUser(userId));
            user.getTasks().forEach(System.out::println);
            return user;
        }else {
            return new User();
        }
    }

}

