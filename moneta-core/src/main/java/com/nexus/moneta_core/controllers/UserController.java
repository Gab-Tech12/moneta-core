package com.nexus.moneta_core.controllers;

import com.nexus.moneta_core.domain.User;
import com.nexus.moneta_core.dtos.UserRequestDTO;
import com.nexus.moneta_core.dtos.UserResponseDTO;
import com.nexus.moneta_core.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Avisa o Spring que esta classe vai responder a requisições da web
@RequestMapping("/users") // Define que a URL base para chegar aqui é: localhost:8080/users
public class UserController {

    @Autowired private UserService userService;

    // Diz que este método responde a requisições do tipo POST (usado para criar dados)
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO data) {
        // 1. Converte o DTO de entrada para Entidade
        User newUser = userService.fromDTO(data);

        // 2. Chama o service para salvar e validar
        User savedUser = userService.create(newUser);

        // 3. Converte para o DTO de saída e retorna
        UserResponseDTO responseDTO = new UserResponseDTO(
                savedUser.getId(),
                savedUser.getFullName(),
                savedUser.getEmail()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}