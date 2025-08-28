package com.javanauta.agendadortarefas.infrastructure.entity;

import com.javanauta.agendadortarefas.infrastructure.entity.enums.StatusNotificacao;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("tarefa")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TarefasEntity {

    @Id
    private String id;
    private String nomeTarefa;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataEvento;
    private String email;
    private LocalDateTime dataAlteracao;
    private StatusNotificacao status;
}
