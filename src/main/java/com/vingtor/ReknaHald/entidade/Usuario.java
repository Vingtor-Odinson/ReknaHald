package com.vingtor.ReknaHald.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "chatId", unique = true)
    private Long chatId;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Despesa> despesas;
}
