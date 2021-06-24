package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.service.InstitutionService;

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
}
