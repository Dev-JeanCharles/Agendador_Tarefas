package com.javanauta.agendadortarefas.application.mappers;

import com.javanauta.agendadortarefas.domain.model.Tarefa;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaEntityMapper {

    TarefasEntity domainParaEntity(Tarefa tarefa);

    Tarefa entityParaDomain(TarefasEntity entity);

    List<TarefasEntity> listaDomainParaEntity(List<Tarefa> tarefas);

    List<Tarefa> listaEntityParaDomain(List<TarefasEntity> entities);
}
