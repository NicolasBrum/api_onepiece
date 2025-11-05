package brum.nicolas.api.onepiece.mappers;

import brum.nicolas.api.onepiece.dtos.MissaoCreationDto;
import brum.nicolas.api.onepiece.dtos.MissaoResponseDto;
import brum.nicolas.api.onepiece.entities.Missao;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Scope("singleton")
@Component
public class MissaoMapper {

    private final PirataMapper pirataMapper;

    public Missao toEntity(MissaoCreationDto dto) {
        return Missao.builder()
                .id(null)
                .classificacao(dto.classificacao())
                .statusMissao(dto.statusMissao())
                .tipoMissao(dto.tipoMissao())
                .build();
    }

    public MissaoResponseDto toResponseDto(Missao entity) {
        return new MissaoResponseDto(
                entity.getId(),
                entity.getClassificacao(),
                entity.getTipoMissao(),
                entity.getStatusMissao());
    }

}
