package org.example.securitydemo.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class StaticConfigure implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/home/welcome").setViewName("welcome.html");
    }
}
