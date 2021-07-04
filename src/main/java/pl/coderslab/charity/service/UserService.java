package pl.coderslab.charity.service;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserEditDTO;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.UserRole;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.UserRoleRepository;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
    private static final String ROLE_ADMIN = "ROLE_ADMIN";
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void add(User user) {
        userRepository.save(user);
    }

    public void addWithDefaultRole(User user) {
        UserRole defaultRole = userRoleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

    public List<User> getAllAdmin() {
        return userRepository.findAllAdmins();
    }

    public void addAdmin(User user) {
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRoleRepository.findByRole("ROLE_ADMIN"));
        user.setRoles(roles);
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
        userRepository.save(user);
    }

    public User getAdminById(Long id) {
        Optional<User> optionalUser = userRepository.findUserByIdAndRole(ROLE_ADMIN, id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            throw new EntityNotFoundException();
        }
    }

    public UserEditDTO getUserByIdAndRole(Long id, String role) {
        Optional<User> optionalUser = userRepository.findUserByIdAndRole(role, id);

        if (optionalUser.isPresent()) {
            ModelMapper mapper = new ModelMapper();
            return mapper.map(optionalUser.get(), UserEditDTO.class);
        } else {
            throw new EntityNotFoundException();
        }
    }

    public void updateAdmin(User user) {
        Long userId = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        String password = passwordEncoder.encode(user.getPassword());
        String email = user.getEmail();

        this.userRepository.updateAdmin(firstName, lastName, password, email, userId);
    }

    public void softDeleteAdmin(Long id) {
        this.userRepository.softDelete(id);
    }

    public List<User> getAllUser() {
        return userRepository.findAllUser();
    }

    public void updateUser(UserEditDTO userEditDTO) {
        Optional<User> optionalUser = userRepository.findById(userEditDTO.getId());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userEditDTO.getFirstName());
            user.setLastName(userEditDTO.getLastName());
            log.info("Changed to: " + userEditDTO);

            userRepository.save(user);
        }
    }

    public void lockedUser(Long id) {
        this.userRepository.lockedUser(id);
    }

    public void unlockedUser(Long id) {
        this.userRepository.unlockedUser(id);
    }
}
