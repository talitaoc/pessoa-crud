package com.talitaoc.cadastro.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("Usuário não encontrado.");
    }
}
