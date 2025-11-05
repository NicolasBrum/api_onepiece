package brum.nicolas.api.onepiece.services;

import brum.nicolas.api.onepiece.dtos.MissaoCreationDto;
import brum.nicolas.api.onepiece.dtos.MissaoResponseDto;
import brum.nicolas.api.onepiece.entities.Missao;
import brum.nicolas.api.onepiece.entities.exceptions.MissaoNotFoundException;
import brum.nicolas.api.onepiece.entities.exceptions.PirataNotFoundException;
import brum.nicolas.api.onepiece.mappers.MissaoMapper;
import brum.nicolas.api.onepiece.repositories.MissaoRepository;
import brum.nicolas.api.onepiece.repositories.PirataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MissaoService {

    private final PirataRepository pirataRepository;
    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    @Transactional
    public void addMissao(MissaoCreationDto missaoCreationDto) {
        Long pirataId = missaoCreationDto.pirataId();

        var pirata = pirataRepository.findById(pirataId)
                .orElseThrow(() -> new PirataNotFoundException("Pirata nao encontrado!"));

        Missao missao = missaoMapper.toEntity(missaoCreationDto);
        missao.setPirata(pirata);
        missaoRepository.save(missao);
    }

    @Transactional
    public void atualizarMissao(Long id, MissaoCreationDto missaoCreationDto) {
        Long pirataId = missaoCreationDto.pirataId();

        var pirata = pirataRepository.findById(pirataId)
                .orElseThrow(() -> new PirataNotFoundException("Pirata nao encontrado!"));

        var missao = missaoRepository.findById(id)
                .orElseThrow(() -> new MissaoNotFoundException("Missao nao encontrado!"));

        missao.setPirata(pirata);
        missao.setStatusMissao(missaoCreationDto.statusMissao());
        missao.setTipoMissao(missaoCreationDto.tipoMissao());
        missao.setClassificacao(missaoCreationDto.classificacao());
    }

    @Transactional(readOnly = true)
    public List<MissaoResponseDto> getAllMissoes(){
        return missaoRepository.findAll()
                .stream()
                .map(missaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public MissaoResponseDto getMissaoById(Long id){
        return missaoMapper.toResponseDto(
                missaoRepository.findById(id)
                .orElseThrow(() -> new MissaoNotFoundException("Missao nao encontrada."))
        );
    }

    @Transactional(readOnly = true)
    public List<MissaoResponseDto> findAllByClassificacao(Missao.Classificacao classificacao){
        return missaoRepository.findAllByClassificacao(classificacao)
                .stream()
                .map(missaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    @Transactional(readOnly = true)
    public List<MissaoResponseDto> findAllByStatus(Missao.StatusMissao statusMissao){
        return missaoRepository.findAllByStatusMissao(statusMissao)
                .stream()
                .map(missaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
