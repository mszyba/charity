package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.service.CategoryService;

import java.util.List;

@Controller
public class DonationFormController {

    private final CategoryService categoryService;

    public DonationFormController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    public List<Category> categoryList() {
        return categoryService.getAll();
    }

    @GetMapping("/form")
    public String getAddDonationForm() {
        return "form";
    }

    @PostMapping("/form")
    public String postAddDonationForm() {
        return "redirect:/";
    }
}
