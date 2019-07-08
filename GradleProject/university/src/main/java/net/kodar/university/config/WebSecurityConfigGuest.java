package net.kodar.university.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(3)
public class WebSecurityConfigGuest extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/studentteacher/**", "studentteacherdiscipline/**")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/studentteacher/**", "studentteacherdiscipline/**")
                .permitAll();
    }
}