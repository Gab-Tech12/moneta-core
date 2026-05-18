package com.nexus.moneta_core.dtos;

import java.util.UUID;

// Um 'record' no Java 21 já cria os getters, construtores e tudo mais automaticamente!
public record UserResponseDTO(
        UUID id,
        String fullName,
        String email
) {
}
