package org.albertorado.apigeowork.configuracion;

import org.albertorado.apigeowork.filter.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



@Configuration
public class ConfiguracionSeguridad{

    @Value("${jwt.secret}")
    private String SECRET_KEY;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desactivar CSRF solo en las rutas específicas
                .csrf(csrf -> csrf.disable()).authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
                /**
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/autenticacion/login/usuario",
                                "/autenticacion/login/empresa"
                        ).permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(new JwtTokenFilter(SECRET_KEY), UsernamePasswordAuthenticationFilter.class);
**/
        return http.build();
    }
}




