package com.nexus.moneta_core.services;

import com.nexus.moneta_core.domain.User;
import com.nexus.moneta_core.dtos.UserRequestDTO;
import com.nexus.moneta_core.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Essencial: diz ao Spring que aqui mora a inteligência
public class UserService {

    @Autowired // O Spring traz o "burro de carga" (repository) para o "gerente" (service)
    private UserRepository userRepository;

    public User create(User user) {
        // Regra de Negócio: O CPF/CNPJ na Nexus deve ter pelo menos 11 dígitos
        if (user.getDocument() == null || user.getDocument().length() < 11) {
            throw new RuntimeException("Erro: Documento inválido para abertura de conta!");
        }

        // Se passar pela regra acima, aí sim salvamos
        return userRepository.save(user);
    }
    public User fromDTO(UserRequestDTO dto) {
        User user = new User();
        user.setFullName(dto.fullName());
        user.setDocument(dto.document());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        return user;
    }
}
