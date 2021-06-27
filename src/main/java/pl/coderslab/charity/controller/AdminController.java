package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.UserService;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/login")
    public String adminLoginForm() {
        return "/admin/admin-login";
    }

    @GetMapping("/admin/home")
    public String adminHome() {
        return "/admin/admin-home";
    }

}