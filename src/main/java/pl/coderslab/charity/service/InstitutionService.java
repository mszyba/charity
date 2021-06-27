package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> getAll() {
        return institutionRepository.findAll();
    }

    public void add(Institution institution) {
        this.institutionRepository.save(institution);
    }

    public Institution getInstitutionById(Long id) {
        Optional<Institution> optionalInstitution = institutionRepository.findById(id);
        if (optionalInstitution.isPresent()) {
            return optionalInstitution.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void deleteById(Long id) {
        this.institutionRepository.deleteById(id);
    }

    /**
     * @param id Institution
     * @return true if Institution has any Donation
     */
    public boolean isExistInstitution(Long id) {
        return institutionRepository.existsInstitutionByIdIfHaveDonations(id);
    }
}
