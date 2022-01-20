package com.buenoezandro.users.mapper;

import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;

public interface AddressMapper {
    AddressDTO fromModelToDTO(Address address);

    Address fromDTOToModel(AddressDTO addressDTO);
}
