package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;
    private final CategoryService categoryService;

    public DonationService(DonationRepository donationRepository, CategoryService categoryService) {
        this.donationRepository = donationRepository;
        this.categoryService = categoryService;
    }

    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    public Integer sumBags() {
        return donationRepository.sumBags();
    }

    public Integer sumDonations() {
        return donationRepository.sumDonations();
    }

    public void add(Donation donation) {
//        for (String categoryId : categoryIds.split(",")) {
//            if (categoryId != null || !categoryId.equals("")) {
//                donation.setCategories(categoryId);
//            }

        donationRepository.save(donation);
    }
}
