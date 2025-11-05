package brum.nicolas.api.onepiece.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_missao")
public class Missao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

    @Enumerated(EnumType.STRING)
    private TipoMissao tipoMissao;

    @Enumerated(EnumType.STRING)
    private StatusMissao statusMissao;

    @OneToOne
    @JoinColumn(name = "pirata_id")
    private Pirata pirata;

    public enum Classificacao{
        S,
        A,
        B,
        C,
        D
    }

    public enum TipoMissao{
        EXPLORACAO,
        BATALHA_NAVAL,
        SAQUE
    }

    public enum StatusMissao{
        CONCLUIDA,
        EM_ANDAMENTO
    }
}
