package com.gisia.bffagendadortarefas.infrastructure.exceptions;


public class UnauthorizedExeception extends RuntimeException{

    public UnauthorizedExeception(String mensagem) { super(mensagem);}

    public UnauthorizedExeception(String mensagem, Throwable throwable){super(mensagem, throwable);}
}
