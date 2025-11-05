package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;      
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;  
import org.springframework.security.crypto.password.PasswordEncoder;            

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/error", "/css/**", "/js/**", "/images/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
        .anyRequest().authenticated()
      )
      // Disable saved request to avoid redirecting to stale localhost:8080
      .requestCache(cache -> cache.disable())

      .formLogin(form -> form
        .loginPage("/login").permitAll()
        // Force a context-relative redirect to /home
        .successHandler((req, res, auth) -> res.sendRedirect(req.getContextPath() + "/home"))
        .failureUrl("/login?error")
      )
      .logout(logout -> logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login?logout")
      )
      .csrf(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  UserDetailsService userDetailsService(PasswordEncoder encoder) {
    return new InMemoryUserDetailsManager(
      User.withUsername("alice").password(encoder.encode("password1")).roles("USER").build(),
      User.withUsername("bob").password(encoder.encode("password2")).roles("ADMIN").build()
    );
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
