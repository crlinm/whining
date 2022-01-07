package com.alina.web.productproject.services;

import com.alina.web.productproject.Forms.SignUpForm;
import com.alina.web.productproject.models.User;
import com.alina.web.productproject.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UsersRepository usersRepository;

    @Override
    public void signUpUser(SignUpForm form) {
        User user = User.builder()
                .displayName(form.getDisplayName())
                .nickName(form.getNickName())
                .email(form.getEmail())
                .role(User.Role.USER)
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .description(form.getDescription())
                .build();
        usersRepository.save(user);
    }
}
