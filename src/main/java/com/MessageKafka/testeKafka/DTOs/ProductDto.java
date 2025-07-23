package com.MessageKafka.testeKafka.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductDto(@NotBlank String nome,@NotBlank String message, @NotBlank String email) {
}
