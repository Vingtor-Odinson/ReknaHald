package com.vingtor.ReknaHald.entidade;

import com.vingtor.ReknaHald.enums.tipoDespesaEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_despesas")
@Getter
@Setter
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID despesaId;

    @Column(name = "type")
    private tipoDespesaEnum type;

    @Column(name = "local")
    private String local;

    @Column(name = "value")
    private double value;

    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "chatId")
    private Usuario user;

    @Column(name = "date")
    @CreationTimestamp
    private Instant date;

    public Despesa() {
    }

    public Despesa(UUID despesaId, tipoDespesaEnum type, String local, double value, Usuario usuario, Instant date) {
        this.despesaId = despesaId;
        this.type = type;
        this.local = local;
        this.value = value;
        this.user = usuario;
        this.date = date;
    }
}
