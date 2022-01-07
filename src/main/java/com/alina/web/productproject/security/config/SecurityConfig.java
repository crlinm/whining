package com.alina.web.productproject.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/users").authenticated()
                .antMatchers("/users/**").authenticated()
                .antMatchers("/profile**").authenticated()
                .antMatchers("/whine").authenticated()
                .antMatchers("/whines/**").authenticated()
                .antMatchers("/users/**/whines").permitAll()
                .antMatchers("/signUp").permitAll()
                .antMatchers("/home").authenticated()
                .and()
                .formLogin()
                .loginPage("/signIn")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/users").authenticated()
//                .antMatchers("/users/**").hasAuthority("ADMIN")
//                .antMatchers("/signUp").permitAll()
//                .antMatchers("/files/upload/**").authenticated()
//                .antMatchers(HttpMethod.GET, "/files/**").permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/signIn")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/users")
//                .permitAll();
//    }
}
