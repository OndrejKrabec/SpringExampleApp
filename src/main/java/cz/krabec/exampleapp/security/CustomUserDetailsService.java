package cz.krabec.exampleapp.security;

import cz.krabec.exampleapp.entity.UserEntity;
import cz.krabec.exampleapp.entity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
          return org.springframework.security.core.userdetails.User.builder()
                .username(userEntity.getName())
                .password(userEntity.getPassword())
                .roles("USER") // Assign roles, e.g., "USER"
                .build();
    }
}
