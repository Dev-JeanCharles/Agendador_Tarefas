package com.javanauta.agendadortarefas.domain.ports.out;

import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;
import com.javanauta.agendadortarefas.domain.model.Tarefa;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TarefaRepositoryPort {
    Tarefa salvar(Tarefa tarefa);

    List<Tarefa> buscarTarefasPorPeriodo(LocalDateTime dataInicial,
                                         LocalDateTime dataFinal,
                                         StatusNotificacao status);

    List<Tarefa> buscarPorEmail(String email);

    Optional<Tarefa> buscarPorId(String id);

    void deletarPorId(String id);
}
