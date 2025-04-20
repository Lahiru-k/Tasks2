package org.demo.Tasks.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Data
@SessionScope
@Service
public class UserSession {
    private String username;
    private Integer userId;

    public boolean isLogged() {
        return getUsername() != null;
    }

}
