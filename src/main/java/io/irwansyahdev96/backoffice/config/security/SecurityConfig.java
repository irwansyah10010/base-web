package io.irwansyahdev96.backoffice.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;

import io.irwansyahdev96.backoffice.base.constant.SecurityUrl;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
    
    @Autowired
    private OnceRequestFilter onceRequestFilter;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.headers()
            .httpStrictTransportSecurity()
            .requestMatcher(AnyRequestMatcher.INSTANCE)
            .and()
            .contentTypeOptions()
            .and()
            .xssProtection()
            .and()
            .cacheControl()
            .and()
            .httpStrictTransportSecurity()
            .and()
            .frameOptions()
            .sameOrigin()
            .addHeaderWriter(new StaticHeadersWriter("Referrer-Policy", "strict-origin-when-cross-origin"))
            .contentSecurityPolicy("frame-ancestors 'none'; script-src 'self' 'unsafe-inline' 'unsafe-eval'");

        httpSecurity
            .authorizeRequests(ar ->{
                ar
                .antMatchers(SecurityUrl.DENY_URL).denyAll()
                .anyRequest().fullyAuthenticated();
            })
            .formLogin(fl ->{
                fl.loginPage("/login")
                .loginProcessingUrl("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/", true)
                .permitAll();
            })
            .logout(l -> {
                l.logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);  
            })
            .exceptionHandling(eh -> eh.accessDeniedPage("/403"))
            .csrf()
            .disable();

            httpSecurity.addFilterAt(onceRequestFilter, UsernamePasswordAuthenticationFilter.class);

            return httpSecurity.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() throws Exception {
        StrictHttpFirewall firewall = new StrictHttpFirewall();

        return web ->{
            web.ignoring()
            .antMatchers(SecurityUrl.ONCE_REQUEST_URL);

            // String strHostList = property.getListAllowHost();

            // System.out.println("HOST LIST : " + strHostList);

            // Predicate<String> allowedHostNames = s -> Stream.of(strHostList.split(";")).anyMatch(t -> t.contains(s));
            // firewall.setAllowedHostnames(allowedHostNames);

            web.httpFirewall(firewall);
        };
    }
}
