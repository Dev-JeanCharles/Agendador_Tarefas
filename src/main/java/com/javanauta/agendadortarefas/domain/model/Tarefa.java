package com.javanauta.agendadortarefas.domain.model;

import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tarefa {
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String email;
    private LocalDateTime dataAlteracao;
    private StatusNotificacao status;
}
