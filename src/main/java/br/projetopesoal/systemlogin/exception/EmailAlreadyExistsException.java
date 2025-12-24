package br.projetopesoal.systemlogin.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException() {
        super("Email ja cadastrado");
    }
}
