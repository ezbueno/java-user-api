package com.buenoezandro.users.service.impl;

import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.repository.UserRepository;
import com.buenoezandro.users.service.DBService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@RequiredArgsConstructor
@Profile(value = "test")
@Service
public class DBServiceImpl implements DBService {
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void create() {
        var user1 = new UserModel();
        user1.setId(null);
        user1.setName("Ezandro");
        user1.setOccupation("Java Developer");
        user1.setAge(38);

        var user2 = new UserModel();
        user2.setId(null);
        user2.setName("Nayara");
        user2.setOccupation("Quality Assurance Analyst");
        user2.setAge(28);

        var users = Arrays.asList(user1, user2);
        this.userRepository.saveAll(users);
    }
}
