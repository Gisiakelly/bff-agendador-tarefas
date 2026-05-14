package com.gisia.bffagendadortarefas.infrastructure.client.config;

import com.gisia.bffagendadortarefas.infrastructure.exceptions.BusinessException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.ConflictException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.gisia.bffagendadortarefas.infrastructure.exceptions.UnauthorizedExeception;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.ResponseEntity;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class FeignError implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response){

        String mensagemErro = mensagemErro(response);

        switch (response.status()){
            case 409:
                return new ConflictException("Erro: " + mensagemErro);
            case 403:
                return new ResourceNotFoundException("Erro: " + mensagemErro);
            case 401:
                return new UnauthorizedExeception("Erro: " + mensagemErro);
            case 400:
                return new IllegalArgumentException("Erro: " + mensagemErro);
            default:
                return new BusinessException("Erro: " + mensagemErro);
        }
    }

    private String mensagemErro(Response response){
        try {
            if (Objects.isNull(response.body())){
                return "";
            }
            return new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
