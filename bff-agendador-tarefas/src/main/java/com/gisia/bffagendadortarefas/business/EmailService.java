package com.gisia.bffagendadortarefas.business;

import com.gisia.bffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.gisia.bffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviaEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}
