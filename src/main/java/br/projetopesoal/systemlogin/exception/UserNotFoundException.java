package br.projetopesoal.systemlogin.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){
        super("Usuario nao encontrado");
    }
}
