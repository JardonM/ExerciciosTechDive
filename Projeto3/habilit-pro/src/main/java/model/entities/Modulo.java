package model.entities;


import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_trilha")
    private Trilha trilha;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "habilidades", nullable = false)
    private String habilidades;

    @Column(name = "tarefa_validacao", nullable = false)
    private String tarefaValidacao;

    @Column(name = "prazo_limite", nullable = false)
    private OffsetDateTime prazoLimite;

    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "data_inicio", nullable = false)
    private OffsetDateTime dataInicio;

    @Column(name = "data_encerramento", nullable = false)
    private OffsetDateTime dataEncerramento;

    @Column(name = "dias_prazo", nullable = false)
    private int diasPrazo;
}
