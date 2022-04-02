package model.entities;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Trabalhador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(name = "id_empresa", nullable = false)
    private long idEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "setor_ID", nullable = false)
    private Setor setor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "funcao_ID", nullable = false)
    private Funcao funcao;

    @Column
    private LocalDateTime ultimaAlteracaoFuncao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<HistoricoFuncao> historicoFuncoes;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_trilha")
    @ToString.Exclude
    private List<Trilha> trilhas;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_modulo")
    @ToString.Exclude
    private List<Modulo> modulos;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "trabalhador")
    private List<Avaliacao> avaliacoes;

}
