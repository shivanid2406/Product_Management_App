/*
 * package com.product.security;
 * 
 * import javax.sql.DataSource;
 * 
 * import org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.Customizer; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.provisioning.JdbcUserDetailsManager;
 * import org.springframework.security.provisioning.UserDetailsManager; import
 * org.springframework.security.web.SecurityFilterChain;
 * 
 * @Configuration public class SecurityConfig {
 * 
 * public UserDetailsManager detailsManager(DataSource dataSource) throws
 * Exception {
 * 
 * JdbcUserDetailsManager jdbcUserDetailsManager = new
 * JdbcUserDetailsManager(dataSource); jdbcUserDetailsManager.
 * setUsersByUsernameQuery("select user_id,password,active from members where user_id=?"
 * ); jdbcUserDetailsManager.
 * setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?"
 * ); return jdbcUserDetailsManager; }
 * 
 * @Bean SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws
 * Exception {
 * 
 * httpSecurity .authorizeHttpRequests(configurer ->
 * configurer.requestMatchers("/login").hasAnyRole("admin", "user")
 * .requestMatchers("/addProduct", "/save", "/updateProduct",
 * "/deleteProduct").hasRole("ADMIN") .requestMatchers("/login",
 * "/products").hasAnyRole("EMPLOYEE", "ADMIN", "MANAGER").anyRequest()
 * .authenticated()) .formLogin(form ->
 * form.loginPage("/login").defaultSuccessUrl("/authenticateTeUser").permitAll()
 * );
 * 
 * httpSecurity.httpBasic(Customizer.withDefaults()); httpSecurity.csrf(csrf ->
 * csrf.disable()); return httpSecurity.build(); }
 * 
 * }
 */