package brum.nicolas.api.onepiece.services;


import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.entities.Pirata;
import brum.nicolas.api.onepiece.mappers.PirataMapper;
import brum.nicolas.api.onepiece.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PirataService {
    private final PirataRepository pirataRepository;
    private final PirataMapper pirataMapper;

    @Transactional
    public void addPirata(PirataCreationDto pirataCreationDto) {
        Pirata pirataEntity = pirataMapper.toEntity(pirataCreationDto);
        pirataRepository.save(pirataEntity);
    }

    @Transactional
    public void updatePirata(Long id,PirataCreationDto pirataCreationDto) {
        Pirata pirataEntity = findPirataById(id);
        pirataEntity.setNome(pirataCreationDto.nome());
        pirataEntity.setTripulacao(pirataCreationDto.tripulacao());
        pirataEntity.setRaca(pirataCreationDto.raca());
        pirataEntity.setStatus(pirataCreationDto.status());
    }

    @Transactional(readOnly = true)
    public Pirata findPirataById(Long id) {
        return pirataRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }
}
