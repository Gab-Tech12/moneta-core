package com.nexus.moneta_core.domain;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "tb_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(precision = 19, scale = 2, nullable = false)
    private BigDecimal balance = BigDecimal.ZERO;

    @ManyToOne // Muitas contas podem pertencer a UM usuário
    @JoinColumn(name = "user_id") // Nome da coluna estrangeira no banco
    private User owner;

    // Vamos definir se é CONTA_CORRENTE ou POUPANCA
    private String accountType;
}
