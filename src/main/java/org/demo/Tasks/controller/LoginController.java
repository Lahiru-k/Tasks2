package org.demo.Tasks.controller;

import lombok.Data;
import org.demo.Tasks.model.User;
import org.demo.Tasks.service.LoginService;
import org.demo.Tasks.service.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/login", "/"})
@Data
public class LoginController {
    private final LoginService loginService;
    private final UserSession userSession;

    @GetMapping
    public String getLogin(Model model) {
        if(userSession.isLogged()) {
            return "home.html";
        }else {
            model.addAttribute("user", new User());
            return "login.html";
        }
    }

    @PostMapping
    public String doLogin(Model model, @ModelAttribute User user) {
        if(loginService.validateCredentials(user.getUsername(), user.getPassword())) {
            return "redirect:/home";
        } else {
            model.addAttribute("message", "Username/ Password Incorrect!");
            return "redirect:/login";
        }
    }

}
