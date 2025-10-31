package brum.nicolas.api.onepiece.mappers;


import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.dtos.PirataResponseDto;
import brum.nicolas.api.onepiece.entities.Pirata;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("singleton")
@Component
public class PirataMapper {

    public Pirata toEntity(PirataCreationDto pirataCreationDto) {
        return Pirata.builder()
                .id(null)
                .nome(pirataCreationDto.nome())
                .tripulacao(pirataCreationDto.tripulacao())
                .raca(pirataCreationDto.raca())
                .status(pirataCreationDto.status())
                .build();
    }

    public PirataResponseDto toResponseDto(Pirata pirata) {
        return new PirataResponseDto(
                pirata.getId(),
                pirata.getNome(),
                pirata.getTripulacao(),
                pirata.getRaca(),
                pirata.getStatus()
        );
    }
}
