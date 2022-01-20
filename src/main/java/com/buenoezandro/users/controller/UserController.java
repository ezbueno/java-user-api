package com.buenoezandro.users.controller;

import com.buenoezandro.users.model.UserModel;
import com.buenoezandro.users.model.dto.UserModelDTO;
import com.buenoezandro.users.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserModelDTO> findAllUsers() {
        return this.userService.findAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserModelDTO findById(@PathVariable(value = "id") Integer id) {
        return this.userService.findById(id);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<UserModelDTO> create(@Valid @RequestBody UserModel userModel) {
        var userModelDTO = this.userService.create(userModel);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userModelDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userModelDTO);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable(value = "id") Integer id, @Valid @RequestBody UserModel userModel) {
        this.userService.update(id, userModel);
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id) {
        this.userService.delete(id);
    }
}
