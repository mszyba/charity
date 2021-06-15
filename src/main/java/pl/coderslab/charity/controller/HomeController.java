package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @ModelAttribute("institutions")
    public List<Institution> listInstitution() {
        return institutionService.getAll();
    }

    @ModelAttribute("sumBags")
    public Integer sumBags() {
        if (donationService.sumBags() == null) {
            return 0;
        } else {
            return donationService.sumBags();
        }
    }

    @RequestMapping("/")
    public String homeAction(Model model) {
        return "index";
    }
}
