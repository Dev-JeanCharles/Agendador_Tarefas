package com.javanauta.agendadortarefas.application.service;

import com.javanauta.agendadortarefas.application.dto.TarefasDTO;
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
    public TarefasDTO gravarTarefas(String token, TarefasDTO dto) {
        String email = jwtUtil.extractEmailToken(token.substring(7));

        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatus(StatusNotificacao.PENDENTE);
        dto.setEmail(email);

        Tarefa tarefa = tarefaMapper.dtoParaDomain(dto);

        Tarefa salva = repositoryPort.salvar(tarefa);

        return tarefaMapper.domainParaDTO(salva);
    }

    @Override
    public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal) {
        return tarefaMapper.listaDomainParaDto(
                repositoryPort.buscarTarefasPorPeriodo(dataInicial, dataFinal,
                        StatusNotificacao.PENDENTE));
    }

    @Override
    public List<TarefasDTO> buscaTarefaPorEmail(String token) {
        String email = jwtUtil.extractEmailToken(token.substring(7));

        return tarefaMapper.listaDomainParaDto(
                repositoryPort.buscarPorEmail(email));
    }

    @Override
    public void deletaTarefaPorId(String id) {
        repositoryPort.deletarPorId(id);
    }

    @Override
    public TarefasDTO alteraStatus(StatusNotificacao status, String id) {
        Tarefa tarefa = repositoryPort.buscarPorId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));

        tarefa.setStatus(status);

        return tarefaMapper.domainParaDTO(repositoryPort.salvar(tarefa));

    }

    @Override
    public TarefasDTO atualizaTarefas(TarefasDTO dto, String id) {
            Tarefa tarefa = repositoryPort.buscarPorId(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada"));
            tarefaMapper.atualizaDomain(dto, tarefa);

            return tarefaMapper.domainParaDTO(repositoryPort.salvar(tarefa));
    }
}
