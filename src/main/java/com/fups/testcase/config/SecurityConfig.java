package com.fups.testcase.config;


import com.fups.testcase.security.JwtAccessDeniedHandler;
import com.fups.testcase.security.JwtAuthenticationEntryPoint;
import com.fups.testcase.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final JwtAccessDeniedHandler accessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    public SecurityConfig(JwtFilter jwtFilter, JwtAccessDeniedHandler accessDeniedHandler, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtFilter = jwtFilter;
        this.accessDeniedHandler = accessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .cors().and()
                .authorizeHttpRequests((auth) -> {
                    auth.antMatchers("/api/dashboard").hasAnyAuthority("STANDARD", "PREMIUM", "ACCEPTED");
                    auth.antMatchers("/api/menu").hasAnyAuthority("STANDARD", "PREMIUM", "ACCEPTED");
                    auth.antMatchers("/api/premium").hasAnyAuthority("PREMIUM");
                    auth.antMatchers("/api/test").hasAnyAuthority("STANDARD", "PREMIUM");
                    auth.anyRequest().authenticated();
                })
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(jwtAuthenticationEntryPoint).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().antMatchers("/api/public", "/api/auth/login"));
    }

    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("*");
            }
        };
    }
}
