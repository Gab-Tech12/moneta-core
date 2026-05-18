package com.nexus.moneta_core.domain; // Verifique se o nome do seu package está igual

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String agency;

    @Column(unique = true, nullable = false)
    private String number;

    // A Regra de Ouro do Mercado Financeiro:
    @Column(nullable = false)
    private BigDecimal balance;

    // O Relacionamento: Essa conta pertence a UM usuário.
    @OneToOne
    @JoinColumn(name = "user_id") // Essa anotação cria a coluna (Chave Estrangeira) no banco
    private User user;

    // Construtor vazio (obrigatório para o Spring/Hibernate funcionar)
    public Account() {
    }

    // (Não esqueça de gerar os Getters e Setters com o botão direito -> Generate -> Getters and Setters)
}