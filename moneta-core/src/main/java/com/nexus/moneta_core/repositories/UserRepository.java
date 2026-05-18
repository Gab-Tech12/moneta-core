package com.nexus.moneta_core.repositories;

import com.nexus.moneta_core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
