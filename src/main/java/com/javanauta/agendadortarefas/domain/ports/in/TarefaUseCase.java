package com.javanauta.agendadortarefas.domain.ports.in;

import com.javanauta.agendadortarefas.application.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefaUseCase {
    TarefasDTORecord gravarTarefas(String token, TarefasDTORecord dto);

    List<TarefasDTORecord> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal);

    List<TarefasDTORecord> buscaTarefaPorEmail(String token);

    void deletaTarefaPorId(String id);

    TarefasDTORecord alteraStatus(StatusNotificacao status, String id);

    TarefasDTORecord atualizaTarefas(TarefasDTORecord dto, String id);

}
