package spring.boot.oauth2_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/login").permitAll() // Cho phép truy cập vào trang login và OAuth2
                .anyRequest().authenticated() // Yêu cầu xác thực cho các request còn lại
            .and()
            .oauth2Login() // Kích hoạt OAuth2 login
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard", true); // Sau khi login thành công, chuyển đến dashboard
        return http.build();
    }
}
