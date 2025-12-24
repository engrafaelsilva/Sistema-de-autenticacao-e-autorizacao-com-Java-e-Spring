package br.projetopesoal.systemlogin.service;

import br.projetopesoal.systemlogin.dto.AuthResponse;
import br.projetopesoal.systemlogin.dto.LoginRequest;
import br.projetopesoal.systemlogin.dto.RegisterRequest;
import br.projetopesoal.systemlogin.entity.User;
import br.projetopesoal.systemlogin.enums.Role;
import br.projetopesoal.systemlogin.exception.EmailAlreadyExistsException;
import br.projetopesoal.systemlogin.exception.InvalidCredentialsException;
import br.projetopesoal.systemlogin.exception.UserNotFoundException;
import br.projetopesoal.systemlogin.repository.UserRepository;
import br.projetopesoal.systemlogin.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    private static final String ADMIN_EMAIL = "adm@email.com";
    private static final String ADMIN_PASSWORD = "adm123";

    public AuthResponse register(RegisterRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException();
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(encoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        repository.save(user);

        return new AuthResponse(
                jwtService.generateToken(user.getEmail()),
                user.getRole().name()
        );
    }

    public AuthResponse login(LoginRequest request) {

        if (request.getEmail().equals(ADMIN_EMAIL)
                && request.getPassword().equals(ADMIN_PASSWORD)) {

            return new AuthResponse(
                    jwtService.generateToken(ADMIN_EMAIL),
                    Role.ADMIN.name()
            );
        }

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFoundException::new);

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }

        return new AuthResponse(
                jwtService.generateToken(user.getEmail()),
                user.getRole().name()
        );
    }
}
