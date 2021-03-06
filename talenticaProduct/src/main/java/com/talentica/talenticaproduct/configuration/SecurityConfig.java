package com.talentica.talenticaproduct.configuration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

import com.talentica.talenticaproduct.service.UserDetailsServiceImpl; 

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private UserDetailsServiceImpl userServiceImpl;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userServiceImpl)
        .passwordEncoder(encoder());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/product/**").hasAnyAuthority("DEVELOPER","OTHER")
                .antMatchers("/product/**").hasAnyAuthority("DEVELOPER")
                .anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(entryPoint()).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
    @Bean
    public AuthenticationEntryPoint entryPoint(){
    	return new BasicAuthenticationEntryPoint() {
    		@Override
    	    public void commence(
    	      HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) 
    	      throws IOException {
    	        response.addHeader("WWW-Authenticate", "Basic realm="+ getRealmName() +"");
    	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    	        PrintWriter writer = response.getWriter();
    	        writer.println("HTTP Status 401 - " + authEx.getMessage());
    	    }

    	    @Override
    	    public void afterPropertiesSet() {
    	        setRealmName("Talentica");
    	        super.afterPropertiesSet();
    	    }
    		
    	};
    }
    
    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
