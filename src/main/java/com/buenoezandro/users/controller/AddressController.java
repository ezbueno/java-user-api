package com.buenoezandro.users.controller;

import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;
import com.buenoezandro.users.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping(path = "/{id}")
    public AddressDTO findById(@PathVariable(value = "id") Integer address_id) {
        return this.addressService.findById(address_id);
    }

    @PostMapping()
    public ResponseEntity<AddressDTO> create(@RequestBody Address address) {
        var addressDTO = this.addressService.create(address);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(addressDTO);
    }
}
