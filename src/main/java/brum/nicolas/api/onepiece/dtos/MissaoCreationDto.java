package brum.nicolas.api.onepiece.dtos;

import brum.nicolas.api.onepiece.entities.Missao;
import jakarta.validation.constraints.NotNull;

public record MissaoCreationDto(
        @NotNull(message = "id do pirata precisa estar preenchido!")
        Long pirataId,
        @NotNull(message = "classificacao da missao precisa estar preenchida!")
        Missao.Classificacao classificacao,
        @NotNull(message = "tipo de missao precisa estar preenchida!")
        Missao.TipoMissao tipoMissao,
        @NotNull(message = "status da misssao precisa estar preenchida!")
        Missao.StatusMissao statusMissao
) {
}
