// src/main/java/com/example/security/SecurityConfig.java
<<<<<<< HEAD
//package com.example.demo.security;
=======
>>>>>>> aa43f8e (update)
package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
<<<<<<< HEAD
import org.springframework.security.config.http.SessionCreationPolicy;
=======
>>>>>>> aa43f8e (update)
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ForwardedHeaderFilter;

<<<<<<< HEAD
import com.example.demo.model.Count;

=======
>>>>>>> aa43f8e (update)
@Configuration
@EnableMethodSecurity // enables @PreAuthorize, etc.
public class SecurityConfig {

<<<<<<< HEAD
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
=======
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
>>>>>>> aa43f8e (update)

    return http.build();
  }

<<<<<<< HEAD
@Bean PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
@Bean UserDetailsService users(PasswordEncoder enc) {
  return new InMemoryUserDetailsManager(
    User.withUsername("alice").password(enc.encode("password1")).roles("USER").build(),
    User.withUsername("bob").password(enc.encode("password2")).roles("ADMIN").build()
  );
}

=======
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
>>>>>>> aa43f8e (update)

}
