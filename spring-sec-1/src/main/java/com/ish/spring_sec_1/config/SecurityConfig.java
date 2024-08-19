package com.ish.spring_sec_1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    private  UserDetailsService userDetailsService;


    // working with dynamic user
    @Bean
    public AuthenticationProvider authenticationProvider()

    {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
        .csrf(customizer -> customizer.disable())
        .authorizeHttpRequests((request)->request.anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

    }






    // -----------------for provide own user details this is static values------------------
//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user = User
//                            .withDefaultPasswordEncoder()
//                            .username("ish")
//                            .password("1234")
//                            .roles("USER")
//                            .build();
//
//        UserDetails admin = User
//                            .withDefaultPasswordEncoder()
//                            .username("admin")
//                            .password("admin")
//                            .roles("ADMIN")
//                            .build();
//
//        return new  InMemoryUserDetailsManager(user,admin);
//    }
}


//------ below code is can make use default login designed form-----------------------------

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(customizer -> customizer.disable()) // CSRF protection is disabled
//                .authorizeHttpRequests((request) -> request.anyRequest().authenticated()) // All requests require authentication
//                .formLogin(withDefaults()) // Enable form-based login
//                .sessionManagement(session ->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Stateless session management
//                .httpBasic(withDefaults()); // Basic authentication (optional)
//
//        return http.build();
//    }




//        http.csrf(customizer -> customizer.disable());
//        http.authorizeHttpRequests((request)->request.anyRequest().authenticated());
////        http.formLogin(Customizer.withDefaults());  --> no need for when we are working on stateless
//        http.httpBasic(Customizer.withDefaults());  --> it will be popup for signin
////        making site as a stateless mean generate new session id for each request
//        http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        return http.build();



//// -------------------without lambda-----------------
////----------1.
//        Customizer<CsrfConfigurer<HttpSecurity>> custCsrf = new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> httpSecurityCsrfConfigurer) {
//
//            }
//        };
//       http.csrf(custCsrf);
//
////---------2.
//        Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> custHttp = new Customizer<AuthorizeHttpRequestsConfigurer<org.springframework.security.config.annotation.web.builders.HttpSecurity>.AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
//                registry.anyRequest().authenticated();
//            }
//        };
//        http.authorizeHttpRequests(custHttp);
//
//        return http.build();