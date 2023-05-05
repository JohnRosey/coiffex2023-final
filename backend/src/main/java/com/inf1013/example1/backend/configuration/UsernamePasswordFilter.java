package com.inf1013.example1.backend.configuration;

import java.io.IOException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.inf1013.example1.backend.configuration.UserAuthenticationProvider;
import com.inf1013.example1.backend.dto.UserLogin;

public class UsernamePasswordFilter extends OncePerRequestFilter {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private final UserAuthenticationProvider userAuthenticationProvider;

  public UsernamePasswordFilter(UserAuthenticationProvider userAuthenticationProvider) {
    this.userAuthenticationProvider = userAuthenticationProvider;
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest httpServletRequest,
    HttpServletResponse httpServletResponse,
    FilterChain filterChain) throws ServletException, IOException {

    if ("/api/user/login".equals(httpServletRequest.getServletPath())
      && HttpMethod.POST.matches(httpServletRequest.getMethod())) {

        String username = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");

        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(username);
        userLogin.setPassword(password);

      try {
        SecurityContextHolder.getContext().setAuthentication(
          userAuthenticationProvider.validateCredentials(userLogin));

      } catch (RuntimeException e) {
        SecurityContextHolder.clearContext();
        throw e;
      }
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}
