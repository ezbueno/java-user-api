package com.buenoezandro.users.controller;

import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;
import com.buenoezandro.users.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Api(value = "USER API")
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    @ApiOperation(value = "List all registered users")
    public List<UserModelDTO> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Find user by id operation")
    public UserModelDTO findById(@PathVariable(value = "id") Integer id) {
        return this.userService.findById(id);
    }

    @PostMapping(path = "/create")
    @ApiOperation(value = "User creation operation")
    public ResponseEntity<UserModelDTO> create(
            @RequestParam(value = "address", defaultValue = "0") Integer address_id,
            @Valid @RequestBody UserModel userModel
    ) {
        var userModelDTO = this.userService.create(address_id, userModel);
        var uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/{id}").buildAndExpand(userModelDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userModelDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "/update/{id}")
    @ApiOperation(value = "User update operation")
    public void update(@PathVariable(value = "id") Integer id, @Valid @RequestBody UserModel userModel) {
        this.userService.update(id, userModel);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete/{id}")
    @ApiOperation(value = "Delete user by id operation")
    public void delete(@PathVariable(value = "id") Integer id) {
        this.userService.delete(id);
    }
}
