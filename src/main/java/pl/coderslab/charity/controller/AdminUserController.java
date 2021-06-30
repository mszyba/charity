package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.UserService;

@Controller
public class AdminUserController {

     private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "/admin/admin-user-list";
    }
}
