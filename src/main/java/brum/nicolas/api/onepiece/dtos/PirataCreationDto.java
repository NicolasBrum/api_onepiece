package brum.nicolas.api.onepiece.dtos;

import brum.nicolas.api.onepiece.entities.Pirata;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PirataCreationDto(
        @NotBlank(message = "Nome precisa estar preenchido!")
        @Size(min = 3, message = "Tamanho inválido!")
        String nome,
        @NotBlank(message = "Tripulacao precisa estar preenchido!")
        String tripulacao,
        @NotNull(message = "Raca precisa estar preenchido!")
        Pirata.Raca raca,
        @NotNull(message = "Status precisa estar preenchido!")
        Pirata.Status status
) {}
