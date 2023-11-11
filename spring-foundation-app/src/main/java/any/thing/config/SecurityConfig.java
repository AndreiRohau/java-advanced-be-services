package any.thing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.AnonymousAuthenticationWebFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User
                .withUsername("user")
                .password("user")
                .roles("USER")
                .build();
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public SecurityWebFilterChain chain(ServerHttpSecurity http) {
        return http
                .authorizeExchange(exchanges ->
                        exchanges.anyExchange().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .build();
    }

// COMMENTED SINCE spring.security.user.name is set in application.properties
//    @Bean
//    public MapReactiveUserDetailsService userDetailsService() {
//        UserDetails user = User
//                .withUsername("user")
//                .password("CHECK_PASSWORD_IS_GENERATED_IN_APP_LOGS")
//                .roles("ADMIN")
//                .build();
//        return new MapReactiveUserDetailsService(user);
//    }

    @Bean
    public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) throws Exception {
        return http
//                .anonymous().authenticationFilter(new AnonymousAuthenticationWebFilter("/actuator/**")).and()
                .authorizeExchange().pathMatchers("/actuator/**").permitAll()
                .anyExchange().authenticated()
                .and().build();
    }
}

// TOO LEGACY NOT WORKING
//@Configuration
// https://youtu.be/otcYECeFS6Y?t=1652
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .requestMatchers(EndpointRequest.to(HealthEndpoint.class))
//                .permitAll()
//                .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("USER")
//                .and().httpBasic();
//    }
//}
