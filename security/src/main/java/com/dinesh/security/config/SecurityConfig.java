package com.dinesh.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider  ;
    private final  JwtAuthenticationFilter jwtAuthenticationFilter ;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception
    {
         http.csrf( csrf-> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("auth/api/v1/**").permitAll().anyRequest().authenticated()).sessionManagement(x-> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).authenticationProvider(authenticationProvider).addFilterBefore(jwtAuthenticationFilter , UsernamePasswordAuthenticationFilter.class);

        return  http.build();
    }

}
