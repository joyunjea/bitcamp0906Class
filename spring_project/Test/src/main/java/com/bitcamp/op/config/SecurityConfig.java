package com.bitcamp.op.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.bitcamp.op.service.AccountService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AccountService accountService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		//DB에서 읽어와서 셋팅하거나 , 소스에 정해진 경로를 아래와 같이 정적으로 코딩해놓고 써도 상관없음 
		String permitAllUrl [] = {"/","/info","/account/**","/login**","logoutForm"};
		String adminUrl [] = {"/admin"};
		String userUrl [] = {"/member"};
		String loginUrl = "/login";
		String logoutUrl = "/logout";
		
		
		http.csrf().disable()
		.authorizeRequests() //HttpServletRequest 을 사용하여 접근제한 설정 가능 
		.mvcMatchers(permitAllUrl).permitAll() //모든 권한을 허용하는 Url 
		.mvcMatchers(adminUrl).hasRole("ADMIN") // "/admin" 요청은  "ADMIN 권한을 가지고 있어야 허용한다.
		.mvcMatchers(userUrl).hasRole("MEMBER")
		.anyRequest().authenticated(); // 그 외의 요청은 권한이 있기만 하면 허용한다.
		
		//권한이 없으면 로그인하라고 튕겨나갈 URL
		http.formLogin()
		.loginPage(loginUrl)
		.permitAll();
		
		//로그아웃성공하면 나갈 Url
		http.logout()
		.logoutUrl(logoutUrl)
		.logoutSuccessUrl(loginUrl)
		.invalidateHttpSession(true).deleteCookies("JSESSIONID");
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(accountService);
	}
	
	 @Bean(name = "mvcHandlerMappingIntrospector")
	    public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
	        return new HandlerMappingIntrospector();
	    }
	
	
}