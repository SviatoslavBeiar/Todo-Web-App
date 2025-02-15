package com.in28Min.springboot.myfurstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.function.Function;

//@Configuration
public class SpringSecurityConfiguration {

        @Bean
    public InMemoryUserDetailsManager createUserDetailsManger(){

            UserDetails userDetails1 = creatNewUser("Valera", "123");
            UserDetails userDetails2 = creatNewUser("dada", "321");

            return new InMemoryUserDetailsManager(userDetails1, userDetails2);
        }

    private UserDetails creatNewUser(String username, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);
        UserDetails userDetails = User.builder()
               .passwordEncoder(passwordEncoder)
               .username(username)
               .password(password)
               .roles("USER","ADMIN")
               .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
                    auth ->auth.anyRequest().authenticated()
            );
            http.formLogin(withDefaults());
            http.csrf().disable();
            http.headers().frameOptions().disable();

            return  http.build();


    }


}
