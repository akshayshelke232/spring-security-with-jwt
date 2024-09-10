package com.security.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.UserPrinciple;
import com.security.model.Users;
import com.security.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Users user1 = userRepo.findByUsername(username);
		
		if(user1 == null)
		{
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		
		
		return new UserPrinciple(user1);
	}

}
