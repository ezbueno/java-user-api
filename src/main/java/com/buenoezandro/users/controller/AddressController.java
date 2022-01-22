package com.buenoezandro.users.controller;

import com.buenoezandro.users.model.Address;
import com.buenoezandro.users.model.dto.AddressDTO;
import com.buenoezandro.users.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(value = "Address")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Find address by id operation")
    public AddressDTO findById(@PathVariable(value = "id") Integer address_id) {
        return this.addressService.findById(address_id);
    }

    @PostMapping(path = "/create")
    @ApiOperation(value = "Address creation operation")
    public ResponseEntity<AddressDTO> create(@RequestBody Address address) {
        var addressDTO = this.addressService.create(address);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(addressDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "/update/{id}")
    @ApiOperation(value = "Address update operation")
    public void update(@PathVariable(value = "id") Integer id, @RequestBody Address address) {
        this.addressService.update(id, address);
    }
}
