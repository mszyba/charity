package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @ModelAttribute("institutions")
    public List<Institution> listInstitution() {
        return institutionService.getAll();
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }
}
