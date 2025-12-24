package br.projetopesoal.systemlogin.dto;

public record AuthResponse (
    String token,
    String role
) {}
