package com.alina.web.productproject.security.details;

import com.alina.web.productproject.models.User;
import com.alina.web.productproject.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = usersRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        UsersDetailsImpl userDetails = new UsersDetailsImpl(user);
        return userDetails;
    }
}
