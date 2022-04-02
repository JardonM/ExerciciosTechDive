package model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "avaliacao")
@Builder
public class Avaliacao {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nota", nullable = false)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "trabalhador_id")
    private Trabalhador trabalhador;

    @ManyToOne
    @JoinColumn(name = "modulo_id")
    private Modulo modulo;
    
}