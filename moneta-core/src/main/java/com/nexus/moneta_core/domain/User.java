package com.nexus.moneta_core.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity // Diz ao JPA que esta classe é uma tabela no banco
@Table(name = "tb_users") // Define o nome da tabela
@Getter // Cria os getters automaticamente via Lombok
@Setter // Cria os setters automaticamente via Lombok
@AllArgsConstructor // Cria o construtor com todos os campos
@NoArgsConstructor // Cria o construtor vazio (exigido pelo JPA)
@EqualsAndHashCode(of = "id") // Define que o ID é o campo de comparação
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Gera o ID automaticamente como UUID
    private UUID id;

    @Column(nullable = false) // Campo obrigatório
    private String fullName;

    @Column(unique = true, nullable = false) // CPF/CNPJ não pode repetir
    private String document;

    @Column(unique = true, nullable = false) // Email único
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean active = true; // Soft delete (nossa regra da Nexus)
}