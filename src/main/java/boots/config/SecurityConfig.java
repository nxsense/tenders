//package boots.config;
//
//import boots.service.impl.UserServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private AuthenticationEntryPoint authenticationEntryPoint;
//
//    private AuthenticationProvider authenticationProvider;
//
////
////@Autowired
////private UserServiceImpl userService;
//
//    @Autowired
//    public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .userDetailsService();
//
//                auth
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER");
//    }
//
//    public void configure(HttpSecurity http) throws Exception {
//        http.httpBasic(c -> c.authenticationEntryPoint(authenticationEntryPoint))
//                .csrf().disable()
//                .authorizeRequests()
//                .mvcMatchers("/login").permitAll()
//                .anyRequest().permitAll();
//    }
//
//    public void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider);
//    }
//}