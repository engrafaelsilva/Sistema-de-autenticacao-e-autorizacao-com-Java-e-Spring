package br.projetopesoal.systemlogin.exception;

import java.time.LocalDateTime;

public record ApiError (
        int status,
        String error,
        String message,
        LocalDateTime timestamp
) {}
