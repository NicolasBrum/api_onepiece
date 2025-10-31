package brum.nicolas.api.onepiece.dtos;

import brum.nicolas.api.onepiece.entities.Pirata;

public record PirataCreationDto(String nome, String tripulacao, Pirata.Raca raca, Pirata.Status status) {
}
