package com.javanauta.agendadortarefas.adapters.out;

import com.javanauta.agendadortarefas.application.mappers.TarefaEntityMapper;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;
import com.javanauta.agendadortarefas.domain.model.Tarefa;
import com.javanauta.agendadortarefas.domain.ports.out.TarefaRepositoryPort;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import com.javanauta.agendadortarefas.infrastructure.repository.TarefasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TarefaRepositoryAdapter implements TarefaRepositoryPort {

    private final TarefasRepository repository;
    private final TarefaEntityMapper mapper;

    @Override
    public Tarefa salvar(Tarefa tarefa) {
        TarefasEntity entity = mapper.domainParaEntity(tarefa);

        return mapper.entityParaDomain(
                repository.save(entity)
        );
    }

    @Override
    public List<Tarefa> buscarTarefasPorPeriodo(LocalDateTime dataInicial,
                                                LocalDateTime dataFinal,
                                                StatusNotificacao status) {
        return mapper.listaEntityParaDomain(
                repository.findByDataEventoBetweenAndStatus(dataInicial, dataFinal, status)
        );
    }

    @Override
    public List<Tarefa> buscarPorEmail(String email) {
        return mapper.listaEntityParaDomain(
                repository.findByEmail(email)
        );
    }

    @Override
    public Optional<Tarefa> buscarPorId(String id) {
        return repository.findById(id)
                .map(mapper::entityParaDomain);
    }

    @Override
    public void deletarPorId(String id) {
        repository.deleteById(id);
    }
}
