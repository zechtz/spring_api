package com.watabelabs.api.services;

import com.watabelabs.api.dto.RegistrationRequest;
import com.watabelabs.api.exceptions.SpringApiException;
import com.watabelabs.api.model.NotificationEmail;
import com.watabelabs.api.model.User;
import com.watabelabs.api.model.VerificationToken;
import com.watabelabs.api.repository.UserRepository;
import com.watabelabs.api.repository.VerificationTokenRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/** AuthService */
@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

  private final PasswordEncoder passwordEncoder;
  private final UserRepository userRepository;
  private final VerificationTokenRepository verificationTokenRepository;
  private final MailService mailService;

  // @Transactional
  public void signUp(RegistrationRequest registrationRequest) {
    User user = new User();
    user.setName(registrationRequest.getUsername());
    user.setEmail(registrationRequest.getEmail());
    user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    user.setCreatedAt(Instant.now());
    user.setEnabled(false);

    userRepository.save(user);

    log.debug("User Object line 36: {}", user);
    String token = generateVerificationToken(user);

    mailService.sendMail(
        new NotificationEmail(
            "Please activate your account",
            user.getEmail(),
            "Thank you for signing up to Reddit, "
                + "Please click on the url below to activate your account: "
                + "http://localhost:8080/api/v1/auth/account-verification/"
                + token));
  }

  private String generateVerificationToken(User user) {
    String token = UUID.randomUUID().toString();
    VerificationToken verificationToken = new VerificationToken();
    verificationToken.setToken(token);
    verificationToken.setUser(user);

    log.debug("User Object line 46: {}", user);
    verificationTokenRepository.save(verificationToken);

    return token;
  }

  public void verifyAccount(String token) {
    Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
    fetchUserAndEnable(
        verificationToken.orElseThrow(() -> new SpringApiException("Invalid Token")));
  }

  private void fetchUserAndEnable(VerificationToken verificationToken) {
    User user = verificationToken.getUser();
    user.setEnabled(true);
    userRepository.save(user);
  }
}
