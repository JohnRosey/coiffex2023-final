package com.inf1013.example1.backend.configuration;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthFilter extends OncePerRequestFilter {

  private final UserAuthenticationProvider userAuthenticationProvider;

  public JwtAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
    this.userAuthenticationProvider = userAuthenticationProvider;
  }

  @Override
  protected void doFilterInternal(
    HttpServletRequest httpServletRequest,
    HttpServletResponse httpServletResponse,
    FilterChain filterChain) throws ServletException, IOException {
    String header = httpServletRequest.getHeader(HttpHeaders.AUTHORIZATION);

    if (header != null) {

      System.out.println("header: " + header);

      String[] authElements = header.split(" ");

      if (authElements.length == 2
        && "Bearer".equals(authElements[0])) {

        System.out.println("header: " + header);

        try {
          SecurityContextHolder.getContext().setAuthentication(
            userAuthenticationProvider.validateToken(authElements[1]));

        } catch (RuntimeException e) {
          SecurityContextHolder.clearContext();
          throw e;
        }
      }
    }

    filterChain.doFilter(httpServletRequest, httpServletResponse);
  }
}