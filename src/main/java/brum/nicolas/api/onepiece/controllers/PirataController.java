package brum.nicolas.api.onepiece.controllers;


import brum.nicolas.api.onepiece.dtos.PirataCreationDto;
import brum.nicolas.api.onepiece.services.PirataService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
}
