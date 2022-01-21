package com.buenoezandro.users.service;

import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;

public interface AddressService {
    AddressDTO findById(Integer address_id);

    AddressDTO create(Address address);

    void update(Integer id, Address address);
}
