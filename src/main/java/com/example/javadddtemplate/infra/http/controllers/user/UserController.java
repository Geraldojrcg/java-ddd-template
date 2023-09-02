package com.example.javadddtemplate.infra.http.controllers.user;

import com.example.javadddtemplate.domain.core.exceptions.ValidationException;
import com.example.javadddtemplate.infra.http.controllers.user.dto.RegisterUserDto;
import com.example.javadddtemplate.domain.user.entities.User;
import com.example.javadddtemplate.domain.user.useCases.GetAllUsersUseCaseInterface;
import com.example.javadddtemplate.domain.user.useCases.GetUserByIdUseCaseInterface;
import com.example.javadddtemplate.domain.user.useCases.RegisterUserUseCaseInterface;
import com.example.javadddtemplate.infra.http.controllers.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RegisterUserUseCaseInterface registerService;
    private final GetAllUsersUseCaseInterface getAllService;
    private final GetUserByIdUseCaseInterface getByIdService;

    @Autowired
    public UserController(
            RegisterUserUseCaseInterface registerService,
            GetAllUsersUseCaseInterface getAllService,
            GetUserByIdUseCaseInterface getByIdService) {
        this.registerService = registerService;
        this.getAllService = getAllService;
        this.getByIdService = getByIdService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterUserDto dto) {
        try {
            registerService.execute(dto.toEntity());
        } catch (ValidationException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok().body(
                getAllService.execute().stream().map(
                        UserDto::fromEntity).collect(Collectors.toList()
                )
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID id) {
        Optional<User> user;
        try {
            user = getByIdService.execute(id);
        } catch (ValidationException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok().body(UserDto.fromEntity(user.get()));
    }
}
