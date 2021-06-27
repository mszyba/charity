package pl.coderslab.charity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.UserRole;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.UserRoleRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private static final String DEFAULT_ROLE = "ROLE_USER";
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
}
