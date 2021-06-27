package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id join user_role r on r.id = ur.roles_id where r.role='ROLE_ADMIN'", nativeQuery = true)
    List<User> findAllAdmins();
}
