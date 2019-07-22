package net.kodar.university.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
//@EnableWebSecurity
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
//                .authorizeRequests()
//                .antMatchers("/student/**", "/teacher/**")
//                .hasRole("ADMIN")
//                .and().formLogin()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/studentteacher/**", "/studentteacherdiscipline/**")
//                .hasRole("USER")
//                .and().formLogin()
//                .and()
//                .authorizeRequests().anyRequest().permitAll();
    }
}

