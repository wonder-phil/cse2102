// src/main/java/com/example/security/SecurityConfig.java
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
@EnableMethodSecurity // enables @PreAuthorize, etc.
public class SecurityConfig {

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/public/**", "/css/**", "/js/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
        .anyRequest().authenticated()
      )
      .formLogin(form -> form
      .loginPage("/login").permitAll()
      .successHandler((req, res, auth) -> res.sendRedirect(req.getContextPath() + "/home"))
    )
  
      .logout(logout -> logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/")
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
