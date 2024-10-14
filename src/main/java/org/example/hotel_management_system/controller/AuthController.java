package org.example.hotel_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.example.hotel_management_system.dto.AuthRequest;
import org.example.hotel_management_system.dto.LoginRequest;
import org.example.hotel_management_system.entity.User;
import org.example.hotel_management_system.repository.UserRepository;
import org.example.hotel_management_system.roles.UserRole;
import org.example.hotel_management_system.utils.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:1111")
public class AuthController {
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthRequest authRequest) throws Exception {
        if (this.userRepository.findByEmail(authRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("USERNAME IS ALREADY EXISTS");
        }
        User user = User.builder()
                .username(authRequest.getUsername())
                .password(passwordEncoder.encode(authRequest.getPassword()))
                .role(UserRole.USER)
                .email(authRequest.getEmail())
                .age(authRequest.getAge())
                .lastname(authRequest.getLastname())
                .firstname(authRequest.getFirstname())
                .phoneNumber(authRequest.getPhoneNumber())
                .build();
        this.userRepository.save(user);
        return ResponseEntity.ok("REGISTERED SUCCESSFULLY");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest authRequest) throws Exception {
        User user = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new Exception("User not found"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());
        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/getUsername")
    public ResponseEntity<?> getUsername(@RequestParam String token) {
        String username = jwtUtil.extractUsername(token);
        return ResponseEntity.ok(username);
    }
}
