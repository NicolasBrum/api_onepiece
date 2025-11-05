package brum.nicolas.api.onepiece.services;


import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.dtos.PirataResponseDto;
import brum.nicolas.api.onepiece.entities.Pirata;
import brum.nicolas.api.onepiece.entities.exceptions.PirataNotFoundException;
import brum.nicolas.api.onepiece.entities.exceptions.RacaNotFoundException;
import brum.nicolas.api.onepiece.mappers.PirataMapper;
import brum.nicolas.api.onepiece.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
        Pirata pirataEntity = findPirataEntityById(id);
        pirataEntity.setNome(pirataCreationDto.nome());
        pirataEntity.setTripulacao(pirataCreationDto.tripulacao());
        pirataEntity.setRaca(pirataCreationDto.raca());
        pirataEntity.setStatus(pirataCreationDto.status());
    }

    @Transactional(readOnly = true)
    public Pirata findPirataEntityById(Long id) {
        try{
            return pirataRepository.findById(id)
                    .orElseThrow();
        }catch(Exception ex){
            throw new PirataNotFoundException("Pirata nao encontrado!");
        }
    }

    @Transactional(readOnly = true)
    public PirataResponseDto findPirataById(Long id) {
        Pirata pirata = findPirataEntityById(id);
        return pirataMapper.toResponseDto(pirata);
    }

    @Transactional(readOnly = true)
    public List<PirataResponseDto> findAllPiratas() {
        return pirataRepository.findAll()
                .stream()
                .map(pirataMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePirata(Long id) {
        pirataRepository.deleteById(id);
    }

    @Transactional
    public List<PirataResponseDto> findPiratasByRaca(Pirata.Raca raca) {
        var piratasDto = pirataRepository.findAllByRaca(raca)
                .orElseThrow(() -> new RacaNotFoundException("Raca nao encontrada!"));

        return piratasDto.stream()
                .map(pirataMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
