package ru.javamentor.preproject.controller;

import ru.javamentor.preproject.model.UserDto;
import ru.javamentor.preproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class RestAdminController {
    private final UserService userService;

    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        if ("".equals(userDto.getUsername()) ||
                "".equals(userDto.getPassword()) ||
                "".equals(userDto.getEmail()) ||
                userDto.getRoles().length == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<UserDto> optionalUserDto = userService.saveUser(userDto);
        if (optionalUserDto.isPresent()) {
            return new ResponseEntity<>(optionalUserDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
        Optional<UserDto> optionalUserDto = userService.updateUser(userDto);
        if (optionalUserDto.isPresent()) {
            return new ResponseEntity<>(optionalUserDto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}