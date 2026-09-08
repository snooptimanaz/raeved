package com.raever.service;
import com.raever.model.User;
import com.raever.repository.UserRepository;
import com.raever.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AuthService {
    @Autowired private UserRepository userRepository;
    @Autowired private JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) { throw new RuntimeException("E-Mail bereits registriert!"); }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        user.setCreatedAt(LocalDateTime.now());
        if (user.getRole() == null) { user.setRole("user"); }
        return userRepository.save(user);
    }
    public String login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isEmpty()) { throw new RuntimeException("Benutzer nicht gefunden!"); }
        User user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getPasswordHash())) { throw new RuntimeException("Falsches Passwort!"); }
        return jwtUtil.generateToken(user.getEmail(), user.getRole());
    }
}