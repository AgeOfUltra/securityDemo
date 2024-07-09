package org.example.securitydemo.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurer {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http.csrf(AbstractHttpConfigurer::disable).
                authorizeHttpRequests((auth) -> auth.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


//        http.authorizeHttpRequests((auth)->auth.anyRequest().denyAll()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

//        http.authorizeHttpRequests((auth)-> auth.requestMatchers("/","/home","/home/**","/message").permitAll()
//                        .requestMatchers("/hello").denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());


        return http.build();
    }
}
