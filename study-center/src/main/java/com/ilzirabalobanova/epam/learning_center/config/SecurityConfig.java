package com.ilzirabalobanova.epam.learning_center.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String TEACHER_ROLE = "TEACHER";
    private static final String STUDENT_ROLE = "STUDENT";
    @Autowired
    private DataSource dataSource;
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("Select * from users where username=?").passwordEncoder(passwordEncoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()
                .and().authorizeRequests()
                .antMatchers("/api/students").hasRole(TEACHER_ROLE)
                .antMatchers("/api/students/{studentId}").hasRole(TEACHER_ROLE)
                .antMatchers("/api/students/score/{studentId}").hasRole(TEACHER_ROLE)
                .antMatchers("/api/students/score/{studentId}/{moduleId}/{value}").hasRole(TEACHER_ROLE)
                .antMatchers("/api/programs").hasAnyRole(TEACHER_ROLE, STUDENT_ROLE)
                .antMatchers("/api/students/programs/join/{studentId}/{programId}").hasRole(STUDENT_ROLE)
                .antMatchers("/api/payments/{studentId}/{programId}/{paymentAmount}").hasRole(STUDENT_ROLE)
                .and().formLogin().permitAll().and().sessionManagement().maximumSessions(1)
                .maxSessionsPreventsLogin(false);
    }


}
