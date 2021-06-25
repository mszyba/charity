package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;

@Controller
public class AdminInstitutionController {

    private final InstitutionService institutionService;

    public AdminInstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/admin/institution/list")
    public String getAllInstitution(Model model) {
        model.addAttribute("institutions", institutionService.getAll());
        return "/admin/institution-all";
    }

    @GetMapping("/admin/institution/add")
    public String getAddInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "/admin/institution-add";
    }

    @PostMapping("/admin/institution/add")
    public String postAddInstitution(@Valid Institution institution, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/institution-add";
        }
        model.addAttribute("institution", institution);
        institutionService.add(institution);
        return "redirect:/admin/institution/list";
    }

    @GetMapping("/admin/institution/edit/{id}")
    public String editInstitutionById(@PathVariable Long id, Model model) {
        model.addAttribute("institution", institutionService.getInstitutionById(id));
        return "/admin/institution-add";
    }
}
