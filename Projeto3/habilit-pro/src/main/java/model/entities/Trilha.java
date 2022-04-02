package model.entities;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Trilha {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Empresa empresa;

    @Column(nullable = false)
    private String ocupacao;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String apelido;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(nullable = false)
    @ToString.Exclude
    private List<Modulo> modulos;

    @Column
    private int notaSatisfacao;

    @Column
    private String anotacoes;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(nullable = false)
    private List<Trabalhador> trabalhadores;

}
