package com.nexus.moneta_core.repositories; // Ajustado para o seu plural

import com.nexus.moneta_core.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Como a Entidade Account usa Long no ID, mantemos o Long aqui!
}
