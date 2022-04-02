package model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "funcao")
public class Funcao {

    @Id
    @Column(name = "id_funcao")
    private Integer idFuncao;

    @NonNull
    @Column(name = "nome_funcao")
    private String nomeFuncao;

}
