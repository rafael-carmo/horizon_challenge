package com.horizonairlines.horizon_challenge.exceptions;

public class SeatsNotAvailableException extends RuntimeException {
    public SeatsNotAvailableException() {
        super("Não existe mais assentos disponíveis para esta clase!");
    }
}
