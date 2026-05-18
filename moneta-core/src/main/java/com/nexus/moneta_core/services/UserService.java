package com.nexus.moneta_core.services; // Certifique-se de manter o seu package

import com.nexus.moneta_core.domain.Account;
import com.nexus.moneta_core.domain.User;
import com.nexus.moneta_core.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Random;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AccountService accountService; // Adicionamos o serviço de conta aqui!

    // O construtor agora recebe as duas ferramentas que ele precisa para trabalhar
    public UserService(UserRepository userRepository, AccountService accountService) {
        this.userRepository = userRepository;
        this.accountService = accountService;
    }

    @Transactional // Garante que se a conta der erro, o usuário não é salvo pela metade!
    public User createUser(User user) {
        // 1. Salva o usuário primeiro para gerar o ID (UUID) dele
        User savedUser = userRepository.save(user);

        // 2. Cria o objeto da Conta Bancária vinculada a esse novo usuário
        Account newAccount = new Account();
        newAccount.setAgency("0001"); // Agência padrão do Moneta
        newAccount.setNumber(generateRandomAccountNumber()); // Gera um número de conta aleatório
        newAccount.setBalance(BigDecimal.ZERO) ; // Todo cliente começa com saldo R$ 0.00
        newAccount.setUser(savedUser); // Amarra a conta ao usuário que acabou de nascer

        // 3. Passa a conta para o AccountService validar e salvar no banco
        accountService.createAccount(newAccount);

        return savedUser;
    }

    // Método auxiliar rápido apenas para simular um número de conta de banco
    private String generateRandomAccountNumber() {
        Random random = new Random();
        int number = 100000 + random.nextInt(900000);
        int digit = random.nextInt(10);
        return number + "-" + digit;
    }
}
