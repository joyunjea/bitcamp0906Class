package com.test.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.test.vo.Account;

@Service
public class AccountService implements UserDetailsService{

	private Map<String,Account> userMaps;
	
	public AccountService() {
		// TODO Auto-generated constructor stub
		userMaps = new HashMap<String, Account>();
		
		Account account = new Account();
		account.setUsername("AdminUser");
		account.setPassword("{noop}adminpass"); //비밀번호 암복호화를 사용안할때는 앞에 {noop}라는 글자가 붙어야 한다.
		account.addRole("ADMIN");
		account.addRole("MEMBER");
		
		userMaps.put("AdminUser", account);
		
		account = new Account();
		account.setUsername("MemberUser");
		account.setPassword("{noop}memberpass"); //비밀번호 암복호화를 사용안할때는 앞에 {noop}라는 글자가 붙어야 한다.
		account.addRole("MEMBER");
		
		
		userMaps.put("MemberUser", account);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//DB로 부터 저장되어있는 정보를 가져오면 된다. 샘플이라 맵에서 가져오게 작성 
		Account account = userMaps.get(username);
		
		if(account == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return User.builder()
				.username(account.getUsername())
				.password(account.getPassword())
				.roles(account.getRole().toArray(new String[account.getRole().size()]) )
				.build();
	}
	

}
