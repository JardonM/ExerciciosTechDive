package model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "historico_funcao")
public class HistoricoFuncao {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    @ManyToOne
    @JoinColumn(name = "funcao_id")
    private Funcao funcao;

}