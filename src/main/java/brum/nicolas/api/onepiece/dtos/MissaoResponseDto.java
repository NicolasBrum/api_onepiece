package brum.nicolas.api.onepiece.dtos;

import brum.nicolas.api.onepiece.entities.Missao;

public record MissaoResponseDto(
        Long id,
        Missao.Classificacao classificacao,
        Missao.TipoMissao tipoMissao,
        Missao.StatusMissao statusMissao
) {
}
