package com.javanauta.agendadortarefas.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;

import java.time.LocalDateTime;

public record TarefasDTORecord(String id,
                               String nomeTarefa,
                               String descricao,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataCriacao,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataEvento,
                               String email,
                               @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
                               LocalDateTime dataAlteracao,
                               StatusNotificacao status) {
}
