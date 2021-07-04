package pl.coderslab.charity.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserEditDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Slf4j
@Controller
public class AdminUserController {

    private static final String ROLE_USER = "ROLE_USER";
    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/user/list")
    public String getAllUser(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "/admin/admin-user-list";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String getEditUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserByIdAndRole(id, ROLE_USER));
        return "/admin/admin-user-edit";
    }

    @PostMapping("/admin/user/edit")
    public String postEditUser(@Valid UserEditDTO userEditDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "/admin/admin-user-edit";
        }
        userService.updateUser(userEditDTO);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/admin/user/list", params = {"blocked"})
    public String blockedUser(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("blocked"));
        userService.lockedUser(userId);
        return "redirect:/admin/user/list";
    }

    @RequestMapping(value = "/admin/user/list", params = {"unblocked"})
    public String unblockedUser(HttpServletRequest request) {
        Long userId = Long.valueOf(request.getParameter("unblocked"));
        userService.unlockedUser(userId);
        return "redirect:/admin/user/list";
    }
}
