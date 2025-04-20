package org.demo.Tasks.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
public class Task {
    @Id
    private Integer taskId;
    private Integer userId;
    private boolean status;
    private String description;
}
