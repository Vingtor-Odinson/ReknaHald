package com.vingtor.ReknaHald.entidade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "chatId", unique = true)
    private Long chatId;

    @Column(name = "name")
    private String name;

    public Usuario(UUID id, Long chatId, String name) {
        this.id = id;
        this.chatId = chatId;
        this.name = name;
    }
}
