// src/main/java/com/example/security/SecurityConfig.java
//package com.example.demo.security;
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

import com.example.demo.model.Count;

@Configuration
@EnableMethodSecurity // enables @PreAuthorize, etc.
public class SecurityConfig {

@Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(a -> a
        .requestMatchers("/", "/login", "/css/**", "/js/**").permitAll()
        .anyRequest().authenticated()
      )
      // NEW session on successful authentication
      .sessionManagement(sm -> sm
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
        .sessionFixation(fix -> fix.newSession())     // <- forces NEW session id at login
      )
      .formLogin(f -> f
        .loginPage("/login").permitAll()
        .successHandler((req, res, auth) -> {
          // At this point Spring has already created a NEW session
          // You can safely initialize per-user attributes here:
          //req.getSession().setAttribute("count", new Count());
          res.sendRedirect(req.getContextPath() + "/home");
        })
      )
      .logout(l -> l.logoutUrl("/logout").logoutSuccessUrl("/login?logout"))
      .csrf(csrf -> {}); // keep CSRF enabled by default

    return http.build();
  }

@Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
@Bean UserDetailsService users(PasswordEncoder enc) {
  return new InMemoryUserDetailsManager(
    User.withUsername("alice").password(enc.encode("password1")).roles("USER").build(),
    User.withUsername("bob").password(enc.encode("password2")).roles("ADMIN").build()
  );
}


}
