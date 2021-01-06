package com.talentica.talenticaproduct.service;


import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.talentica.talenticaproduct.model.Roles;
import com.talentica.talenticaproduct.model.Users;
import com.talentica.talenticaproduct.repository.UserRepository;

@Transactional
@Service(value = "userService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users user = null;
        if((user=userRepository.findByUserName(userName)) == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = getAuthorities(user);
        return new User(user.getUserName(), user.getUserPassword(), grantedAuthorities);
    }

    private Set<SimpleGrantedAuthority> getAuthorities(Users user) {
    	Set<Roles> roleByUserId = user.getRoles();
        final Set<SimpleGrantedAuthority> authorities = roleByUserId.stream()
        		.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
        		.collect(Collectors.toSet());
        return authorities;
    }

}
