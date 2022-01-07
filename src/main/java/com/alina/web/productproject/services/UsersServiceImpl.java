package com.alina.web.productproject.services;

import com.alina.web.productproject.Forms.UserForm;
import com.alina.web.productproject.Forms.WhineForm;
import com.alina.web.productproject.exceptions.UserNotFoundException;
import com.alina.web.productproject.models.User;
import com.alina.web.productproject.models.Whine;
import com.alina.web.productproject.repositories.WhinesRepository;
import com.alina.web.productproject.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final WhinesRepository whinesRepository;

//    @Autowired
//    public UsersServiceImpl(UsersRepository usersRepository, WhinesRepository whinesRepository) {
//        this.usersRepository = usersRepository;
//        this.whinesRepository = whinesRepository;
//    }

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .displayName(form.getDisplayName())
                .nickName(form.getNickName())
                .email(form.getEmail())
                .description(form.getDescription())
                .build();
        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return usersRepository.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public User getUser(Long userId) {
        return usersRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void update(Long userId, UserForm userForm) {
        User user = usersRepository.getById(userId);
        user.setDisplayName(userForm.getDisplayName());
        user.setNickName(userForm.getNickName());
        user.setEmail(userForm.getEmail());
        user.setDescription(userForm.getDescription());
        usersRepository.save(user);
    }

    @Override
    public List<Whine> getWhinesByUser(Long userId) {
        return whinesRepository.findAllByUser_IdOrderByDateDesc(userId);
    }

    @Override
    public List<Whine> getAllWhines() {
        return whinesRepository.findAllByOrderByDateDesc();
    }

    @Override
    public void deleteWhine(Long whineId, Long userId) {
        Whine whine = whinesRepository.findByIdAndUserId(whineId, userId).orElseThrow(() -> new UsernameNotFoundException("Wrong user"));;
        whinesRepository.delete(whine);
    }

    @Override
    public void addWhineToUser(Long userId, WhineForm form) {
        User user = usersRepository.getById(userId);
        Whine whine = Whine.builder()
                .message(form.getMessage())
                .user(user)
                .date(new Date())
                .build();
        whinesRepository.save(whine);
    }
}
