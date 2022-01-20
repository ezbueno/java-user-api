package com.buenoezandro.users.mapper.impl;

import com.buenoezandro.users.mapper.UserMapper;
import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapperImpl implements UserMapper {
    @Override
    public UserModel fromDTOToModel(UserModelDTO userModelDTO) {
        var user = new UserModel();
        user.setId(userModelDTO.getId());
        user.setName(userModelDTO.getName());
        user.setOccupation(userModelDTO.getOccupation());
        user.setAge(userModelDTO.getAge());
        return user;
    }

    @Override
    public UserModelDTO fromModelToDTO(UserModel userModel) {
        var userDTO = new UserModelDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setOccupation(userModel.getOccupation());
        userDTO.setAge(userModel.getAge());
        return userDTO;
    }

    @Override
    public List<UserModelDTO> fromModelToDTOList(List<UserModel> userModels) {
        return userModels.stream().map(this::fromModelToDTO).collect(Collectors.toList());
    }
}
