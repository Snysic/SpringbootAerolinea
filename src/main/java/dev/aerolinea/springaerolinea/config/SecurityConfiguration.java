package dev.aerolinea.springaerolinea.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/h2-console/**").permitAll() // Разрешаем доступ к H2 Console
                .requestMatchers("/api/v1/auth/login", "/api/v1/auth/userinfo").authenticated() // Защищенные маршруты
                .anyRequest().permitAll() // Все остальные запросы разрешены
            )
            .httpBasic() // Включаем Basic Auth
            .and()
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**") // Отключаем CSRF для H2 Console
            )
            .headers(headers -> headers
                .frameOptions(frame -> frame.sameOrigin()) // Разрешаем работу с iframe для H2 Console
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Создаем пользователей в памяти
        UserDetails user = User.builder()
                .username("user")
                .password("{noop}password") // {noop} означает, что пароль не зашифрован
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}adminpassword")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
        /*
         * @Bean
         * public InMemoryUserDetailsManager userDetailsManager() {
         * 
         * UserDetails mickey = User.builder()
         * .username("mickey")
         * .password("{noop}mouse")
         * .roles("ADMIN")
         * .build();
         * 
         * UserDetails minnie = User.builder()
         * .username("minnie")
         * .password("{noop}mouse")
         * .roles("USER")
         * .build();
         * 
         * Collection<UserDetails> users = new ArrayList<>();
         * users.add(mickey);
         * users.add(minnie);
         * 
         * return new InMemoryUserDetailsManager(users);
         * }
         */
