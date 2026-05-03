package com.javanauta.agendadortarefas.application.service;

import com.javanauta.agendadortarefas.application.dto.TarefasDTORecord;
import com.javanauta.agendadortarefas.application.mappers.TarefaMapper;
import com.javanauta.agendadortarefas.domain.model.Tarefa;
import com.javanauta.agendadortarefas.domain.ports.in.TarefaUseCase;
import com.javanauta.agendadortarefas.domain.ports.out.TarefaRepositoryPort;
import com.javanauta.agendadortarefas.domain.enums.StatusNotificacao;
import com.javanauta.agendadortarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.javanauta.agendadortarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService implements TarefaUseCase {

    private final TarefaRepositoryPort repositoryPort;
    private final TarefaMapper tarefaMapper;
    private final JwtUtil jwtUtil;

    @Override
    public TarefasDTORecord gravarTarefas(String token, TarefasDTORecord dto) {
        String email = jwtUtil.extractEmailToken(token.substring(7));

        TarefasDTORecord dtoFinal = new TarefasDTORecord(null, dto.nomeTarefa(),
                dto.descricao(), LocalDateTime.now(), dto.dataEvento(), email, null,
                StatusNotificacao.PENDENTE);

        Tarefa tarefa = tarefaMapper.dtoParaDomain(dtoFinal);

        Tarefa salva = repositoryPort.salvar(tarefa);

        return tarefaMapper.domainParaDTO(salva);
    }

    @Override
    public List<TarefasDTORecord> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal) {
        return tarefaMapper.listaDomainParaDto(
                repositoryPort.buscarTarefasPorPeriodo(dataInicial, dataFinal,
                        StatusNotificacao.PENDENTE));
    }

    @Override
    public List<TarefasDTORecord> buscaTarefaPorEmail(String token) {
        String email = jwtUtil.extractEmailToken(token.substring(7));

        return tarefaMapper.listaDomainParaDto(
                repositoryPort.buscarPorEmail(email));
    }

    @Override
    public void deletaTarefaPorId(String id) {
        repositoryPort.deletarPorId(id);
    }

    @Override
    public TarefasDTORecord alteraStatus(StatusNotificacao status, String id) {
        Tarefa tarefa = repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        tarefa.setStatus(status);

        return tarefaMapper.domainParaDTO(repositoryPort.salvar(tarefa));

    }

    @Override
    public TarefasDTORecord atualizaTarefas(TarefasDTORecord dto, String id) {
            Tarefa tarefa = repositoryPort.buscarPorId(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
            tarefaMapper.atualizaDomain(dto, tarefa);

            return tarefaMapper.domainParaDTO(repositoryPort.salvar(tarefa));
    }
}
