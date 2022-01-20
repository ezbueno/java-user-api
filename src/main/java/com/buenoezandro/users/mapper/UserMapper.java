package com.buenoezandro.users.mapper;

import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;

import java.util.List;

public interface UserMapper {
    UserModel fromDTOToModel(UserModelDTO userModelDTO);

    UserModelDTO fromModelToDTO(UserModel userModel);

    List<UserModelDTO> fromModelToDTOList(List<UserModel> userModels);
}
