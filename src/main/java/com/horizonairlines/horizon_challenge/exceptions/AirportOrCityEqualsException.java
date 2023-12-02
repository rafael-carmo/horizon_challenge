package com.horizonairlines.horizon_challenge.exceptions;

public class AirportOrCityEqualsException extends RuntimeException {
    public AirportOrCityEqualsException() {
        super("Não é possível cadastrar um voo para o mesmo aeroporto nem para mesma cidade.");
    }
}
