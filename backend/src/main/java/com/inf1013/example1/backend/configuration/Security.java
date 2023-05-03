package com.inf1013.example1.backend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

import com.inf1013.example1.backend.configuration.UsernamePasswordFilter;

@Configuration
public class Security {

    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    private UserAuthenticationEntryPoint userAuthenticationEntryPoint;

    //Configure the security filter chain to authenticate all requests
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

      System.out.println("Security.filterChain()");

      http
        .exceptionHandling().authenticationEntryPoint(userAuthenticationEntryPoint)
        .and()
        .addFilterBefore(new UsernamePasswordFilter(userAuthenticationProvider), BasicAuthenticationFilter.class)
        .addFilterBefore(new JwtAuthFilter(userAuthenticationProvider), UsernamePasswordFilter.class)
        .csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeHttpRequests((requests) -> requests
          .requestMatchers(HttpMethod.POST,
            "/api/user/register",
            "/api/user/login"
          ).permitAll()
          .requestMatchers(HttpMethod.GET,
            "/api/offer/all"
          ).permitAll()
          .anyRequest().authenticated())
        .cors().configurationSource(corsConfigurationSource())
      ;
      return http.build();
    }

    //Configure CORS globally for the application
    @Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200", "https://coiffex.store"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
