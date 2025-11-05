package brum.nicolas.api.onepiece.controllers;

import brum.nicolas.api.onepiece.dtos.MissaoCreationDto;
import brum.nicolas.api.onepiece.dtos.MissaoResponseDto;
import brum.nicolas.api.onepiece.entities.Missao;
import brum.nicolas.api.onepiece.services.MissaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/missoes")
public class MissaoController {

    private final MissaoService missaoService;

    @PostMapping
    public ResponseEntity<Void> criarMissao(@Valid @RequestBody MissaoCreationDto dto) {
        missaoService.addMissao(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Void> atualizarMissao(@Valid @RequestBody MissaoCreationDto dto, @PathVariable Long id) {
        missaoService.atualizarMissao(id,dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<MissaoResponseDto>> getMissoes(
            @RequestParam(required = false) Missao.Classificacao classificacao,
            @RequestParam(required = false) Missao.StatusMissao statusMissao
    ){

        List<MissaoResponseDto> missoes = null;

        if(classificacao != null){
            missoes = missaoService.findAllByClassificacao(classificacao);
        }
        if(statusMissao != null){
            missoes = missaoService.findAllByStatus(statusMissao);
        }
        if(classificacao == null && statusMissao == null){
            missoes = missaoService.getAllMissoes();
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(missoes);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<MissaoResponseDto> getMissaoById(@PathVariable Long id) {
        var missao = missaoService.getMissaoById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(missao);
    }

}
