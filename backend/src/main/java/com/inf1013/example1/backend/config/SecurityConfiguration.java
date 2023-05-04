package com.inf1013.example1.backend.config;


import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

  @Configuration
  @EnableWebSecurity
  public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;

    @Autowired
    private JwtFilter jwtFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

      auth.userDetailsService(userService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.csrf()
        .disable()
        .authorizeRequests()
        .antMatchers("/authenticate")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }
  }

