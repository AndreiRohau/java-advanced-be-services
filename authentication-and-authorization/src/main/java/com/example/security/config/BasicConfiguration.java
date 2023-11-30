package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {

  @Bean
  public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
    UserDetails userNoRoles = User.withUsername("userNoRoles")
        .password(passwordEncoder.encode("passwordUserNoRoles"))
        .roles()
        .build();

    UserDetails user = User.withUsername("user1")
        .password(passwordEncoder.encode("password1"))
        .roles("VIEW_INFO")
        .build();

    UserDetails admin = User.withUsername("admin")
        .password(passwordEncoder.encode("admin"))
        .roles("VIEW_INFO", "VIEW_ADMIN")
        .build();

    return new InMemoryUserDetailsManager(userNoRoles, user, admin);
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .regexMatchers("/app/about").permitAll()
            .regexMatchers("/app/info").access("hasRole('VIEW_INFO')")
            .regexMatchers("/**").hasRole("VIEW_ADMIN")

//        .requestMatchers("/app/about").permitAll()
//        .requestMatchers("/app/info").access("hasRole('VIEW_INFO')")
//        .requestMatchers("/**").hasRole("VIEW_ADMIN")
        .and()
        .httpBasic();
    return http.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    return encoder;
  }
}