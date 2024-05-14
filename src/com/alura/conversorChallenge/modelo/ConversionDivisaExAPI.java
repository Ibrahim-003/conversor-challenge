package com.alura.conversorChallenge.modelo;

public record ConversionDivisaExAPI(String result, String base_code, String target_code,
                               double conversion_rate, double conversion_result) {
}
