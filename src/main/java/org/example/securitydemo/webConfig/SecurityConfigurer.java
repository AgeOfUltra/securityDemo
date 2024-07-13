package org.example.securitydemo.webConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigurer {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         default login page
//        http.csrf(AbstractHttpConfigurer::disable)
//        .authorizeHttpRequests((auth) -> auth.requestMatchers("/","/home").authenticated()
//                        .requestMatchers("/message").authenticated()
//                        .requestMatchers("/home/welcome").denyAll()
//                        .requestMatchers("/hello").permitAll()
//                        .requestMatchers("/saveMessage").permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

//        http.authorizeHttpRequests((auth)->auth.anyRequest().permitAll()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

//        http.authorizeHttpRequests((auth)->auth.anyRequest().denyAll()).formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

//        http.authorizeHttpRequests((auth)-> auth.requestMatchers("/","/home","/home/**","/message").permitAll()
//                        .requestMatchers("/hello").denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

//        custom Login Page
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((auth) -> auth.requestMatchers("/","/home").permitAll()
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/message").permitAll()
                        .requestMatchers("/home/welcome").permitAll()
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/saveMessage").permitAll()
                        .requestMatchers("/login").permitAll())
                .formLogin(login -> login.loginPage("/login").defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true").permitAll())
                .logout(logout->logout.logoutSuccessUrl("/login?logout=true").logoutSuccessUrl("/home")
                        .invalidateHttpSession(true).permitAll())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetails(){
        User.UserBuilder  users = User.withDefaultPasswordEncoder();

        UserDetails user = users
                .username("user")
                .password("12345")
                .roles("USER")
                .build();

        UserDetails admin = users
                .username("admin")
                .password("123456")
                .roles("ADMIN")
                .build();

        return  new InMemoryUserDetailsManager(user,admin);
    }
}
