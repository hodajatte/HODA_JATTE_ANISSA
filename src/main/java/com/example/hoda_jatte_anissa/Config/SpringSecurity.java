package com.example.hoda_jatte_anissa.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                .requestMatchers("/Acceuil").permitAll()
                                .requestMatchers("/Index-Admin").hasAnyAuthority("Admin")
                                .requestMatchers("/Index-User").hasAnyAuthority("User")
                                .requestMatchers("/fonts/**").permitAll()
                                .requestMatchers("Form/js/global.js" ).permitAll()
                                .requestMatchers("https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" ).permitAll()
                                .requestMatchers("css/main.css" ).permitAll()
                                .requestMatchers("/Form/**" ).permitAll()
                                .requestMatchers("Form/vendor/mdi-font/css/material-design-iconic-font.min.css" ).permitAll()
                                .requestMatchers("Form/vendor/font-awesome-4.7/css/font-awesome.min.css" ).permitAll()
                                .requestMatchers("Form/vendor/jquery/jquery.min.js" ).permitAll()
                                .requestMatchers("Form/vendor/select2/select2.min.js" ).permitAll()
                                .requestMatchers("Form/vendor/datepicker/moment.min.js" ).permitAll()
                                .requestMatchers("Form/vendor/datepicker/daterangepicker.js" ).permitAll()
                               /* .requestMatchers("https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" ).permitAll()
                                /*.requestMatchers("/static/**").permitAll()*/
                                .requestMatchers("/static/css/**").permitAll()
                                .requestMatchers("/static/modules/**").permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/static/js/**").permitAll()
                                .requestMatchers("/images/favicon.png").permitAll()
                                .requestMatchers("/css/bootstrap.min.css").permitAll()
                                .requestMatchers("/style.css").permitAll()
                                .requestMatchers("/css/responsive.css").permitAll()
                                .requestMatchers("/css/colors.css").permitAll()
                                .requestMatchers("/css/bootstrap-select.css").permitAll()
                                .requestMatchers("/css/perfect-scrollbar.css").permitAll()
                                .requestMatchers("/css/custom.css").permitAll()
                                .requestMatchers("/js/semantic.min.css").permitAll()
                                .requestMatchers("/images/logo/logo.png").permitAll()
                                .requestMatchers("/js/jquery.min.js").permitAll()
                                .requestMatchers("/js/popper.min.js").permitAll()
                                .requestMatchers("/js/bootstrap.min.js").permitAll()
                                .requestMatchers("/js/animate.js").permitAll()
                                .requestMatchers("/js/bootstrap-select.js").permitAll()
                                .requestMatchers("/js/perfect-scrollbar.min.js").permitAll()
                                .requestMatchers("/js/custom.js").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/Acceuil",true)
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll())
                .exceptionHandling().accessDeniedPage("/access-denied");
        return http.build();
    }
}













                                /*.defaultSuccessUrl("/users", true)
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}*/



