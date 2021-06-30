package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id join user_role r on r.id = ur.roles_id where r.role='ROLE_ADMIN' AND is_active=true", nativeQuery = true)
    List<User> findAllAdmins();

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id join user_role r on r.id = ur.roles_id where r.role='ROLE_ADMIN' AND u.id=(:id)", nativeQuery = true)
    Optional <User> findUserByIdAndRolesAdmin(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.firstName = :firstName, u.lastName = :lastName, u.password = :password, u.email = :email WHERE u.id = :id")
    void updateAdmin(@Param("firstName") String firstName,
                    @Param("lastName") String lastName,
                    @Param("password") String password,
                    @Param("email") String email,
                    @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.isActive = false WHERE u.id=?1")
    void softDelete(Long id);

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id join user_role r on r.id = ur.roles_id where r.role='ROLE_USER' AND is_active=true", nativeQuery = true)
    List<User> findAllUser();

    @Query(value = "select * from users u join users_roles ur on u.id = ur.user_id join user_role r on r.id = ur.roles_id where r.role=(:role) AND u.id=(:id)", nativeQuery = true)
    Optional <User> findUserByIdAndRole(String role, Long id);
}
