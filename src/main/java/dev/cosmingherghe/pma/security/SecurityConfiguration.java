package dev.cosmingherghe.pma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("select username, password, enabled " +
                        "from user_account where username = ?")
                .authoritiesByUsernameQuery("select username, role " +
                        "from user_account where username = ?")
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.requiresChannel()
                .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
                .requiresSecure();

        httpSecurity.authorizeRequests()

//                .antMatchers("/api/**").hasAuthority(ADMIN.name())
//                .antMatchers("/projects/new").hasAuthority(ADMIN.name())
//                .antMatchers("/projects/save").hasAuthority(ADMIN.name())
//                .antMatchers("/employees/new").hasAuthority(ADMIN.name())
//                .antMatchers("/employees/save").hasAuthority(ADMIN.name())
                .antMatchers("/","/**").permitAll()
                //.antMatchers("/h2-console","/**").permitAll()
                //.antMatchers("/").authenticated()
                //.anyRequest()
                //.authenticated()
                .and()
                //.httpBasic();
                .formLogin();


//      httpSecurity.csrf().disable();
//      httpSecurity.headers().frameOptions().disable();
    }
}