package brum.nicolas.api.onepiece.entities;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "gc", name = "tb_pirata")
public class Pirata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private String tripulacao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Raca raca;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    public enum Raca {
        HUMANO,
        CIBORGUE,
        MINK,
        ANAO,
        TRITAO
    }

    public enum Status {
        ATIVO,
        CAPTURADO
    }
}
