package org.demo.Tasks.controller;

import lombok.Data;
import org.demo.Tasks.model.Task;
import org.demo.Tasks.model.User;
import org.demo.Tasks.service.TaskService;
import org.demo.Tasks.service.UserSession;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
@RequestMapping()
public class HomeController {
    private final UserSession userSession;
    private final TaskService taskService;

    @GetMapping("/home")
    public String getHome(Model model) {
        if(userSession.isLogged()) {
            User user = taskService.getUserTasks(userSession.getUserId());
            model.addAttribute("user", user);
            model.addAttribute("newTask", new Task());
            return "home.html";
        }else {
            return "redirect:/login";
        }
    }

    @PostMapping("/home")
    public String postHome(@ModelAttribute User user, Model model) {
        taskService.saveUserTasks(user);
        return "redirect:/home";
    }

    @PostMapping("/home/add")
    public String postNewTask(Model model, @ModelAttribute Task task) {
        taskService.addNewTask(task, userSession.getUserId());
        return "redirect:/home";
    }

}
