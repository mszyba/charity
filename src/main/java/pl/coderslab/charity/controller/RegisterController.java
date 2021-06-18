package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

@Controller
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute(new User());
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute User user, @RequestParam String rePassword) {
        if (user.getPassword().equals(rePassword)) {
            userService.add(user);
        }
        return "redirect:/login";
    }
}
