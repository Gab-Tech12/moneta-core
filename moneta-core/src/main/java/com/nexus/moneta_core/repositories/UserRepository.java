package com.nexus.moneta_core.repositories;

import com.nexus.moneta_core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    // Pronto, seu repositório de usuários está vivo de novo!
}