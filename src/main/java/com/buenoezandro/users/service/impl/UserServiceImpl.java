package com.buenoezandro.users.service.impl;

import com.buenoezandro.users.mapper.AddressMapper;
import com.buenoezandro.users.mapper.UserMapper;
import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;
import com.buenoezandro.users.repository.UserRepository;
import com.buenoezandro.users.service.AddressService;
import com.buenoezandro.users.service.UserService;
import com.buenoezandro.users.service.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Transactional(readOnly = true)
    @Override
    public List<UserModelDTO> findAllUsers() {
        var list = this.userRepository.findAll();
        return this.userMapper.fromModelToDTOList(list);
    }

    @Transactional(readOnly = true)
    @Override
    public UserModelDTO findById(Integer id) {
        var user = this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        return this.userMapper.fromModelToDTO(user);
    }

    @Transactional
    @Override
    public UserModelDTO create(Integer address_id, UserModel userModel) {
        var addressDTO = this.addressService.findById(address_id);
        var address = this.addressMapper.fromDTOToModel(addressDTO);

        userModel.setAddress(address);
        userModel = this.userRepository.save(userModel);

        return this.userMapper.fromModelToDTO(userModel);
    }

    @Transactional
    @Override
    public void update(Integer id, UserModel userModel) {
        var userDTO = this.findById(id);
        userDTO.setName(userModel.getName());
        userDTO.setOccupation(userModel.getOccupation());
        userDTO.setAge(userModel.getAge());

        var user = this.userMapper.fromDTOToModel(userDTO);
        this.userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        this.findById(id);
        this.userRepository.deleteById(id);
    }
}
