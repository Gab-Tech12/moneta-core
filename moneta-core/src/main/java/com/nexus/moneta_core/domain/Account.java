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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // (Não esqueça de gerar os Getters e Setters com o botão direito -> Generate -> Getters and Setters)
}