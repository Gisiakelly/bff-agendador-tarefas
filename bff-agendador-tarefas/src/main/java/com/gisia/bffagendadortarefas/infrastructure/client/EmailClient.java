package com.gisia.bffagendadortarefas.infrastructure.client;

import com.gisia.bffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.gisia.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.gisia.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.gisia.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.gisia.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.gisia.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.gisia.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.gisia.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    @PostMapping
    void enviarEmail(@RequestBody TarefasDTOResponse dto);
}
