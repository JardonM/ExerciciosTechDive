package model.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "setor")
public class Setor {

    @Id
    @Column(name = "id_setor")
    private Integer idSetor;

    @Column(name = "nome_setor")
    private String nomeSetor;



}
