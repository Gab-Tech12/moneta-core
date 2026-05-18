package com.nexus.moneta_core.repositories;

import com.nexus.moneta_core.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
}
