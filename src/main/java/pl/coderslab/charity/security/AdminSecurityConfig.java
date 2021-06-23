package pl.coderslab.charity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(1)
public class AdminSecurityConfig  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/admin/**")
            .authorizeRequests()
            .anyRequest()
                .hasRole("ADMIN")
            .and()
        .formLogin()
            .loginPage("/admin/login")
            .defaultSuccessUrl("/admin/home", true)
            .permitAll()
            .and()
        .logout()
            .logoutUrl("/admin/logout")
            .logoutSuccessUrl("/admin/login")
            .permitAll();
    }
}
