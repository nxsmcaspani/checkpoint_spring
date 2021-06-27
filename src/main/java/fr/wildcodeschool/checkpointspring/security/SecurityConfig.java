package fr.wildcodeschool.checkpointSpring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
            .withUser("Admin")
            .password(encoder.encode("W1ld43v3r!"))
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .requestMatchers(req-> req.getRequestURI().contains("add")).authenticated()
                .requestMatchers(req-> req.getRequestURI().contains("create")).authenticated()
                .requestMatchers(req-> req.getRequestURI().contains("update")).authenticated()
                .requestMatchers(req-> req.getRequestURI().contains("delete")).authenticated()
                .requestMatchers(req-> req.getRequestURI().contains("add")).hasRole("ADMIN")
                .requestMatchers(req-> req.getRequestURI().contains("create")).hasRole("ADMIN")
                .requestMatchers(req-> req.getRequestURI().contains("update")).hasRole("ADMIN")
                .requestMatchers(req-> req.getRequestURI().contains("delete")).hasRole("ADMIN")
                .anyRequest().permitAll()
            .and()
                .formLogin()
            .and()
                .logout()
                .invalidateHttpSession(true)
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");
    }
}
