package com.team.project.Config.Auth;

import com.team.project.Enum.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/main", "/oauth2/**", "/login","/gallery","/gallery/**", "/login/**", "/category/","/board/**", "/css/**",
                        "/img/**", "/js/**", "/console/**", "/h2-console/**", "/profile","/swagger-ui.html#", "/post/**","/api/v1/**").permitAll()
                .antMatchers("/admin/**","/api/v1/notice/**","/notices/save").hasRole(Role.ADMIN.name())
                .antMatchers("/category/save/**","/category/**/appl/**").hasRole(Role.MASTER.name())
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/main").deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and()
                .csrf().disable()
                .oauth2Login().loginPage("/login")
                .defaultSuccessUrl("/main")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}