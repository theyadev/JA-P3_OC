package com.openclassrooms.P3_OC.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Security {

    @Autowired
    private EntryPoint entryPoint;

    @Autowired
    private RequestFilter requestFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public static AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                // disable Cross-Site Request Forgery
                .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(entryPoint).and()
                // Spring Security will never create an HttpSession and it will never use it to
                // obtain the Security Context
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeHttpRequests()
                // Authorize access to register and login
                .requestMatchers(
                        request -> request
                                .getMethod().equals(HttpMethod.POST.name())
                                && (request.getServletPath().equals("/api/auth/login")
                                        || request.getServletPath().equals("/api/auth/register")))
                .permitAll()
                // Authorize access to swagger documentation, response status error, upload
                // folder for images
                // .requestMatchers("/v3/**", "/swagger-ui/**", "/error/**", "/images/**")
                // .permitAll()
                // user should be authenticated for any other request in application
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        // Add a filter to validate the tokens with every request
        http.addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
