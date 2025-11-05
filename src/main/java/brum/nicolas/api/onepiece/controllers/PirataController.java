package brum.nicolas.api.onepiece.controllers;

import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.dtos.PirataResponseDto;
import brum.nicolas.api.onepiece.entities.Pirata;
import brum.nicolas.api.onepiece.services.PirataService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/piratas")
public class PirataController {

    private final PirataService pirataService;

    @PostMapping
    public ResponseEntity<Void> addPirata(@RequestBody @Valid PirataCreationDto pirataCreationDto, HttpServletRequest request) {
        pirataService.addPirata(pirataCreationDto);
        return ResponseEntity.created(URI.create(request.getRequestURI()))
                .build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Void> updatePirata(@PathVariable Long id,@Valid @RequestBody PirataCreationDto pirataCreationDto) {
        pirataService.updatePirata(id, pirataCreationDto);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PirataResponseDto> getPirataById(@PathVariable Long id) {
        PirataResponseDto responseDto = pirataService.findPirataById(id);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> deletePirata(@PathVariable Long id) {
        pirataService.deletePirata(id);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping
    public ResponseEntity<List<PirataResponseDto>> getAllPiratas(@RequestParam(required = false) Pirata.Raca raca) {

        List<PirataResponseDto> list = raca == null ? pirataService.findAllPiratas() : pirataService.findPiratasByRaca(raca);
        return ResponseEntity.ok(list);
    }

}
