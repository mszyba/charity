package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public List<Donation> getAll() {
        return donationRepository.findAll();
    }

    public Integer sumBags() {
        return donationRepository.sumBags();
    }

    public Integer sumDotations() {
        return donationRepository.sumDonations();
    }

    public void add(Donation donation) {
        donationRepository.save(donation);
    }
}
