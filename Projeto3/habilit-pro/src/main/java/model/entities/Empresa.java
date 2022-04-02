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
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cnpj", nullable = false)
    private String cnpj;

    @Column(name = "tipo_empresa", nullable = false)
    private EnumEmpresa tipoEmpresa;

    @Column(name = "segmento_atuacao", nullable = false)
    private SegmentoAtuacao segmentoAtuacao;

    @Column(name = "id_matriz")
    private Long idMatriz;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_empresa")
    @ToString.Exclude
    private List<Empresa> filiais;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_trilha")
    @ToString.Exclude
    private List<Trilha> trilhas;

}
