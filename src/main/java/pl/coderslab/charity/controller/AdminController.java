package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

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

    @GetMapping("/admin/list")
    public String getAllAdmin(Model model) {
        model.addAttribute("admins", userService.getAllAdmin());
        return "/admin/admin-list";
    }

    @GetMapping("/admin/add")
    public String getAddAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "/admin/admin-add";
    }

    @PostMapping("/admin/add")
    public String postAddAdmin(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/admin-add";
        }
        model.addAttribute("admin", user);
        userService.addAdmin(user);
        return "redirect:/admin/list";
    }
}
