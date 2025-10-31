package brum.nicolas.api.onepiece.controllers;


import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.dtos.PirataResponseDto;
import brum.nicolas.api.onepiece.services.PirataService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<Void> addPirata(@RequestBody PirataCreationDto pirataCreationDto, HttpServletRequest request) {
        pirataService.addPirata(pirataCreationDto);
        return ResponseEntity.created(URI.create(request.getRequestURI()))
                .build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePirata(@PathVariable Long id,@RequestBody PirataCreationDto pirataCreationDto) {
        pirataService.updatePirata(id, pirataCreationDto);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PirataResponseDto> getPirataById(@PathVariable Long id) {
        PirataResponseDto responseDto = pirataService.findPirataById(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<PirataResponseDto>> getAllPiratas() {
        var list = pirataService.findAllPiratas();
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePirata(@PathVariable Long id) {
        pirataService.deletePirata(id);
        return ResponseEntity.noContent()
                .build();
    }
}
