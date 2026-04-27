package com.javanauta.agendadortarefas.domain.ports.in;

import com.javanauta.agendadortarefas.application.dto.TarefasDTO;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;

import java.time.LocalDateTime;
import java.util.List;

public interface TarefaUseCase {
    TarefasDTO gravarTarefas(String token, TarefasDTO dto);

    List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial, LocalDateTime dataFinal);

    List<TarefasDTO> buscaTarefaPorEmail(String token);

    void deletaTarefaPorId(String id);

    TarefasDTO alteraStatus(StatusNotificacao status, String id);

    TarefasDTO atualizaTarefas(TarefasDTO dto, String id);

}
