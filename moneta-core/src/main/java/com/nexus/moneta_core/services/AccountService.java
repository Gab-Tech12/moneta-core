package com.nexus.moneta_core.services; // Verifique se o seu package está exatamente assim

import com.nexus.moneta_core.domain.Account;
import com.nexus.moneta_core.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service // 👈 Este carimbo faz o erro do "Could not autowire" sumir no UserService!
public class AccountService {

    private final AccountRepository accountRepository;

    // Injeção de Dependência da ponte do banco
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    // Método que valida as regras de negócio e salva a conta
    public Account createAccount(Account account) {

        // 🚨 Regra de Ouro: Bloqueia abertura de conta com saldo negativo
        if (account.getBalance().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Não é permitido abrir uma conta com saldo inicial negativo.");
        }

        // Se passar pela validação, salva no banco de dados através do repositório
        return accountRepository.save(account);
    }
}