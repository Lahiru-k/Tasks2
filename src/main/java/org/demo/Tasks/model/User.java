package org.demo.Tasks.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User {
    @Id
    private Integer user_id;
    private String username;
    private String password;
    private List<Task> tasks;

}
