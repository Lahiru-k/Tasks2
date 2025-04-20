package org.demo.Tasks.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.List;

@Data
public class User {
    @Id
    private Integer userId;
    private String username;
    private String password;
    @MappedCollection(idColumn = "task_id", keyColumn = "user_id")
    private List<Task> tasks;

}
