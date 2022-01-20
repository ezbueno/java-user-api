package com.buenoezandro.users.service.impl;

import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.repository.AddressRepository;
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
    private final AddressRepository addressRepository;

    @Transactional
    @Override
    public void create() {
        var address1 = new Address();
        address1.setId(null);
        address1.setStreet("Test 1");
        address1.setCity("Miami");

        var user1 = new UserModel();
        user1.setId(null);
        user1.setName("Ezandro");
        user1.setOccupation("Java Developer");
        user1.setAge(38);
        user1.setAddress(address1);

        var address2 = new Address();
        address2.setId(null);
        address2.setStreet("Test 2");
        address2.setCity("New York");

        var user2 = new UserModel();
        user2.setId(null);
        user2.setName("Nayara");
        user2.setOccupation("Quality Assurance Analyst");
        user2.setAge(28);
        user2.setAddress(address2);

        var users = Arrays.asList(user1, user2);
        this.userRepository.saveAll(users);

        var addresses = Arrays.asList(address1, address2);
        this.addressRepository.saveAll(addresses);
    }
}
