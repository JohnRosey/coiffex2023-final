package com.inf1013.example1.backend.configuration;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.inf1013.example1.backend.services.implementation.AuthentificationService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.inf1013.example1.backend.dto.UserLogin;
import com.inf1013.example1.backend.models.User;

@Component
public class UserAuthenticationProvider {

  private String secretKey = "5gc4oVLasK@tZLMyqCe*D7wUm1#BJ844*0UN0f14!3yFb0PL$A";

  private final AuthentificationService authenticationService;

  public UserAuthenticationProvider(AuthentificationService authenticationService) {
    this.authenticationService = authenticationService;
  }

  @PostConstruct
  protected void init() {
    // this is to avoid having the raw secret key available in the JVM
    secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
  }

  public String createToken(String login) {
    Date now = new Date();
    Date validity = new Date(now.getTime() + 3600000); // 1 hour

    Algorithm algorithm = Algorithm.HMAC256(secretKey);
    return JWT.create()
      .withIssuer(login)
      .withIssuedAt(now)
      .withExpiresAt(validity)
      .sign(algorithm);
  }

  public Authentication validateToken(String token) {

    System.out.println("Token :" + token);

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    JWTVerifier verifier = JWT.require(algorithm)
      .build();

    DecodedJWT decoded = verifier.verify(token);

    Optional<User> user = authenticationService.findByUsername(decoded.getIssuer());

    System.out.println("User :" + user);

    if (user.isEmpty()) {
      throw new RuntimeException("User not found");
    }

    System.out.println(new UsernamePasswordAuthenticationToken(user, user, Collections.emptyList()));
    return new UsernamePasswordAuthenticationToken(user, user, Collections.emptyList());
  }

  public Authentication validateCredentials(UserLogin userLogin) {

    System.out.println("Provider :");
    System.out.println("userLogin.getUsername() = " + userLogin.getUsername());
    System.out.println("userLogin.getPassword() = " + userLogin.getPassword());

    String user = authenticationService.login(userLogin);
    System.out.println("user = " + user);
    return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
  }


}
