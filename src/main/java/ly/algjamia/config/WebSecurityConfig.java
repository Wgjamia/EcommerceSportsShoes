package ly.algjamia.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;
import ly.algjamia.services.UserDetailsServiceImpl;

@Configuration
@Component
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)

@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private LoginSuccessHandler sucessHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/").permitAll()
				.antMatchers("/assets/**").permitAll()
				.antMatchers("/product_images/**").permitAll()
				.antMatchers("/profiles_images/**").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.antMatchers("/index/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/admin/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/users/**").hasAnyAuthority("SUPER_USER","ADMIN_USER")
				.anyRequest().authenticated()
				.and()
				// form login
				.csrf().disable().formLogin()
				.loginPage("/login")
				.failureUrl("/login?error=true")
				.successHandler(sucessHandler)
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutUrl("/logout")
				.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
				
				
		
		}
	
    
    @Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    
    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    } 
    
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }
   
}