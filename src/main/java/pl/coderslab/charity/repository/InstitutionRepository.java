package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    @Query("SELECT CASE WHEN COUNT(i)>0 THEN TRUE ELSE FALSE END FROM Institution i JOIN Donation d on i.id = d.institution.id WHERE i.id=(:id)")
    boolean existsInstitutionByIdIfHaveDonations(@Param("id") Long id);
}
