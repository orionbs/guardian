package fr.orionbs.guardian.adapter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        httpSecurity.exceptionHandling(httpSecurityExceptionHandlingConfigurer -> {
            httpSecurityExceptionHandlingConfigurer.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/authenticate"));
        });

        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry.requestMatchers("/authenticate").permitAll();
            authorizationManagerRequestMatcherRegistry.requestMatchers("/register").permitAll();
            authorizationManagerRequestMatcherRegistry.requestMatchers("/error").permitAll();
            authorizationManagerRequestMatcherRegistry.requestMatchers("/css/**").permitAll();
            authorizationManagerRequestMatcherRegistry.requestMatchers("/js/**").permitAll();
            authorizationManagerRequestMatcherRegistry.requestMatchers("/img/favicon.ico").permitAll();

        });

        httpSecurity.authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
            authorizationManagerRequestMatcherRegistry.anyRequest().authenticated();
        });

        return httpSecurity.build();

    }


}
