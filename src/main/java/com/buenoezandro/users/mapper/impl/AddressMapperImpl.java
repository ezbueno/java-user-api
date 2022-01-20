package com.buenoezandro.users.mapper.impl;

import com.buenoezandro.users.mapper.AddressMapper;
import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {
    @Override
    public AddressDTO fromModelToDTO(Address address) {
        var addressDTO = new AddressDTO();
        addressDTO.setId(address.getId());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setCity(address.getCity());
        return addressDTO;
    }

    @Override
    public Address fromDTOToModel(AddressDTO addressDTO) {
        var address = new Address();
        address.setId(addressDTO.getId());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        return address;
    }
}
