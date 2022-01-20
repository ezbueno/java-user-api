package com.buenoezandro.users.service.impl;

import com.buenoezandro.users.mapper.AddressMapper;
import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;
import com.buenoezandro.users.repository.AddressRepository;
import com.buenoezandro.users.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Transactional(readOnly = true)
    @Override
    public AddressDTO findById(Integer address_id) {
        var address = this.addressRepository.findById(address_id).orElse(null);
        return this.addressMapper.fromModelToDTO(address);
    }

    @Transactional
    @Override
    public AddressDTO create(Address address) {
        address = this.addressRepository.save(address);
        return this.addressMapper.fromModelToDTO(address);
    }
}
