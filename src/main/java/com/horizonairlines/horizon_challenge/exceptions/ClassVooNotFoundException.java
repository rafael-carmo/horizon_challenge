package com.horizonairlines.horizon_challenge.exceptions;

public class ClassVooNotFoundException extends RuntimeException {
    public ClassVooNotFoundException() {
        super("Voo deve ter pelo menos uma classe.");
    }
}
