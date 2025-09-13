package com.openflicker.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public static PasswordEncoder passwordEncoder() {
        // Use BCrypt for strong, salted password hashing
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                                // Allow access to static resources like CSS and JS
                                .requestMatchers(
                                        "/css/**",
                                        "/js/**",
                                        "/test/**",
                                        "/test",
                                        "/home",
                                        "/price"
                                ).permitAll()
                        // All other requests must be authenticated
                        .anyRequest().authenticated()

                )
                .formLogin(form -> form
                        // Specify the URL for the login page
                        .loginPage("/login")
                        // Specify the URL to submit the login form to
                        .loginProcessingUrl("/login")
                        // Specify the URL to redirect to on successful login
                        .defaultSuccessUrl("/home", true)
                        // Allow everyone to access the login page
                        .permitAll()
                )

                .logout(logout -> logout
                        // Allow everyone to access the logout functionality
                        .permitAll()
                )
                // Required for H2 console to work
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));

        return http.build();
    }
}
