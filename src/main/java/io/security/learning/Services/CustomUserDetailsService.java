package io.security.learning.Services;

import io.security.learning.Models.User;
import io.security.learning.MyUserDetails;
import io.security.learning.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = repo.findByUsername(s);
        if(!user.isPresent()){
            throw new UsernameNotFoundException("Cannot find user with username: "+s);
        }

        MyUserDetails details = user.get().toUserDetails();
        System.out.println(details);
        return user.get().toUserDetails();
    }
}
